package com.homework.abstract_factory_mode;

import com.homework.responsibility_mode.Player;

public class PlayerFactory implements AbstractFactory{
    @Override
    public  Object create(String name) {
        return new Player(name);
    }
}
