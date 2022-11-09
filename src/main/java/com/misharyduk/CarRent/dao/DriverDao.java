package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Driver;

import java.util.List;

public interface DriverDao {

    boolean addDriver(Driver driver);

    Driver getDriver(int id);

    Driver getDriverByName(String name);

    List<Driver> getDrivers();

    boolean deleteDriver(int id);

    boolean updateDriver(Driver driver);

    void setCarForDriver(int driver_id, int car_id);

    Driver getDriverByRentCar(int car_id);

}
