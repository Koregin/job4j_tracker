package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java: Руководство для начинающих", 809);
        Book book2 = new Book("Java: Том1. Основы", 900);
        Book book3 = new Book("Java: Том2. Расширенные средства программирования", 920);
        Book book4 = new Book("Clean code", 500);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ", страниц - " + bk.getPages());
        }
        Book temp = new Book("", 0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ", страниц - " + bk.getPages());
        }
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + ", страниц - " + bk.getPages());
            }
        }
    }
}
