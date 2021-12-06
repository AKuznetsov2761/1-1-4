package jm.task.core.jdbc.util;


import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static SessionFactory sessionFactory;
    private final String USER = "root";
    private final String PASS = "L;tn<hfqyc123";
    private final String URL = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
    private Connection connection;

    public Util () {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.err.println("Ошибка соединения : " + ex);
        }
    }

    public Connection getConnection () {
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties prop = new Properties();
                prop.put(Environment.URL, "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false");
                prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                prop.put(Environment.USER, "root");
                prop.put(Environment.PASS, "L;tn<hfqyc123");
                prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                prop.put(Environment.SHOW_SQL, "true");
                prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                prop.put(Environment.HBM2DDL_AUTO, "update");
                sessionFactory = new Configuration()
                        .addProperties(prop)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("SessionFactory creation failed" + e);
            }
        }

        return sessionFactory;
    }

}
