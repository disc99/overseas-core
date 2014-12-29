package com.overseas.core.domain.money;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * 通貨を表すクラス。
 * 
 * 通貨のコード値が独自の場合を想定して、{@link java.util.Currency}とは 別クラスとして定義する。
 * 
 * @author daisuke
 *
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Currency {
    /**
     * この通貨のコード値。
     */
    String currencyCode;
    /**
     * この通貨の表示名。
     */
    String displayName;
    /**
     * この通貨の為替レート。
     */
    ExchangeRate exchangeRate;
    /**
     * この通貨で使用される小数のデフォルトの桁数
     */
    int defaultFractionDigits;
}
