package com.qaprosoft.carina.demo.enums;

public enum PhoneBrands {
    SAMSUNG("Samsung");

    private final String value;

    PhoneBrands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
