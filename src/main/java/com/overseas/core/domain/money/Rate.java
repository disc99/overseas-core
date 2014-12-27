package com.overseas.core.domain.money;

import java.math.BigDecimal;

import lombok.Value;

/**
 * 料金を表すクラス。
 * 
 * @author daisuke
 *
 */
@Value
public class Rate {
    BigDecimal value;
    String currency;
}
