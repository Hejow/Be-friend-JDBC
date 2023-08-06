package com.jdbc.sql;

import com.jdbc.domain.OrderItem;
import org.junit.jupiter.api.Test;

class SQLTest {
    @Test
    void selectTest1() {
        Select select = Select.builder()
                .select(OrderItem.class)
                .where(Where.builder()
                        .condition("id")
                        .and("name")
                        .or("price")
                        .or("pizza")
                        .build())
                .build();

        System.out.println(select.getQuery());
    }

    @Test
    void selectTest2() {
        Select select = Select.builder()
                .select("name")
                .from(OrderItem.class)
                .where(Where.builder()
                        .condition("id")
                        .build())
                .build();

        System.out.println(select.getQuery());
    }

    @Test
    void insertTest() {
        Insert insert = Insert.builder()
                .into(OrderItem.class)
                .values("name", "price")
                .build();

        System.out.println(insert.getQuery());
    }

    @Test
    void updateTest() {
        Update update = Update.builder()
                .table(OrderItem.class)
                .values("name", "price")
                .build();

        System.out.println(update.getQuery());
    }

    @Test
    void deleteTest() {
        Delete delete = Delete.builder()
                .from(OrderItem.class)
                .where(
                        Where.builder()
                                .condition("id")
                                .build()
                )
                .build();

        System.out.println(delete.getQuery());
    }
}
