package com.jdbc;

import org.junit.jupiter.api.Test;

public class JdbcTest {
    @Test
    void selectTest() {
        String selectAllOrderItems = "SELECT * FROM order_items";
        Jdbc.select(selectAllOrderItems);
    }

    @Test
    void insertAllTest() {
        String insertOrderItem = "INSERT INTO order_items(order_id, name, count, price) VALUES(?, ?, ?, ?)";
        String[][] dataArray = {{"1", "chicken", "2", "15000"}};

        Jdbc.insertAll(insertOrderItem, dataArray);
    }

    @Test
    void updateTest() {
        String updateOrderItemName = "UPDATE order_items SET name = ? WHERE id = ?";
        String[][] updateNameData = {
                {"updated_chicken", "8"},
                {"updated_pizza", "9"},
                {"updated_hamburger", "10"},
        };
        Jdbc.updateAll(updateOrderItemName, updateNameData);
    }

    @Test
    void deleteTest() {
        String deleteOrderItem = "DELETE FROM order_items WHERE id = ?";
        String[][] insertData = {
                {"1", "new_chicken", "1", "15900"},
                {"1", "new_pizza", "1", "22900"},
                {"1", "new_hamburger", "1", "6900"}
        };

        Jdbc.deleteById(deleteOrderItem, 10);
    }
}
