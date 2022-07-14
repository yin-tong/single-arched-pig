package com.homework.responsibility_mode;

import com.homework.Card;

public interface Handler {

    public void handleRequest(String name, Card firstCard) throws InterruptedException;

    public void setNextHandle(Handler Handler);
}
