package io.natewilcox;

public class Car {
    private String make;
    private int modelYear;

    public Car(String make, int modelYear) {
        this.make = make;
        this.modelYear = modelYear;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return this.make;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}
