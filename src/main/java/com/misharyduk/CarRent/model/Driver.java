package com.misharyduk.CarRent.model;

public class Driver {
    private int id;
    private String name;
    private Car rentCar;
    private long driverLicence;
    private CreditCard creditCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getRentCar() {
        return rentCar;
    }

    public void setRentCar(Car rentCar) {
        this.rentCar = rentCar;
    }

    public long getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(long driverLicence) {
        this.driverLicence = driverLicence;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
