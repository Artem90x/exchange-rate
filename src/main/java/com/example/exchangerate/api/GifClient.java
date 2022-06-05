package com.example.exchangerate.api;

import com.example.exchangerate.dto.GifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy", url = "${giphy.base_url}")
public interface GifClient {

    @GetMapping
    GifResponse getRandomGif(@RequestParam String api_key, @RequestParam String tag);
}
