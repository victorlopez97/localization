package com.meli.localization.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.StringJoiner;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValuesHomologationUtil {
    public static String getLanguagesAsString(Map<String, String> languages) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String language : languages.values()) {
            joiner.add(language);
        }
        return joiner.toString();
    }
}
