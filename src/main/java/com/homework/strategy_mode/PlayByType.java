package com.homework.strategy_mode;

import com.homework.Card;
import com.homework.responsibility_mode.Player;

import java.util.List;

//第一种出牌策略，按照首家花色出牌
public class PlayByType extends  PlayStrategy {

    private String type;

    @Override
    public void play(Player player) {
        List<Card> cardsByType = player.findCardsByType((String) type);
        if (player.findCardsByType((String) type).size()==0){ //没有该花色
            return;
        }
        // 从相同花色的牌中选一幅
        int id = (int)((cardsByType.size())*Math.random());
        player.setNowPlayCard(cardsByType.get(id));
        player.removeCards(cardsByType.get(id));
        System.out.println(player.getName()+"出牌:"+cardsByType.get(id).getType()+cardsByType.get(id).getNumber()+" 分数："+cardsByType.get(id).getScore());
    }

    @Override
    public void setValue(Object value) {
        this.type = (String) value;
    }
}
