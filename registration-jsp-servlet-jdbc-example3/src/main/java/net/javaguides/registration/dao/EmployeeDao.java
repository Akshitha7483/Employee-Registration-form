package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.javaguides.registration.model.Employee;

public class EmployeeDao {
    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        // SQL query without the 'id' column since it's auto-incremented
        String INSERT_USERS_SQL = "INSERT INTO employee (first_name, last_name, username, password, address, contact) VALUES (?, ?, ?, ?, ?, ?);";
        int result = 0;

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeregform?useSSL=false&serverTimezone=UTC", "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            // Set the values for the prepared statement
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement); // Log the prepared statement

            // Execute the query
            result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Employee registered successfully.");
            } else {
                System.out.println("Employee registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}




