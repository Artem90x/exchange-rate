package com.example.exchangerate.service;

import com.example.exchangerate.base.BasicTest;
import com.example.exchangerate.api.GifClient;
import com.example.exchangerate.dto.Gif;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.exchangerate.base.DataTest.GIPHY_RESPONSE_POSITIVE;
import static org.mockito.Mockito.*;

class GifServiceTest extends BasicTest {

    @MockBean
    private GifClient gifClient;

    @Autowired
    private GifService service;

    @Value("${giphy.positive_tag}")
    private String positive_tag;

    @Test
    void getGif() {
        when(gifClient.getRandomGif(anyString(), eq(positive_tag)))
                .thenReturn(GIPHY_RESPONSE_POSITIVE);

        Assertions.assertEquals(new Gif(GIPHY_RESPONSE_POSITIVE), service.getGif(1));
        verify(gifClient, times(1)).getRandomGif(anyString(), eq(positive_tag));
    }
}
