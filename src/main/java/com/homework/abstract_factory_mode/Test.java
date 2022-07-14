package com.homework.abstract_factory_mode;

import com.homework.Card;

public class Test {

    public static void main(String[] args) {
        String s = "黑桃3";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(2, 3));

        Card o = (Card) new CardFactory().create(s);
        System.out.println(o.getNumber());
        System.out.println(o.getType());
    }
}
