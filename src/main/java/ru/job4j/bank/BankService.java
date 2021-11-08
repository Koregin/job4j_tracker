package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает простейший банковский сервис, позволяющий создавать
 * клиентов, добавлять им счета. Переводить средства с одного счета на
 * другой.
 * @author EVGENY KOREGIN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов и их счетов осуществляется в коллекции типа
     * ассоциативная карта.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и если его нет в коллекции, то
     * он добавляется в неё.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод ищет клиента по номеру паспорта и если клиент найден, то
     * добавляется новый счет если его ещё нет.
     * @param passport номер паспорта по которому ищется клиент
     * @param account счет который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет клиента по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает найденного клиента или null если не клиент не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет по номеру паспорта и реквизитам счета
     * @param passport номер паспорта
     * @param requisite реквизиты счета
     * @return возвращает найденный счет или null если счет не найден
     */
    public Optional<Account> findByRequisite(String passport,
                                             String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод выполняет перевод средств с одного счета на другой
     * @param srcPassport номер паспорта клиента у которого списываются средства
     * @param srcRequisite реквизиты исходного счета
     * @param destPassport номер паспорта клиента кому начисляются средства
     * @param destRequisite реквизиты счета назначения
     * @param amount сумма перевода
     * @return возвращает true если средства были успешно перечислены и
     * false в случае если недостаточно средств для перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount =
                findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dstAccount =
                findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && dstAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
                dstAccount.get().setBalance(dstAccount.get()
                                    .getBalance() + amount);
                srcAccount.get().setBalance(srcAccount.get()
                                    .getBalance() - amount);
                rsl = true;
        }
        return rsl;
    }
}
