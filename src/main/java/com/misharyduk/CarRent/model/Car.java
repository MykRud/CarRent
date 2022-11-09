package com.misharyduk.CarRent.model;

public class Car {
    private int id;
    private String model;
    private int carNumber;
    private int numberOfSeats;
    private double price;
    private double distance;
    private double totalKilometrage;
    private boolean isRent = false;
    private Company company;
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTotalKilometrage() {
        return totalKilometrage;
    }

    public void setTotalKilometrage(double totalKilometrage) {
        this.totalKilometrage = totalKilometrage;
    }

    public boolean getIsRent() {
        return isRent;
    }

    public void setIsRent(boolean rent) {
        isRent = rent;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
