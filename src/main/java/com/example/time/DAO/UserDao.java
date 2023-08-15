package com.example.time.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void add(String name, String email, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/memberInfo?serverTimezone=UTC&characterEncoding=UTF-8", "root", "test1234"
        );
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user_info(name, email, password) values(?, ?, ?)"
        );
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.executeUpdate();

        ps.close();
        connection.close();
    }
}
