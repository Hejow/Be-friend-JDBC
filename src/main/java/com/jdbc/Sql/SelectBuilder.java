package com.jdbc.Sql;

import com.jdbc.util.CaseConverter;

import java.util.Arrays;

public class SelectBuilder extends SqlStartBuilder {
    private static final String SELECT = "SELECT ";

    private static String[] extractAllFieldAsSnakeCase(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(field -> CaseConverter.toSnakeCase(field))
                .toArray(String[]::new);
    }

    private final StringBuilder query;

    private SelectBuilder(String... columns) {
        this.query = new StringBuilder(SELECT);
        appendColumns(columns);
    }

    public static SelectBuilder select(String... columns) {
        return new SelectBuilder(columns);
    }

    public static SelectBuilder selectAll(Class<?> clazz) {
        String[] columns = extractAllFieldAsSnakeCase(clazz);
        return new SelectBuilder(columns);
    }

    public FromBuilder from(Table table) {
        return new FromBuilder(this, table);
    }

    @Override
    StringBuilder getQuery() {
        return query;
    }

    private void appendColumns(String... columns) {
        for (String column : columns) {
            query.append(column)
                    .append(", ");
        }
    }
}
