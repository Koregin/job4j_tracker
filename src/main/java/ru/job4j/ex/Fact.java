package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        int result = new Fact().calc(-1);
        System.out.println(result);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n should be not less than 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
