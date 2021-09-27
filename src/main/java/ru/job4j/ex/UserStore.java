package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User founduser = null;
        for (User user: users) {
            if (login.equals(user.getUsername())) {
                founduser = user;
                break;
            }
        }
        if (founduser == null) {
            throw new UserNotFoundException("Пользователь " + login + " не найден.");
        }
        return founduser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валиден");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
    }
}
