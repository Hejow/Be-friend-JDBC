package com.jdbc.after;

import com.jdbc.Sql.DeleteBuilder;
import com.jdbc.Sql.InsertBuilder;
import com.jdbc.Sql.SelectBuilder;
import com.jdbc.Sql.Table;
import com.jdbc.Sql.UpdateBuilder;
import com.jdbc.domain.OrderItem;

public class Main {
    public static void main(String[] args) {
//        String insertOrderItem = "INSERT INTO order_items(order_id, name, count, price) VALUES(?, ?, ?, ?)";
        String insertSql = InsertBuilder.insertInto(Table.ORDER_ITEMS)
                .values("order_id", "name", "count", "price")
                .build();
        System.out.println(insertSql);

//        String selectAllOrderItems = "SELECT * FROM order_items";
        String selectAllSql = SelectBuilder.selectAll(OrderItem.class)
                .from(Table.ORDER_ITEMS)
                .build();
        System.out.println(selectAllSql);


//        String selectOneOrderItems = "SELECT * FROM order_items WHERE id = ?";
        SelectBuilder.select("*")
                .from(Table.SHOPS)
                .where("id")
                .build();

//        String updateOrderItemName = "UPDATE order_items SET name = ? WHERE id = ?";
        UpdateBuilder.update(Table.ORDER_ITEMS)
                .set("name")
                .where("id")
                .build();

//        String deleteOrderItem = "DELETE FROM order_items WHERE id = ?";
        DeleteBuilder.from(Table.ORDER_ITEMS)
                .where("id");
    }
}
