package ru.job4j.oop;

public class Max {
    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public  static int max(int first, int second, int third) {
        int temp = max(second, third);
        return max(first, temp);
    }

    public  static int max(int first, int second, int third, int fourth) {
        int temp = max(second, third, fourth);
        return max(first, temp);
    }
}
