package org.sci.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private Connection conn;
    private static ConnectionUtil connectionUtil;

    private ConnectionUtil() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PROBLEME DE DRIVER!!!!");
            throw new Error("Can’t load driver. Verify CLASSPATH");
        }

        try {
            conn = DriverManager.getConnection("jdbc:h2:D:/Programs/DBeaver/DBBooks.h2", "admin", "admin");
        } catch (SQLException throwables) {
            throw new Error("Eroare de conexiune! Check user/password sau check path!");
        }
    }

    public static ConnectionUtil getInstance() {
        if (connectionUtil == null)
            connectionUtil = new ConnectionUtil();

        return connectionUtil;
    }

    public Connection getConn() {
        return conn;
    }
}
