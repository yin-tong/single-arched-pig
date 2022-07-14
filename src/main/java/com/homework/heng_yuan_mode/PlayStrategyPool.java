package com.homework.heng_yuan_mode;

import com.homework.Card;
import com.homework.responsibility_mode.Player;
import com.homework.strategy_mode.PlayByIndex;
import com.homework.strategy_mode.PlayByType;
import com.homework.strategy_mode.PlayStrategy;
import com.homework.strategy_mode.RandomPlay;

import java.util.HashMap;

public class PlayStrategyPool {

    //定义一个策略池
    private static HashMap<Integer, PlayStrategy> pool = new HashMap<>();

    public static PlayStrategy getPlayByType(String type) {
        if(!pool.containsKey(1)) {
            PlayByType playByType = new PlayByType();
            playByType.setValue(type);
            pool.put(1,playByType);
        }
        pool.get(1).setValue(type);
        System.out.println(pool.get(1));
        return pool.get(1);
    }

    public static PlayStrategy getRandomPlay() {
        if(!pool.containsKey(2)) {
            pool.put(2, new RandomPlay());
        }
        System.out.println(pool.get(2));
        return pool.get(2);
    }

    public static PlayStrategy getPlayByIndex(int index) {
        if(!pool.containsKey(3)) {
            PlayByIndex playByIndex = new PlayByIndex();
            playByIndex.setValue(index);
            pool.put(3,playByIndex);
        }
        pool.get(3).setValue(index);
        System.out.println(pool.get(3));
        return pool.get(3);
    }
}
