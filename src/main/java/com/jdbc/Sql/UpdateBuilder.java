package com.jdbc.Sql;

public class UpdateBuilder extends SqlStartBuilder {
    private static final String UPDATE = "UPDATE ";

    private final StringBuilder query;

    private UpdateBuilder(Table table) {
        this.query = new StringBuilder(UPDATE);
        query.append(table.queryString());
    }

    public static UpdateBuilder update(Table table) {
        return new UpdateBuilder(table);
    }

    public SetBuilder set(String... columns) {
        return new SetBuilder(this, columns);
    }

    @Override
    StringBuilder getQuery() {
        return query;
    }
}
