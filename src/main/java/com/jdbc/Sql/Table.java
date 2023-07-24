package com.jdbc.Sql;

public enum Table {
    ORDERS("orders"),
    SHOPS("shops"),
    ORDER_ITEMS("order items"),
    ;

    private final String queryString;

    Table(String queryString) {
        this.queryString = queryString;
    }

    public String queryString() {
        return this.queryString;
    }
}
