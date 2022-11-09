package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Car;

import java.util.List;

public interface CarDao {

    boolean addCar(Car car);

    Car getCar(int id);

    Car getCarByNumber(int carNumber);

    Car findNearestCar();

    boolean deleteCar(int id);

    boolean updateCar(Car car);

    List<Car> getCars();

}
