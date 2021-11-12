package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println("Результат метода multiply: " + result);
        result = Calculator.minus(10);
        System.out.println("Результат метода minus: " + result);
        result = calculator.divide(30);
        System.out.println("Результат метода divide: " + result);
        result = calculator.sumAllOperation(10);
        System.out.println("Результат sumAllOperation: " + result);
    }
}
