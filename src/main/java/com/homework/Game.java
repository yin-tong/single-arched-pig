package com.homework;

import com.homework.abstract_factory_mode.PlayerFactory;
import com.homework.heng_yuan_mode.PlayStrategyPool;
import com.homework.memo_mode.Memo;
import com.homework.memo_mode.MemoManager;
import com.homework.responsibility_mode.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game extends JFrame{

    static Object iT;

    static String[] names = {"刘备","诸葛亮","张飞","关羽"};

    static int[][] cardPosition1 = {
            {150,90},{200,90},{250,90},{300,90},
            {350,90},{400,90},{450,90},{500,90},
            {550,90},{600,90},{650,90},{700,90},{750,90}
    };
    static int[] outPosition1 = {450,220};
    static int[][] cardPosition2 = {
            {100,235},{100,270},{100,305},{100,340},
            {100,375},{100,415},{100,450},{100,485},
            {100,520},{100,555},{100,590},{100,625},{100,655},
    };
    static int[] outPosition2 = {200,450};
    static int[][] cardPosition3 = {
            {150,800},{200,800},{250,800},{300,800},
            {350,800},{400,800},{450,800},{500,800},
            {550,800},{600,800},{650,800},{700,800},{750,800}
    };
    static int[] outPosition3 = {450,600};
    static int[][] cardPosition4 = {
            {800,235},{800,270},{800,305},{800,340},
            {800,375},{800,415},{800,450},{800,485},
            {800,520},{800,555},{800,590},{800,625},{800,655}
    };
    static int[] outPosition4 = {700,450};

    public Game(){

        ExecutorService pool = Executors.newFixedThreadPool(2);

        JPanel panel = new JPanel();
        JToolBar toolBar = new JToolBar();
        Font font = new Font("Jokerman", Font.BOLD, 20);
        Font font2 = new Font("Jokerman", Font.BOLD, 15);
        JLabel title = new JLabel("第1轮");
        title.setFont(font);
        JLabel name1 = new JLabel(names[0]);
        JLabel number1 = new JLabel("牌数:0");
        JLabel score1 = new JLabel("分数:0");
        name1.setFont(font);
        number1.setFont(font2);
        score1.setFont(font2);
        JLabel name2 = new JLabel(names[1]);
        JLabel number2 = new JLabel("牌数:0");
        JLabel score2 = new JLabel("分数:0");
        number2.setFont(font2);
        name2.setFont(font);
        score2.setFont(font2);
        JLabel name3 = new JLabel(names[2]);
        name3.setFont(font);
        JLabel number3 = new JLabel("牌数:0");
        JLabel score3 = new JLabel("分数:0");
        number3.setFont(font2);
        score3.setFont(font2);
        JLabel name4 = new JLabel(names[3]);
        name4.setFont(font);
        JLabel number4 = new JLabel("牌数:0");
        JLabel score4 = new JLabel("分数:0");
        number4.setFont(font2);
        score4.setFont(font2);
        JButton button = new JButton("发牌");
        JButton button1 = new JButton("一轮");
        JButton start = new JButton("开始");
        JButton save = new JButton("存档");
        JButton read = new JButton("读档");

        JLabel time = new JLabel("");
        time.setFont(font);
        JTextField j = new JTextField("请输入卡牌号");
        j.setActionCommand("123");
        JButton outCard = new JButton("出牌");

        JLabel win = new JLabel("");
        JLabel win2 = new JLabel("");
        win.setFont(font);
        win2.setFont(font);
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};

        panel.setLayout(null);
        toolBar.add(button);
        button.setBounds(600,0,80,30);
        button1.setBounds(700,0,80,30);
        save.setBounds(200,0,80,30);
        read.setBounds(300,0,80,30);
        start.setBounds(800,0,80,30);
        title.setBounds(450,10,100,30);

        name1.setBounds(450,50,100,30);
        number1.setBounds(500,50,100,30);
        score1.setBounds(560,50,100,30);

        name2.setBounds(10,450,100,20);
        number2.setBounds(12,480,85,30);
        score2.setBounds(12,510,85,30);

        name3.setBounds(450,930,100,20);
        number3.setBounds(500,925,90,30);
        score3.setBounds(560,925,100,30);

        name4.setBounds(890,450,100,20);
        number4.setBounds(890,480,100,30);
        score4.setBounds(890,510,85,30);

        time.setBounds(400,750,50,25);
        j.setBounds(480,750,100,25);
        outCard.setBounds(600,750,80,25);

        win2.setBounds(420,425,250,25);
        win.setBounds(450,450,200,25);

        panel.add(save);
        panel.add(read);
        panel.add(start);
        panel.add(win);
        panel.add(win2);
        panel.add(time);
        panel.add(j);
        panel.add(button);
        panel.add(button1);
        panel.add(outCard);
        panel.add(toolBar);
        panel.add(title);
        panel.add(name1);
        panel.add(number1);
        panel.add(number2);
        panel.add(number3);
        panel.add(number4);
        panel.add(score1);
        panel.add(score2);
        panel.add(score3);
        panel.add(score4);
        panel.add(name2);
        panel.add(name3);
        panel.add(name4);

        this.setTitle("拱猪");
        this.add(panel);
        this.setBounds(550,0,1000,1050);
        this.setResizable(false);
        this.setVisible(true);

        MemoManager memoManager = new MemoManager();

        PlayerFactory playerFactory = new PlayerFactory();
        Player player1 = (Player) playerFactory.create(name1.getText());
        Player player2 = (Player) playerFactory.create(name2.getText());
        Player player3 = (Player) playerFactory.create(name3.getText());
        Player player4 = (Player) playerFactory.create(name4.getText());

        Player[] players = {player1,player2,player3,player4};

        player1.setNextHandle(player2);
        player2.setNextHandle(player3);
        player3.setNextHandle(player4);
        player4.setNextHandle(player1);

        Machine machine = new Machine();

        Player[] firstPlayer = {player1}; //每轮第一个出牌玩家
        Player[] nowPlayer = {firstPlayer[0]};
        Draw draw = new Draw();
        int[] round = {1};


        //发牌
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pool.submit(()->{
                    try {
                        dealCards();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });
            }

            private void dealCards() throws IOException, InterruptedException {
                round[0] = 1;
                title.setText("第"+ round[0] +"轮");
                String path = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\null.png";
                try {
                    draw.drawImages(panel,path,outPosition1);
                    draw.drawImages(panel,path,outPosition2);
                    draw.drawImages(panel,path,outPosition3);
                    draw.drawImages(panel,path,outPosition4);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                win.setText("");
                win2.setText("");
                for (int i = 0; i < players.length; i++) {
                    players[i].setScore(0);
                    players[i].clineCards();
                }
                //为四位玩家发牌
                machine.dealCards(player1, player2, player3, player4);
                //找到谁先出
                firstPlayer[0] = machine.findWhoFirst(players);
                try {
                    number1.setText("牌数"+player1.getCardsNumber());
                    number2.setText("牌数"+player2.getCardsNumber());
                    number3.setText("牌数"+player3.getCardsNumber());
                    number4.setText("牌数"+player4.getCardsNumber());

                    score1.setText("分数"+player1.getScore());
                    score2.setText("分数"+player2.getScore());
                    score3.setText("分数"+player3.getScore());
                    score4.setText("分数"+player4.getScore());

                    showCards(player1,cardPosition1,draw,panel,50);
                    showCards(player2,cardPosition2,draw,panel,50);
                    showCards(player3,cardPosition3,draw,panel,50);
                    showNumbers(panel,numbers,draw);
                    showCards(player4,cardPosition4,draw,panel,50);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        //一轮
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pool.submit(()->{
                    try {
                        roundGame();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });
            }

            private void roundGame() throws IOException, InterruptedException {
                if (player1.getCards().size()==0||player2.getCards().size()==0||player3.getCards().size()==0||player4.getCards().size()==0){
                    Player max = players[0];
                    for (int i = 1; i < players.length; i++) {
                        if (players[i].getScore()>max.getScore()){
                            max = players[i];
                        }
                    }
                    JOptionPane.showMessageDialog(panel,"游戏结束,"+max.getName()+"赢了", "消息",JOptionPane.DEFAULT_OPTION);
                    return;
                }

                String path = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\null.png";
                draw.drawImages(panel,path,outPosition1);
                draw.drawImages(panel,path,outPosition2);
                draw.drawImages(panel,path,outPosition3);
                draw.drawImages(panel,path,outPosition4);
                win.setText("");
                win2.setText("");
                title.setText("第"+ round[0]+"轮");
                for (int i = 0; i < players.length; i++) {
                    players[i].setNowPlayCard(null);
                }

                System.out.println("===============================");
                System.out.println("第"+ round[0]+"轮");
                round[0]++;
                System.out.println(firstPlayer[0].getName()+"先出牌");

                //从第一位出牌者开始出牌
                for (int i = 0; i < 4; i++) {
                    if (i==0){ nowPlayer[0] = firstPlayer[0];}
                    String name = nowPlayer[0].getName();//该轮玩家姓名
                    if (name.equals(names[2])){ //判断是否为真人玩家
                        try {
                            for (int i1 = 12; i1 >= 1; i1--) {
                                if (player3.getNowPlayCard()!=null){
                                    break;
                                }
                                time.setText(i1+"s");
                                Thread.sleep(1000);
                            }
                            time.setText("");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (player3.getNowPlayCard()==null){
                            System.out.println("=系统自动帮助"+names[2]+"出牌=");
                            try {
                                player1.handleRequest(name,firstPlayer[0].getNowPlayCard());
                                nowPlayer[0] = (Player) nowPlayer[0].getNextHandler();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        player1.handleRequest(name,firstPlayer[0].getNowPlayCard());
                        nowPlayer[0] = (Player) nowPlayer[0].getNextHandler();
                    }
                    //界面输出
                    if (name.equals(names[0])){
                        play(player1,draw,panel,cardPosition1,number1,outPosition1,score1);
                    }else if (name.equals(names[1])){
                        play(player2,draw,panel,cardPosition2,number2,outPosition2,score2);
                    }else if (name.equals(names[2])){
                        play(player3,draw,panel,cardPosition3,number3,outPosition3,score3);
                    }else if (name.equals(names[3])){
                        play(player4,draw,panel,cardPosition4,number4,outPosition4,score4);
                    }
                }

                int i = round[0]-1;
                win2.setText("第"+ i +"轮: "+firstPlayer[0].getName()+"先出牌");
                //得到谁是最大者
                firstPlayer[0] = machine.findWhoWin(players,firstPlayer[0]);
                System.out.println(firstPlayer[0].getName()+"牌最大,分数: "+firstPlayer[0].getScore());
                win.setText(firstPlayer[0].getName()+"牌最大");

                //更新牌数和分数
                number1.setText("牌数"+player1.getCardsNumber());
                score1.setText("分数"+player1.getScore());
                number2.setText("牌数"+player2.getCardsNumber());
                score2.setText("分数"+player2.getScore());
                number3.setText("牌数"+player3.getCardsNumber());
                score3.setText("分数"+player3.getScore());
                number4.setText("牌数"+player4.getCardsNumber());
                score4.setText("分数"+player4.getScore());
            }
        });

        // 控制出牌
        outCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                try {
                    int index = Integer.parseInt(j.getText());
                    Card firstCard = firstPlayer[0].getNowPlayCard();
                    if (firstCard==null){ //第一位出牌为空
                        player3.play(PlayStrategyPool.getPlayByIndex(index-1));
                    }else {
                        List<Card> cardsByType = player3.findCardsByType(firstCard.getType());
                        if (cardsByType.size() == 0){ // 没有该花色
                            player3.play(PlayStrategyPool.getPlayByIndex(index-1));
                        }else {
                            if (player3.getCards().get(index-1).getType().equals(firstCard.getType())){
                                player3.play(PlayStrategyPool.getPlayByIndex(index-1));
                            }else {
                                i = 1;
                                JOptionPane.showMessageDialog(panel, "应该出和第一位玩家相同花色的牌", "消息",JOptionPane.DEFAULT_OPTION);
                            }
                        }
                    }
                    try {
                        play(player3,draw,panel,cardPosition3,number3,outPosition3,score3);
                        nowPlayer[0] = (Player) nowPlayer[0].getNextHandler();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                }catch (Exception e1) {
                    if (i == 0){
                        JOptionPane.showMessageDialog(panel, "没有此牌", "消息",JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });

        //输入框回车
        j.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER ){
                    outCard.doClick();
                }
            }
        });

        //存档
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Memo memo = new Memo();
                memo.setRound(round[0]);
                memo.setFirstName(firstPlayer[0].getName());
                memo.setPlayer1(player1);
                memo.setPlayer2(player2);
                memo.setPlayer3(player3);
                memo.setPlayer4(player4);
                try {
                    memoManager.save(memo);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //读档
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pool.submit(()->{
                    read();
                });
            }
            public void read() {
                try {
                    String path = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\null.png";
                    draw.drawImages(panel,path,outPosition1);
                    draw.drawImages(panel,path,outPosition2);
                    draw.drawImages(panel,path,outPosition3);
                    draw.drawImages(panel,path,outPosition4);

                    Memo memo = memoManager.read();
                    Player player11 = memo.getPlayer1();
                    Player player22 = memo.getPlayer2();
                    Player player33 = memo.getPlayer3();
                    Player player44 = memo.getPlayer4();

                    title.setText("第"+ memo.getRound() +"轮");
                    play(player11,draw,panel,cardPosition1,number1,outPosition1,score1);
                    play(player22,draw,panel,cardPosition2,number2,outPosition2,score2);
                    play(player33,draw,panel,cardPosition3,number3,outPosition3,score3);
                    play(player44,draw,panel,cardPosition4,number4,outPosition4,score4);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        //开始
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pool.submit(()->{
                    try {
                        button.doClick();
                        Thread.sleep(2000);
                        for (int i = 0; i < 14; i++) {
                            button1.doClick();
                            Thread.sleep(16000);
                        }
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });
            }
        });
    }

    public static void showCards(Player player,int[][] cardPosition,Draw draw,JPanel panel,int time) throws IOException, InterruptedException {
        String rootPath = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\";
        for (int i = 0; i < player.getCards().size(); i++) {
            Card card = player.getCards().get(i);
            String path = rootPath+card.getType()+"/"+card.getNumber()+".gif";
            draw.drawImages(panel,path,cardPosition[i]);
            if (time>0){
                Thread.sleep(time);
            }
        }
    }

    public static void cover(Player player,int[][] cardPosition,Draw draw,JPanel panel) throws IOException, InterruptedException {
        for (int i = 0; i < 13; i++) {
            String path = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\null.png";
            draw.drawImages(panel,path,cardPosition[i]);
        }
    }

    public static void showNumbers(JPanel panel,String[] s,Draw draw) throws IOException, InterruptedException {
        int[] position = {165,920};
        for (int i = 0; i < s.length; i++) {
           draw.drawString(panel,s[i],position);
           position[0] = position[0] + 50;
        }
    }

    public static void play(Player player,Draw draw,JPanel panel,int[][] cardPosition,JLabel number,int[] outPosition,JLabel score) throws IOException, InterruptedException {
        cover(player,cardPosition,draw,panel);
        number.setText("牌数"+player.getCardsNumber());
        showCards(player,cardPosition,draw,panel,0);
        String rootPath = "D:\\学习\\JAVA\\JAVA设计模式\\FinalWork_拱猪\\src\\main\\resources\\card-images\\";
        Card card = player.getNowPlayCard();
        if (card != null){
            String path = rootPath+card.getType()+"/"+card.getNumber()+".gif";
            draw.drawImages(panel,path,outPosition);
            number.setText("牌数"+player.getCardsNumber());
            score.setText("分数"+player.getScore());
            Thread.sleep(500);
        }else {
            System.out.println(player.getName()+"出牌为空，发生异常");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
