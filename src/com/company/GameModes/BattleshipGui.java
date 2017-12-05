package com.company.GameModes;

import com.company.Users.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by simon on 03/11/2017.
 */
public class BattleshipGui {

    Player player1;
    Player player2;
    int playerTurn =1;

    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JLabel playerTurnTitle = new JLabel("player 1 turn");

    public BattleshipGui(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void LoadBattleshipGui() {
        mainFrame.add(playerTurnTitle);
        MainPanelProperties();


        MainFrameProperies();
    }


    public void MainFrameProperies() {
        mainFrame.setSize(600, 650);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS);
        mainFrame.setLayout(boxLayout);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
    public void MainPanelProperties() {
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setSize(new Dimension(600,600));
        LoadPlayer1BattleField();


        mainFrame.getContentPane().add(mainPanel);

    }


    public void LoadPlayer1BattleField() {

        for (int y = 1; y < 11; y++) {
            for (int x = 1; x < 11; x++) {
                mainPanel.add(BattleFieldPlayer1Tile(
                                player2.GetEnemyBattleGridTile(y,x)
                                ,y
                                ,x
                        )
                );
            }
        }
    }


    public void LoadPlayer2BattleField() {

        for (int y = 1; y < 11; y++) {
            for (int x = 1; x < 11; x++) {
                mainPanel.add(BattleFieldPlayer2Tile(
                        player1.GetEnemyBattleGridTile(y,x)
                        ,y
                        ,x
                        )
                );
            }
        }
    }


    public JButton BattleFieldPlayer1Tile(String tileChar ,int y ,int x) {
        JButton button = new JButton(tileChar );


            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    player2.CheckIfHit(x,y);
                    SwitchPlayer();
                    ChangeTitle();

                    CheckIfGameOver();

                    }
            });
            button.setPreferredSize(new Dimension(50,50));

        return button;
    }


    public JButton BattleFieldPlayer2Tile(String tileChar ,int y ,int x) {
        JButton button = new JButton(tileChar );


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                player1.CheckIfHit(x,y);
                SwitchPlayer();
                ChangeTitle();

                CheckIfGameOver();

            }
        });
        button.setPreferredSize(new Dimension(50,50));

        return button;
    }


    public void SwitchPlayer(){
        if(playerTurn==1){
            mainPanel.removeAll();
            LoadPlayer2BattleField();
            playerTurn=2;

        }
        else if(playerTurn==2){
            mainPanel.removeAll();
            LoadPlayer1BattleField();
            playerTurn=1;

        }


        System.out.println("now its player " + playerTurn + " turn");
        mainFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    public void ChangeTitle(){

        if(playerTurn == 1 ){playerTurnTitle.setText("player 1 turn");}

        if(playerTurn == 2 ){playerTurnTitle.setText("player 2 turn");}

    }

    public void CheckIfGameOver(){
        System.out.println("player 1 lives left " + player1.GetLives());
        System.out.println("player 2 lives left " + player2.GetLives());


        if(player1.GetLives() <1){
            System.out.println("game over");
            mainPanel.removeAll();


            JLabel label = new JLabel("Game Over Winner is Player 2");
            mainPanel.add(label);
            mainFrame.setVisible(false);
            mainFrame.setVisible(true);

        }


        if(player2.GetLives() < 1){
            System.out.println("game over");
            mainPanel.removeAll();


            JLabel label = new JLabel("Game Over Winner is Player 1");
            mainPanel.add(label);
            mainFrame.setVisible(false);
            mainFrame.setVisible(true);

        }


    }


}





