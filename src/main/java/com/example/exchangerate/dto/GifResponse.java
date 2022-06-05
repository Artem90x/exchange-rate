package com.example.exchangerate.dto;

import com.example.exchangerate.exception.ClientsException;
import lombok.Data;

import java.util.Map;

@Data
public final class GifResponse {

    private final Map<String, ?> meta;
    private final Map<String, ?> data;

    public GifResponse(Map<String, ?> meta, Map<String, ?> data) {
        if ((int) meta.get("status") != 200) {
            throw new ClientsException(String.valueOf(meta.get("msg")));
        }
        this.meta = meta;
        this.data = data;
    }
}