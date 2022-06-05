package com.example.exchangerate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Currency {

    @NotBlank
    @Size(min = 3, max = 3)
    private final String code;

    @Override
    public String toString() {
        return code;
    }
}