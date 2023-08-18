package com.example.time.DAO;
import java.sql.*;

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
    public boolean checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/memberInfo?serverTimezone=UTC&characterEncoding=UTF-8", "root", "test1234"
        );
        String sql = "SELECT * from user_info where email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if(rs.next() == true){
            String pwdb = rs.getString("password");
            if(pwdb.equals(password)){
                System.out.println("Login success");
                return true;
            }
            else{
                System.out.println("Check password!");
                return false;
            }
        }
        else{
            System.out.println("No information exist!");
            return false;
        }

    }
}



