package com.mihee.board.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class NameValue implements JsonSerializable {
    private String name;
    private String value;

    public static NameValue fromJson(String json) {
        return (NameValue) JsonUtil.fromJson(json, NameValue.class);
    }

    public String toString() {
        return this.toJson();
    }

    public boolean equals(Object target) {
        if(this== target) {
            return true;
        } else if(target!= null && this.getClass() == target.getClass()) {
            NameValue nameValue = (NameValue) target;
            return Objects.equals(this.name, nameValue.name) && Objects.equals(this.value, nameValue.value);
        } else {
            return false;
        }
    }

    public NameValue() {

    }

    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

}
