package com.homework.memo_mode;

import com.homework.responsibility_mode.Player;

import java.io.*;

public class Memo implements Serializable {

    private int round;
    private String firstName;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public Memo(){
        round = 0 ;
        firstName = "";
        player1 = new Player("");
        player1 = new Player("");
        player1 = new Player("");
        player1 = new Player("");
    }


    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }
}
