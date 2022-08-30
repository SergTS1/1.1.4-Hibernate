package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.sql.*;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static String url = "jdbc:mysql://localhost:3306/table";
    private static String username = "root";
    private static String password = "Qazwsx1651";

    public static Connection getConnection() {
        Connection connection;
        try { connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private static  SessionFactory sessionFactory;

    public static  SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/table?serverTimezone=Europe/Moscow");
                properties.setProperty("hibernate.connection.username", "root");
                properties.setProperty("hibernate.connection.password", "Qazwsx1651");
                properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
                properties.setProperty("hibernate.show_sql", "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //properties.put(Environment.HBM2DDL_AUTO, "create-drop");
                // properties.setProperty("hibernate.hbm2ddl.auto", "validate");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
