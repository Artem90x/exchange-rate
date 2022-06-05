package com.example.exchangerate.controller;

import com.example.exchangerate.dto.Gif;
import com.example.exchangerate.dto.Rate;
import com.example.exchangerate.exception.ClientsException;
import com.example.exchangerate.service.ExchangeService;
import com.example.exchangerate.service.GifService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Slf4j
@Validated
@AllArgsConstructor
@RestController
@RequestMapping(value = ExchangeController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeController {

    public static final String REST_URL = "/api/gifs";
    private final ExchangeService exchangeService;
    private final GifService giphyService;

    @GetMapping("/{code}")
    public Gif getGif(@PathVariable @NotBlank @Size(min = 3, max = 3) String code) {
        log.info("getGif with code = {}", code);

        Gif gif;
        try {
            Rate rateYesterday = exchangeService.getRateOnDate(LocalDate.now().minusDays(1), code);
            Rate rateLatest = exchangeService.getRateLatest(code);
            gif = giphyService.getGif(rateYesterday.compareTo(rateLatest));
        } catch (Exception e) {
            throw new ClientsException(e.getMessage());
        }
        return gif;
    }
}