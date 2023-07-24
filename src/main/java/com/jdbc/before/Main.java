package com.jdbc.before;

import com.jdbc.Jdbc;

public class Main {
    public static void main(String[] args) {
        String insertOrderItem = "INSERT INTO order_items(order_id, name, count, price) VALUES(?, ?, ?, ?)";
        String selectAllOrderItems = "SELECT * FROM order_items";
        String selectOneOrderItems = "SELECT * FROM order_items WHERE id = ?";
        String updateOrderItemName = "UPDATE order_items SET name = ? WHERE id = ?";
        String deleteOrderItem = "DELETE FROM order_items WHERE id = ?";

        String[][] insertData = {
                {"1", "new_chicken", "1", "15900"},
                {"1", "new_pizza", "1", "22900"},
                {"1", "new_hamburger", "1", "6900"}
        };

        String[][] updateNameData = {
                {"updated_chicken", "8"},
                {"updated_pizza", "9"},
                {"updated_hamburger", "10"},
        };

//        insertAll(insertOrderItem, dataArray);
//        updateAll(updateOrderItemName, updateNameData);
//        deleteById(deleteOrderItem, 10);
        Jdbc.select(selectAllOrderItems);
    }
}
