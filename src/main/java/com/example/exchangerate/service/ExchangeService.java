package com.example.exchangerate.service;

import com.example.exchangerate.dto.NameCurrency;
import com.example.exchangerate.dto.Rate;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeService {

    List<NameCurrency> getCurrencies();
    Rate getRateOnDate(LocalDate date, String symbols);
    Rate getRateLatest(String symbols);
}