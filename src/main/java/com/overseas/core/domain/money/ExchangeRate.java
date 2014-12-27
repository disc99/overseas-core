package com.overseas.core.domain.money;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class ExchangeRate {
    BigDecimal amount;
}
