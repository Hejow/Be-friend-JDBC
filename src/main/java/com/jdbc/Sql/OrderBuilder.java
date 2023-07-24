package com.jdbc.Sql;

public class OrderBuilder implements SqlEndBuilder {
    private static final String ORDER_BY = " ORDER BY ";
    private static final String DESC = " DESC";
    private static final String ASC = " ASC";

    private final StringBuilder query;

    OrderBuilder(SqlChainingBuilder chainingBuilder, String condition) {
        this.query = chainingBuilder.getQuery();
        query.append(ORDER_BY)
                .append(condition);
    }

    public OrderBuilder desc() {
        query.append(DESC);
        return this;
    }

    public OrderBuilder asc() {
        query.append(ASC);
        return this;
    }

    @Override
    public String build() {
        return query.toString();
    }
}
