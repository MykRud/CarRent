package com.misharyduk.CarRent.dao;

import com.misharyduk.CarRent.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployee(int employee_id);

    List<Employee> getAllEmployee();
}
