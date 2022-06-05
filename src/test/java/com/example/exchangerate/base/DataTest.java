package com.example.exchangerate.base;

import com.example.exchangerate.dto.Gif;
import com.example.exchangerate.dto.GifResponse;
import com.example.exchangerate.dto.Rate;
import com.example.exchangerate.dto.Currency;
import com.example.exchangerate.dto.NameCurrency;

import java.time.LocalDate;
import java.util.Map;

public final class DataTest {
    public static final MatcherFactory.Matcher<Gif> GIF_MATCHER = MatcherFactory.usingEqualsComparator(Gif.class);

    public static final Currency BASE_CURRENCY = new Currency("USD");
    public static final Currency JPY = new Currency("JPY");
    public static final Currency RUB = new Currency("RUB");

    public static final NameCurrency JPY_NAMED = new NameCurrency("JPY", "Japanese Yen");
    public static final NameCurrency RUB_NAMED = new NameCurrency("RUB", "Russian Ruble");

    public static final LocalDate DATE_YESTERDAY = LocalDate.now().minusDays(1);

    public static final GifResponse GIPHY_RESPONSE_POSITIVE =
            new GifResponse(Map.of("status", 200), Map.of("embed_url", "positive-gif-url"));
    public static final GifResponse GIPHY_RESPONSE_NEGATIVE =
            new GifResponse(Map.of("status", 200), Map.of("embed_url", "negative-gif-url"));

    public static final Rate JPY_RATE_YESTERDAY = new Rate(0, BASE_CURRENCY.getCode(), Map.of(JPY.getCode(), 100.0));
    public static final Rate JPY_RATE_TODAY = new Rate(0, BASE_CURRENCY.getCode(), Map.of(JPY.getCode(), 50.0));

    public static final Rate RUB_RATE_YESTERDAY = new Rate(0, BASE_CURRENCY.getCode(), Map.of(JPY.getCode(), 60.0));
    public static final Rate RUB_RATE_TODAY = new Rate(0, BASE_CURRENCY.getCode(), Map.of(JPY.getCode(), 110.0));
}