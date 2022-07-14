package com.homework;

import com.homework.abstract_factory_mode.CardFactory;
import com.homework.responsibility_mode.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//机器
public class Machine {

    private String[] cardTypes = {"黑桃","红桃","梅花","方块"};
    private String[] cardNumbers = {
            "2","3","4","5",
            "6","7","8","9","10",
            "J","Q","K","A"
    };
    private List<Card> allCards;
    private CardFactory cardFactory;

    public Machine(){
        allCards = new ArrayList<>();
        cardFactory = new CardFactory();
        for (int i=0;i<cardTypes.length;i++){
            for (int j=0;j<cardNumbers.length;j++){
                Card card = (Card) cardFactory.create(cardTypes[i]+cardNumbers[j]);
                allCards.add(card);
            }
        }
    }

    //发牌
    public void dealCards(Player player1, Player player2, Player player3, Player player4){
        Collections.shuffle(allCards);
        for (int i=0;i<allCards.size();i=i+4){
            player1.haveCard(allCards.get(i));
            player2.haveCard(allCards.get(i+1));
            player3.haveCard(allCards.get(i+2));
            player4.haveCard(allCards.get(i+3));
        }
    }

    //判断谁出的牌最大
    public Player findWhoWin(Player[] players,Player firstPlayer){
        boolean isDouble = false;
        //判断是否要翻倍
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNowPlayCard().getType().equals("梅花") && players[i].getNowPlayCard().getNumber().equals("10")){
                System.out.println("有变压器梅花10,赢者得分翻倍");
                isDouble = true;
            }
        }
        Player max = firstPlayer;
        //得到出牌最大的玩家
        for (int i=0;i<players.length;i++){
            // 排除本身
            if (!players[i].getName().equals(firstPlayer.getName())){
                //花色相同情况下判断卡片等级
                if (players[i].getNowPlayCard().getType().equals(max.getNowPlayCard().getType())&&players[i].getNowPlayCard().getGrade()>max.getNowPlayCard().getGrade()){
                    max = players[i];
                }
            }
        }
        //计算分数
        for (int i=0;i<players.length;i++){
            if (isDouble){
                max.setScore(max.getScore()+players[i].getNowPlayCard().getScore()*2);
            }else {
                max.setScore(max.getScore()+players[i].getNowPlayCard().getScore());
            }
        }
        //更新分数
        for (int i=0;i<players.length;i++){
            // 找到本身
            if (players[i].getName().equals(max.getName())){
                players[i].setScore(max.getScore());
                break;
            }
        }
        return max;
    }

    public Player findWhoFirst(Player[] players){
        for (int i=0;i<players.length;i++){
            for (int j = 0; j < players[i].getCards().size(); j++) {
                if (players[i].getCards().get(j).getType().equals("黑桃")&&players[i].getCards().get(j).getNumber().equals("3")){
                    return players[i];
                }
            }
        }
        return players[0];
    }




}
