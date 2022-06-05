package com.example.exchangerate.dto;

import lombok.Data;

import java.util.Map;

@Data
public final class Rate implements Comparable<Rate> {

    private final long timestamp;
    private final Currency baseCurrency;
    private Currency currency;
    private double rate;

    public Rate(long timestamp, String base, Map<String, Double> rates) throws IllegalArgumentException {
        setCurrencyAndRate(rates);
        baseCurrency = new Currency(base);
        this.timestamp = timestamp;
    }

    private void setCurrencyAndRate(Map<String, Double> rates) throws IllegalArgumentException {
        if (rates.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }
        Map.Entry<String, Double> currencyAndRate = rates.entrySet().iterator().next();
        currency = new Currency(currencyAndRate.getKey());
        rate = currencyAndRate.getValue();
    }

    @Override
    public int compareTo(Rate o) {
        if (!(baseCurrency.equals(o.getBaseCurrency()) && currency.equals(o.getCurrency()))) {
            throw new IllegalArgumentException(this + " and " + o + " not allowed to compare");
        }
        return Double.compare(rate, o.getRate());
    }
}