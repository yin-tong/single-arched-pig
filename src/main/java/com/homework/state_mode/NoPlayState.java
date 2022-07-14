package com.homework.state_mode;

import com.homework.responsibility_mode.Player;

import java.io.Serializable;

public class NoPlayState implements Serializable,State{
    @Override
    public void doAction(Player player) throws InterruptedException {
        if (player.getName().equals(player.getName2())){
            player.setCurrentState(Player.playState);
            player.getCurrentState().doAction(player);
        }else {
            if (player.getNextHandler()!=null){
                player.getNextHandler().handleRequest(player.getName2(), player.getFirstCard());
            }
        }
    }
}
