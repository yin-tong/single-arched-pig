package com.homework.strategy_mode;

import com.homework.responsibility_mode.Player;

public abstract class PlayStrategy {

    public abstract void play(Player player);

    public abstract void setValue(Object value);
}
