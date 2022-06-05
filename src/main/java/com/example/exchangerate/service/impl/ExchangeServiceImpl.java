package com.example.exchangerate.service.impl;

import com.example.exchangerate.api.ExchangeClient;
import com.example.exchangerate.dto.NameCurrency;
import com.example.exchangerate.dto.Rate;
import com.example.exchangerate.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeClient client;

    @Value("${exchange.app_id}")
    private String appId;

    @Value("${exchange.base_currency}")
    private String baseCurrency;

    public ExchangeServiceImpl(ExchangeClient client) {
        this.client = client;
    }

    @Override
    public List<NameCurrency> getCurrencies() {
        log.info("getCurrencies");
        return new TreeMap<>(client.getCurrencies())
                .entrySet().stream()
                .map(entry -> new NameCurrency(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Rate getRateOnDate(LocalDate date, String symbols) {
        log.info("getRateOnDate {}, symbols {}", date, symbols);
        return client.getRateOnDate(date.toString(), appId, baseCurrency, symbols);
    }

    @Override
    public Rate getRateLatest(String symbols) {
        log.info("getRateLatest, symbols {}", symbols);
        return client.getRateLatest(appId, baseCurrency, symbols);
    }
}