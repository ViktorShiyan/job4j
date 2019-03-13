package ru.job4j.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLStorage {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/viktorshiyan";
        String password = "password";
        String username = "postgres";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select u.name as name,r.name as rolename from users as u,role as r where u.role = r.id ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " который имеет роль " + resultSet.getString("rolename"));
            }
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
