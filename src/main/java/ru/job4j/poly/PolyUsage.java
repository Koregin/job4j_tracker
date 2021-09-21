package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Autobus();
        Vehicle[] vehicles = new Vehicle[]{plane, train, bus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
