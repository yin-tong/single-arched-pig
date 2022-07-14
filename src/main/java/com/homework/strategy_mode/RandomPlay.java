package com.homework.strategy_mode;

import com.homework.Card;
import com.homework.responsibility_mode.Player;

import java.util.List;

//第二种出牌策略：随机出牌
public class RandomPlay extends PlayStrategy {

    @Override
    public void play(Player player) {
        List<Card> cards = player.getCards();
        int id = (int)((cards.size())*Math.random());
        player.setNowPlayCard(cards.remove(id));
        System.out.println(player.getName()+"出牌:"+player.getNowPlayCard().getType()+player.getNowPlayCard().getNumber()+" 分数："+player.getNowPlayCard().getScore());
    }

    @Override
    public void setValue(Object value) {}
}
