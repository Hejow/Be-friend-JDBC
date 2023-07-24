package com.jdbc.Sql;

public class FromBuilder extends SqlChainingBuilder implements SqlEndBuilder {
    private static final String FROM = " FROM ";

    private final StringBuilder query;

    FromBuilder(SqlStartBuilder startBuilder, Table table) {
        this.query = startBuilder.getQuery();
        query.append(FROM)
                .append(table.queryString());
    }

    public WhereBuilder where(String condition) {
        return new WhereBuilder(this, condition);
    }

    @Override
    StringBuilder getQuery() {
        return null;
    }

    @Override
    public String build() {
        return null;
    }
}
