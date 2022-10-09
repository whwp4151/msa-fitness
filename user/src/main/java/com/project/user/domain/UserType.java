package com.project.user.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum UserType {
    GENERAL("일반회원"),
    PERSONAL("PT회원");

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
