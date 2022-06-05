package com.example.exchangerate.dto;

import lombok.Data;

@Data
public final class Gif {

    private String url;

    public Gif(GifResponse response) {
        this.url = String.valueOf(response.getData().get("embed_url"));
    }

    @Override
    public String toString() {
        return "Gif{url=" + url + "}";
    }
}