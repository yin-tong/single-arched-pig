package com.homework;

import java.io.Serializable;

//牌
public class Card implements Serializable {
    //花色
    private String type;
    //数字或J Q K A
    private String number;
    //等级，用于判断两张牌大小
    private int grade;
    //分数
    private int score;

    public Card(String type,String number){
        this.type = type;
        this.number = number;
        if (number.equals("J")){
            this.grade = 11;
        }else if (number.equals("Q")){
            this.grade = 12;
        }else if (number.equals("K")){
            this.grade = 13;
        }else if (number.equals("A")){
            this.grade = 14;
        }else {
            this.grade = Integer.parseInt(number);
        }

        // 分配分数
        switch (this.type+this.number) {
            case "红桃5":
            case "红桃6":
            case "红桃7":
            case "红桃8":
            case "红桃9":
            case "红桃10":
                this.score = -10;
                break;
            case "红桃J":
                this.score = -20;
                break;
            case "红桃Q":
                this.score = -30;
                break;
            case "红桃K":
                this.score = -40;
                break;
            case "红桃A":
                this.score = -50;
                break;
            case "黑桃Q":    //猪
                this.score = -100;
                break;
            case "方块J":   //羊
                this.score = 100;
                break;
            default:
                this.score = 0;
                break;
        }
    }
    public String getType(){return this.type;}

    public String getNumber(){return this.number;}

    public int getGrade(){return this.grade;}

    public int getScore() {
        return score;
    }
}
