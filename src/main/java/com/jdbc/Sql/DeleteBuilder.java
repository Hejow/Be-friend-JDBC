package com.jdbc.Sql;

public class DeleteBuilder extends SqlStartBuilder {
    private static final String DELETE = "DELETE ";

    private final StringBuilder query;

    private DeleteBuilder() {
        this.query = new StringBuilder(DELETE);
    }

    public static FromBuilder from(Table table) {
        return new FromBuilder(new DeleteBuilder(), table);
    }

    @Override
    StringBuilder getQuery() {
        return query;
    }
}
