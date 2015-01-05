package com.overseas.core.domain.rate;

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
public class RoomRate {
    /**
     * 料金。
     */
    BigDecimal val;
    /**
     * 単位。
     */
    Currency currency;

    public static RoomRate of(@NonNull BigDecimal val, @NonNull Currency currency) {
        return new RoomRate(val, currency);
    }

    public static RoomRate of(@NonNull String val, @NonNull Currency currency) {
        return RoomRate.of(new BigDecimal(val), currency);
    }

    public static RoomRate zero(@NonNull Currency currency) {
        return RoomRate.of("0", currency);
    }

    /**
     * 足し算を行う。
     * 
     * @param rate
     * @return
     */
    public RoomRate add(@NonNull RoomRate rate) {
        checkHasSameCurrencyAs(rate);
        return RoomRate.of(val.add(rate.val), currency);
    }

    /**
     * 引き算を行う。
     * 
     * @param rate
     * @return
     */
    public RoomRate subtract(@NonNull RoomRate rate) {
        checkHasSameCurrencyAs(rate);
        return RoomRate.of(val.subtract(rate.val), currency);
    }

    /**
     * 掛け算を行う。
     * 
     * @param rate
     * @return
     */
    public RoomRate multiply(@NonNull RoomRate rate) {
        checkHasSameCurrencyAs(rate);
        return RoomRate.of(val.multiply(rate.val), currency);
    }

    /**
     * 割り算を行う。
     * 
     * @param rate
     * @return
     */
    public RoomRate divide(@NonNull RoomRate rate) {
        checkHasSameCurrencyAs(rate);
        return RoomRate.of(val.divide(rate.val), currency);
    }

    public BigDecimal toJpy() {
        return val.multiply(currency.getExchangeRate().getAmount());
    }

    private void checkHasSameCurrencyAs(RoomRate rate) {
        if (this.currency.equals(rate.currency)) {
            new IllegalArgumentException(rate.toString() + " is not same currency as " + this.toString());
        }
    }
}
