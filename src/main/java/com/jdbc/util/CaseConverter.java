package com.jdbc.util;

import java.lang.reflect.Field;

public class CaseConverter {
    private static final String UNDER_BAR = "_";

    private CaseConverter() { }

    public static String toSnakeCase(Field field) {
        char[] chars = extractCharArray(field);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Character.toLowerCase(chars[0]));

        for (int i = 1; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                stringBuilder.append(UNDER_BAR);
            }
            stringBuilder.append(Character.toLowerCase(chars[i]));
        }

        return stringBuilder.toString();
    }

    private static char[] extractCharArray(Field field) {
        String name = field.getName();
        return name.toCharArray();
    }
}
