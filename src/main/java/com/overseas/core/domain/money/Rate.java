package com.overseas.core.domain.money;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

/**
 * 料金を表すクラス。
 * 
 * <p>
 * このクラスは不変かつ、属性はnot nullを保証する。
 * 
 * @author daisuke
 *
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rate {
    BigDecimal val;
    Currency currency;

    public static Rate of(@NonNull BigDecimal val, @NonNull Currency currency) {
        return new Rate(val, currency);
    }

    public static Rate of(@NonNull String val, @NonNull Currency currency) {
        return Rate.of(new BigDecimal(val), currency);
    }

    public static Rate zero(@NonNull Currency currency) {
        return Rate.of("0", currency);
    }

    /**
     * 足し算を行う。
     * 
     * @param rate
     * @return
     */
    public Rate add(@NonNull Rate rate) {
        checkHasSameCurrencyAs(rate);
        return Rate.of(val.add(rate.val), currency);
    }

    /**
     * 引き算を行う。
     * 
     * @param rate
     * @return
     */
    public Rate subtract(@NonNull Rate rate) {
        checkHasSameCurrencyAs(rate);
        return Rate.of(val.subtract(rate.val), currency);
    }

    /**
     * 掛け算を行う。
     * 
     * @param rate
     * @return
     */
    public Rate multiply(@NonNull Rate rate) {
        checkHasSameCurrencyAs(rate);
        return Rate.of(val.multiply(rate.val), currency);
    }

    /**
     * 割り算を行う。
     * 
     * @param rate
     * @return
     */
    public Rate divide(@NonNull Rate rate) {
        checkHasSameCurrencyAs(rate);
        return Rate.of(val.divide(rate.val), currency);
    }

    private void checkHasSameCurrencyAs(Rate rate) {
        if (this.currency.equals(rate.currency)) {
            new IllegalArgumentException(rate.toString() + " is not same currency as " + this.toString());
        }
    }
}
