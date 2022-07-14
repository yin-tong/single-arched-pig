package com.homework.strategy_mode;

import com.homework.Card;
import com.homework.responsibility_mode.Player;

//第三种出牌策略：手动出牌
public class PlayByIndex extends PlayStrategy {

    private int index;

    @Override
    public void play(Player player) {
        Card card = player.getCards().remove(index);
        player.setNowPlayCard(card);
        System.out.println(player.getName()+"出牌:"+card.getType()+card.getNumber()+" 分数："+card.getScore());
    }

    @Override
    public void setValue(Object value) {
        this.index = (int) value;
    }
}
