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
public class Charge {
    /**
     * 料金。
     */
    BigDecimal val;
    /**
     * 単位。
     */
    Currency currency;

    public static Charge of(@NonNull BigDecimal val, @NonNull Currency currency) {
        return new Charge(val, currency);
    }

    public static Charge of(@NonNull String val, @NonNull Currency currency) {
        return Charge.of(new BigDecimal(val), currency);
    }

    public static Charge zero(@NonNull Currency currency) {
        return Charge.of("0", currency);
    }

    /**
     * 足し算を行う。
     * 
     * @param rate
     * @return
     */
    public Charge add(@NonNull Charge rate) {
        checkHasSameCurrencyAs(rate);
        return Charge.of(val.add(rate.val), currency);
    }

    /**
     * 引き算を行う。
     * 
     * @param rate
     * @return
     */
    public Charge subtract(@NonNull Charge rate) {
        checkHasSameCurrencyAs(rate);
        return Charge.of(val.subtract(rate.val), currency);
    }

    /**
     * 掛け算を行う。
     * 
     * @param rate
     * @return
     */
    public Charge multiply(@NonNull Charge rate) {
        checkHasSameCurrencyAs(rate);
        return Charge.of(val.multiply(rate.val), currency);
    }

    /**
     * 割り算を行う。
     * 
     * @param rate
     * @return
     */
    public Charge divide(@NonNull Charge rate) {
        checkHasSameCurrencyAs(rate);
        return Charge.of(val.divide(rate.val), currency);
    }

    public BigDecimal toJpy() {
        return val.multiply(currency.getExchangeRate().getAmount());
    }

    private void checkHasSameCurrencyAs(Charge rate) {
        if (this.currency.equals(rate.currency)) {
            new IllegalArgumentException(rate.toString() + " is not same currency as " + this.toString());
        }
    }
}
