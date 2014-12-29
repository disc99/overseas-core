package com.overseas.core.domain.date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * 日情報を表すクラス。
 * 
 * <p>
 * 日として存在しないデータは例外とする。
 * 
 * @author daisuke
 *
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DayOfMonth {
    int val;

    public static DayOfMonth of(int val) {
        checkDayOfMonth(val);
        return new DayOfMonth(val);
    }

    private static void checkDayOfMonth(int val) {
        if (val < 1 || val > 31) {
            throw new IllegalArgumentException(val + " is not day");
        }
    }
}
