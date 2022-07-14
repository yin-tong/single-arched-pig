package com.homework.strategy_mode;

import com.homework.Machine;
import com.homework.abstract_factory_mode.PlayerFactory;
import com.homework.heng_yuan_mode.PlayStrategyPool;
import com.homework.responsibility_mode.Player;

public class Test {

    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        Player p1 = (Player) playerFactory.create("p1");
        Player p2 = (Player) playerFactory.create("p2");
        Player p3 = (Player) playerFactory.create("p3");
        Player p4 = (Player) playerFactory.create("p4");
        p1.setNextHandle(p2);
        p2.setNextHandle(p3);
        p3.setNextHandle(p4);
        p4.setNextHandle(p1);
        Machine machine = new Machine();
        machine.dealCards(p1,p2,p3,p4);

        p1.play(PlayStrategyPool.getPlayByIndex(0));
        p2.play(PlayStrategyPool.getPlayByIndex(1));
    }
}
