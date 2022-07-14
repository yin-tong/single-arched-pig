package com.homework.heng_yuan_mode;

import com.homework.strategy_mode.PlayStrategy;

public class Test {

    public static void main(String[] args) {
        PlayStrategy playStrategy1 = PlayStrategyPool.getPlayByIndex(1);
        System.out.println(playStrategy1);
        PlayStrategy playStrategy2 = PlayStrategyPool.getPlayByIndex(2);
        System.out.println(playStrategy2);
        System.out.println(playStrategy1.equals(playStrategy2));
    }
}
