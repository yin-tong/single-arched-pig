package com.homework.responsibility_mode;

import com.homework.Card;
import com.homework.state_mode.NoPlayState;
import com.homework.state_mode.PlayState;
import com.homework.state_mode.State;
import com.homework.strategy_mode.PlayStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//玩家
public class Player implements Serializable,Handler {

    public static State playState = new PlayState();
    public static State noPlayState = new NoPlayState();

    //玩家名称
    private String name;
    //玩家手中的牌
    private List<Card> cards;
    //下一个玩家
    private Handler nextHandler;
    //当前出的牌
    private Card nowPlayCard;
    //分数
    private int score;

    private State currentState;

    private Card firstCard;

    private String name2;

    public Player(String name){
        this.name = name;
        cards = new ArrayList<>();
        score = 0;
        currentState = noPlayState;
    }

    //拿牌
    public void haveCard(Card card){
        cards.add(card);
    }

    //出牌
    public void play(PlayStrategy playStrategy){
        playStrategy.play(this);
    }

    @Override
    public void handleRequest(String name,Card firstCard) throws InterruptedException {
        this.setName2(name);
        this.setFirstCard(firstCard);
        this.currentState.doAction(this);
    }

    @Override
    public void setNextHandle(Handler handler) {
        this.nextHandler = handler;
    }

    public List<Card> findCardsByType(String type){
        List<Card> typeCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getType().equals(type)){
                typeCards.add(cards.get(i));
            }
        }
        return typeCards;
    }

    public void removeCards(Card card){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getType().equals(card.getType()) && cards.get(i).getNumber().equals(card.getNumber())){
                cards.remove(i);
            }
        }
    }

    public Handler getNextHandler() { return nextHandler; }

    public Card getNowPlayCard(){
        return nowPlayCard;
    }

    public void setNowPlayCard(Card nowPlayCard) {
        this.nowPlayCard = nowPlayCard;
    }

    public int getCardsNumber(){return cards.size();}

    public void setName(String name) { this.name = name; }

    public String getName(){return name;}

    public List<Card> getCards(){return cards;}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void clineCards() {
        this.cards.clear();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
