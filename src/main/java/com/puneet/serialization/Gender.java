package com.puneet.serialization;

import java.io.Serializable;

public enum Gender implements Serializable {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String value;
    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
