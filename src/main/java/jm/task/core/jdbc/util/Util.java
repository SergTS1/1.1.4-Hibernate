package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Qazwsx1651";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




//    private static Statement statement;
//    private static Connection connection;

//    static {
//        try {
//            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
//
//    static {
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
//        }
//    }

//    public static Connection getConnection() {
//        return connection;
//    }
//
//    public static Statement getStatement() {
//        return statement;
//    }
}
