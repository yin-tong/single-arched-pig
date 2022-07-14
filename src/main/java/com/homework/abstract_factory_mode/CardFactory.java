package com.homework.abstract_factory_mode;

import com.homework.Card;

public class CardFactory implements AbstractFactory{
    @Override
    public Object create(String name) {
        return new Card(name.substring(0,2),name.substring(2,name.length()));
    }
}
