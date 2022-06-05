package com.example.exchangerate.service.impl;

import com.example.exchangerate.api.GifClient;
import com.example.exchangerate.dto.Gif;
import com.example.exchangerate.service.GifService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GifServiceImpl implements GifService {

    private final GifClient client;

    @Value("${giphy.api_key}")
    private String api_key;

    @Value("${giphy.positive_tag}")
    private String positive_tag;

    @Value("${giphy.negative_tag}")
    private String negative_tag;

    public GifServiceImpl(GifClient client) {
        this.client = client;
    }

    @Override
    public Gif getGif(int tag) {
        log.info("getGif with tag {}", tag);
        return new Gif(client.getRandomGif(api_key, tag < 0 ? negative_tag : positive_tag));
    }
}
