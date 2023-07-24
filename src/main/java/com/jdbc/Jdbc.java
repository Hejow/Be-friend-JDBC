package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    private static final String url = "jdbc:mysql://localhost:3305/chicken_order";
    private static final String user = "root";
    private static String password = "root1234!";

    public static void insert(String sql) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "pasta");
            preparedStatement.setInt(3, 2);
            preparedStatement.setInt(4, 8_900);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAll(String sql, String[][] dataArray) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            for (String[] data : dataArray) {
                preparedStatement.setInt(1, Integer.parseInt(data[0]));
                preparedStatement.setString(2, data[1]);
                preparedStatement.setInt(3, Integer.parseInt(data[2]));
                preparedStatement.setInt(4, Integer.parseInt(data[3]));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(String sql) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + ", " + resultSet.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String sql, String[] data) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, data[0]);
            preparedStatement.setInt(2, Integer.parseInt(data[1]));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAll(String sql, String[][] dataArray) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            for (String[] data : dataArray) {
                preparedStatement.setString(1, data[0]);
                preparedStatement.setInt(2, Integer.parseInt(data[1]));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(String sql, int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
