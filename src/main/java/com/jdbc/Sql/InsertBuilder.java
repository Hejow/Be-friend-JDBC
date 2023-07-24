package com.jdbc.Sql;

public class InsertBuilder extends SqlStartBuilder {
    private static final String INSERT_INTO = "INSERT INTO ";

    private final StringBuilder query;

    private InsertBuilder(Table table) {
        this.query = new StringBuilder(INSERT_INTO);
        query.append(table.queryString());
    }

    public static InsertBuilder insertInto(Table table) {
        return new InsertBuilder(table);
    }

    public ValueBuilder values(String... columns) {
        return new ValueBuilder(this, columns);
    }

    @Override
    StringBuilder getQuery() {
        return query;
    }
}
