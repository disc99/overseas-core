package com.overseas.core.domain.rate;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class ExchangeRate {
    Currency currency;
    BigDecimal amount;
}
