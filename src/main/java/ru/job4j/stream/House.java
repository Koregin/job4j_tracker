package ru.job4j.stream;

public class House {
    private double square;
    private int floors;
    private boolean pool;
    private String type;
    private boolean garden;
    private boolean garage;

    @Override
    public String toString() {
        return "House{"
                + "square=" + square
                + ", floors=" + floors
                + ", pool=" + pool
                + ", type='" + type + '\''
                + ", garden=" + garden
                + ", garage=" + garage
                + '}';
    }

    static class Builder {
        private double square;
        private int floors;
        private boolean pool;
        private String type;
        private boolean garden;
        private boolean garage;

        Builder buildSquare(double square) {
            this.square = square;
            return this;
        }

        Builder buildFloors(int floors) {
            this.floors = floors;
            return this;
        }

        Builder buildPool(boolean pool) {
            this.pool = pool;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildGarden(boolean garden) {
            this.garden = garden;
            return this;
        }

        Builder buildGarage(boolean garage) {
            this.garage = garage;
            return this;
        }

        House build() {
            House house = new House();
            house.square = square;
            house.floors = floors;
            house.pool = pool;
            house.type = type;
            house.garden = garden;
            house.garage = garage;
            return house;
        }
    }

    public static void main(String[] args) {
        House house = new Builder().buildSquare(250)
                .buildFloors(2)
                .buildPool(true)
                .buildType("townhouse")
                .buildGarden(true)
                .buildGarage(false)
                .build();
        System.out.println(house);
    }
}
