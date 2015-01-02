package com.overseas.core.domain.user;

/**
 * 宿泊者を表すクラス。
 * 
 * @author daisuke
 *
 */
public class Guest {

    /**
     * 大人の宿泊人数。
     */
    int adultCount;

    /**
     * 子供ベッドありの人数。
     */
    int childrenWithBedCount;

    /**
     * 子供ベッド無しの人数。
     */
    int childrenWithoutBedCount;
}
