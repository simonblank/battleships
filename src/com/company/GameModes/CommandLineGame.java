package com.company.GameModes;

import com.company.Users.Player;

import java.util.Scanner;

/**
 * Created by simon on 03/11/2017.
 */
public class CommandLineGame {
    private Player player1 ;
    private Player player2 ;

    public CommandLineGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void PlayCommandLineGame(){
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner scan = new Scanner(System.in);
        int playersTurn =1;
        int x=0,y=0;





        while (player1.GetLives()!=0 && player2.GetLives()!=0){
            System.out.println("\n");


            if(playersTurn == 1){
                player2.GetEnemysWievOfGrid();
                System.out.println("Player1s turn to play enter cordinates were to fire torpedos");
                System.out.println("player2s fleet has " + player2.GetLives() + " hp left");


                System.out.println("x cordinates");
                try { x = scan.nextInt(); } catch (Exception e){}


                System.out.println("y cordinates");
                try { y = scan.nextInt(); } catch (Exception e){}


                if(player2.CorrectInputCheck("horisontal",1,x ,y )) {
                    player2.CheckIfHit(x, y);
                    playersTurn++;
                }
            }




            else {
                player1.GetEnemysWievOfGrid();
                System.out.println("Player2s turn to play enter cordinates were to fire torpedos");
                System.out.println("player 1s fleet has " + player1.GetLives() + " hp left");


                System.out.println("x cordinates");
                try { x = scan.nextInt(); } catch (Exception e){}

                System.out.println("y cordinates");
                try { y = scan.nextInt(); } catch (Exception e){}


                if(player2.CorrectInputCheck("horisontal",1,x ,y )) {
                    player1.CheckIfHit(x, y);
                    playersTurn--;
                }
            }


            try { Thread.sleep(1400);}
            catch (InterruptedException e) {e.printStackTrace();
            }
        }


        System.out.println("GAME OVER!!!!!!!");

        if(player1.GetLives()==0){
            System.out.println("winner is Player 2");
        }
        else if(player2.GetLives()==0){
            System.out.println("winner is Player 1");
        }


    }

}
