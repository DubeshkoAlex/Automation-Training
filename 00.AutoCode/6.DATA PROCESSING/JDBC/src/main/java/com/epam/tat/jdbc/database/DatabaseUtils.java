package com.epam.tat.jdbc.database;

import com.epam.tat.jdbc.exceptions.DatabaseConnectionException;
import com.epam.tat.jdbc.exceptions.DatabaseReadException;
import com.epam.tat.jdbc.exceptions.DatabaseWriteException;

import java.sql.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DatabaseUtils {

    public String tableName;
    public String url;

    public DatabaseUtils(String url, String tableName){
        this.url = url;
        this.tableName = tableName;
    }

    public void createTable() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            if (!conn.getMetaData().getTables(null, null, tableName.toUpperCase(),null).next()){
                String query = "CREATE TABLE " + tableName + "("
                        + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
                        + "Price INT,"
                        + "TourDuration INT,"
                        + "TourType VARCHAR(255),"
                        + "TransportType VARCHAR(255),"
                        + "MealType VARCHAR(255),"
                        + "PRIMARY KEY (Id))";
                stmt.execute(query);
                stmt.close();
                conn.close();
            }
        }
        catch (Exception e) {
            throw new DatabaseWriteException("Unable to create table in database: " + e.getMessage());
        }
    }

    public void dropTable() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            if (conn.getMetaData().getTables(null, null, tableName.toUpperCase(),null).next()){
                String query = "DROP TABLE " + tableName;
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            throw new DatabaseWriteException("Unable to drop table!");
        }
    }

    public Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            return DriverManager.getConnection(url);
        }
        catch (Exception e) {
            throw new DatabaseConnectionException("Connection to database couldn't be established.");
        }
    }

    public void writeDataIntoDBTable(String query){
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new DatabaseWriteException("Unable to execute query: " + query);
        }
    }

    public Map<Integer, Map<String,String>> readFromDBTable(String query){
        Map<Integer, Map<String,String>> dataRows = new HashMap<>();
        try {
            Connection conn = getConnection();
            PreparedStatement prepareStatement = conn.prepareStatement(query);
            ResultSet resultSet = prepareStatement.executeQuery();
            int columnCount = prepareStatement.getMetaData().getColumnCount();
            int rowNumber = 1;
            while (resultSet.next()){
                Map<String,String> rows = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rows.put(resultSet.getMetaData().getColumnName(i).toUpperCase(Locale.ROOT), resultSet.getString(i));
                }
                dataRows.put(rowNumber,rows);
                rowNumber++;
            }
            resultSet.close();
        } catch (Throwable e) {
            throw new DatabaseReadException("Unable to read from DB!");
        }
        return dataRows;
    }
}
