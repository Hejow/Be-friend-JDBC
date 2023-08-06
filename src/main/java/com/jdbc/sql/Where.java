package com.jdbc.sql;

import java.util.ArrayList;
import java.util.List;

public class Where implements Sql {
    static final String EMPTY = "";
    private static final String WHERE_FORMAT = " WHERE %s = ?";
    private final String where;
    private final List<String> or;
    private final List<String> and;

    private Where(String where, List<String> or, List<String> and) {
        this.where = where;
        this.or = or;
        this.and = and;
    }

    public Where(String where) {
        this(where, List.of(), List.of());
    }

    public static WhereCriteria builder() {
        return new WhereCriteria();
    }

    public static class WhereCriteria {
        private String where;

        private WhereCriteria() {
        }

        public ConditionCriteria condition(String where) {
            this.where = where;
            return new ConditionCriteria(where);
        }
    }

    public static class ConditionCriteria {
        private final String where;
        private List<String> or = new ArrayList<>();
        private List<String> and = new ArrayList<>();

        private ConditionCriteria(String where) {
            this.where = where;
        }

        public ConditionCriteria or(String onCondition) {
            this.or.add(onCondition);
            return this;
        }

        public ConditionCriteria and(String andCondition) {
            this.and.add(andCondition);
            return this;
        }

        public Where build() {
            return new Where(where, or, and);
        }
    }

    @Override
    public String getQuery() {
        String onConditions = or.isEmpty() ? "" : " OR " + String.join(" = ? OR ", or) + " = ?";
        String andConditions = and.isEmpty() ? "" : " AND " + String.join(" = ? AND ", and) + " = ?";
        return WHERE_FORMAT.formatted(where) + onConditions + andConditions;
    }
}
