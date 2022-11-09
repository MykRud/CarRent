package com.misharyduk.CarRent.dao.mysql_impl;

import com.misharyduk.CarRent.dao.CarDao;
import com.misharyduk.CarRent.dao.CompanyDao;
import com.misharyduk.CarRent.model.Car;
import com.misharyduk.CarRent.model.Company;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyDaoImpl extends CommonMySQL implements CompanyDao {
    @Override
    public Company getCompany() {
        Company company = new Company();

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM Company WHERE id=1")){
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
                company.setCity(resultSet.getString("city"));
                company.setRegion(resultSet.getString("region"));
                company.setIncome(resultSet.getInt("income"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return company;
    }

    @Override
    public void updateIncome(Company company, double price) {
        String SQLQueryToIncrease = "UPDATE Company SET income=? WHERE id="+company.getId();
        try (PreparedStatement statement = getConnection().prepareStatement(SQLQueryToIncrease)){
            statement.setDouble(1, company.getIncome() + price);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
