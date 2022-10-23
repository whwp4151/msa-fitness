package com.project.user.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum UserType {
    GENERAL("GENERAL"),
    PERSONAL("PERSONAL"),
    @JsonEnumDefaultValue
    UNKNOWN("NULL");

    private String value;

    UserType(String value){
        this.value = value;
    }

    @JsonCreator
    public static UserType from(String value) {
        for (UserType status : UserType.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
