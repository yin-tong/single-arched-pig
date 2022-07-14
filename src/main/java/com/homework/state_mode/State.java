package com.homework.state_mode;

import com.homework.responsibility_mode.Player;

public interface State {
    void doAction(Player player) throws InterruptedException;
}
