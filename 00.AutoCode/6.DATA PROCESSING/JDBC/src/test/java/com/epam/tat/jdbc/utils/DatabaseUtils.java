package com.epam.tat.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtils {

    public static final String TABLE_NAME = "tours";
    public static final String URL = "jdbc:derby:TravelAgencyDB;create=true";

    public void refreshTable() {
        dropTable();
        createTable();
    }

    private void createTable() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE " + TABLE_NAME + "("
                    + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                    + "Price INT,"
                    + "TourDuration INT,"
                    + "TourType VARCHAR(255),"
                    + "TransportType VARCHAR(255),"
                    + "MealType VARCHAR(255),"
                    + "PRIMARY KEY (Id))";
            stmt.execute(query);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create table in database");
        }
    }

    public void dropTable() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String query = "DROP TABLE " + TABLE_NAME;
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Throwable e) {
            // Exception could be thrown in case of there is no such table in DB. Just ignore this case.
        }
    }

    private Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            throw new RuntimeException("Connection to database couldn't be established.");
        }
    }
}
