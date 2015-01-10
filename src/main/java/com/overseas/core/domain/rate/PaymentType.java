package com.overseas.core.domain.rate;

/**
 * 支払い方法を表す。
 * 
 * @author daisuke
 *
 */
public enum PaymentType {
    CASH, CARD;

    /**
     * カード決済か判定する。
     * 
     * @return
     */
    public boolean isCard() {
        return this == CARD;
    }
}
