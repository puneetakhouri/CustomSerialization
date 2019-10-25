package com.puneet.serialization;

import java.io.Serializable;

public class CustomFile implements Serializable {

    private static final long serialVersionUID = 4693775654114163536L;
    private String value1;
    private String value2;

    public CustomFile(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "CustomFile{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }
}
