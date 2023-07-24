package com.jdbc.Sql;

import static com.jdbc.Sql.SqlString.*;

public class WhereBuilder extends SqlChainingBuilder implements SqlEndBuilder {
    private static final String WHERE = " WHERE ";
    private static final String ON = " ON ";
    private static final String AND = " AND ";

    private final StringBuilder query;

    WhereBuilder(SqlChainingBuilder chainingBuilder, String condition) {
        this.query = chainingBuilder.getQuery();
        query.append(WHERE)
                .append(condition)
                .append(EQUAL)
                .append(PARAMETER);
    }

    public WhereBuilder on(String condition) {
        query.append(ON)
                .append(condition)
                .append(EQUAL)
                .append(PARAMETER);

        return this;
    }

    public WhereBuilder and(String condition) {
        query.append(AND)
                .append(condition)
                .append(EQUAL)
                .append(PARAMETER);

        return this;
    }

    public OrderBuilder orderBy(String condition) {
        return new OrderBuilder(this, condition);
    }

    @Override
    StringBuilder getQuery() {
        return query;
    }

    @Override
    public String build() {
        return query.toString();
    }
}
