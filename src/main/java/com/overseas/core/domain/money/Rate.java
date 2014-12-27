package com.overseas.core.domain.money;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

/**
 * 料金を表すクラス。
 * 
 * @author daisuke
 *
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rate {
    BigDecimal val;
    String currency;

    public static Rate of(@NonNull BigDecimal val, @NonNull String currency) {
        return new Rate(val, currency);
    }

    public static Rate of(@NonNull String val, @NonNull String currency) {
        return Rate.of(new BigDecimal(val), currency);
    }

    public static Rate zero(@NonNull String currency) {
        return Rate.of("0", currency);
    }
}
