package com.fwtcompany.desafio_uol.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum GroupType {
    JUSTICE_LEAGUE, AVENGERS;

    @JsonCreator
    public static GroupType fromValue(String value) {
        return Arrays.stream(GroupType.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor inválido para GroupType: " + value));
    }
}
