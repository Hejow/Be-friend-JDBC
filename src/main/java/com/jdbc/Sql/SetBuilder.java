package com.jdbc.Sql;

import static com.jdbc.Sql.SqlString.*;

public class SetBuilder extends SqlChainingBuilder {
    private static final String SET = " SET ";

    private final StringBuilder query;

    SetBuilder(UpdateBuilder updateBuilder, String... columns) {
        this.query = updateBuilder.getQuery();
        appendColumns(columns);
    }

    public WhereBuilder where(String condition) {
        return new WhereBuilder(this, condition);
    }

    @Override
    StringBuilder getQuery() {
        return null;
    }

    private void appendColumns(String... columns) {
        for (String column : columns) {
            query.append(column)
                    .append(EQUAL)
                    .append(PARAMETER)
                    .append(COMMA);
        }

        query.setLength(query.length() - UNNECESSARY_STRING);
    }
}
