package com.homework.state_mode;

import com.homework.heng_yuan_mode.PlayStrategyPool;
import com.homework.responsibility_mode.Player;

import java.io.Serializable;

public class PlayState implements Serializable,State{

    @Override
    public void doAction(Player player) {
        if (player.getFirstCard() == null){
            player.play(PlayStrategyPool.getRandomPlay());//随机出牌
        }else {
            player.play(PlayStrategyPool.getPlayByType(player.getFirstCard().getType()));//根据首家花色出牌
            if (player.getNowPlayCard()==null){
                player.play(PlayStrategyPool.getRandomPlay());
            }
        }
        player.setCurrentState(Player.noPlayState);
    }
}
