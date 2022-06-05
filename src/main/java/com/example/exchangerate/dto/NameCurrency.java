package com.example.exchangerate.dto;

import javax.validation.constraints.NotBlank;

public final class NameCurrency extends Currency {

    @NotBlank
    private final String name;

    public NameCurrency(String code, String name) {
        super(code);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + name;
    }
}