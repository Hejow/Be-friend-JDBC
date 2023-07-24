package com.jdbc.Sql;

import static com.jdbc.Sql.SqlString.COMMA;
import static com.jdbc.Sql.SqlString.LEFT_BRACKET;
import static com.jdbc.Sql.SqlString.PARAMETER;
import static com.jdbc.Sql.SqlString.RIGHT_BRACKET;
import static com.jdbc.Sql.SqlString.UNNECESSARY_STRING;

public class ValueBuilder implements SqlEndBuilder {
    private static final String VALUES = " VALUES ";

    private final StringBuilder query;

    ValueBuilder(InsertBuilder insertBuilder, String... columns) {
        this.query = insertBuilder.getQuery();
        appendColumns(columns);
    }

    private void appendColumns(String... columns) {
        query.append(LEFT_BRACKET);

        for (String column : columns) {
            query.append(column)
                    .append(COMMA);
        }

        query.setLength(query.length() - UNNECESSARY_STRING);
        query.append(RIGHT_BRACKET)
                .append(VALUES)
                .append(LEFT_BRACKET);

        for (int i = 0; i < columns.length; i++) {
            query.append(PARAMETER)
                    .append(COMMA);
        }

        query.setLength(query.length() - UNNECESSARY_STRING);
        query.append(RIGHT_BRACKET);
    }

    @Override
    public String build() {
        return query.toString();
    }
}
