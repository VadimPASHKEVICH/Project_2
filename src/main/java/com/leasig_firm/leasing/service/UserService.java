package com.leasing.service;

import com.leasing.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
    public int createUser(User user) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, first_name, last_name, age, user_login, user_password, agreement) VALUES (DEFAULT, ?, ?, ?, ?, ?,?)");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getAgreement());
            result = statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }
}
