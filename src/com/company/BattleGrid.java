package com.company;

import java.util.Scanner;

/**
 * Created by simon on 02/11/2017.
 */
public class BattleGrid {

    // ± ship part
    // ~ uknown/nothing
    // O miss
    // X hit


    private String [] [] BattleGrid = new String[11][11];
    private String [] [] EnemyBattleGridWiev = new String[11][11];


        public void ClearGrid() {

            for (int y = 1; y < 11; y++) {
                for (int x = 1; x < 11; x++) {
                    BattleGrid[y][x] = "~";
                    EnemyBattleGridWiev[y][x] = "~";
                }
            }

        }

        public void PrintOutGrid(){

            for (int y = 1; y < 11; y++) {
                for (int x = 1; x < 11; x++) {

                    System.out.print(
                            BattleGrid[y][x]
                    );


                }
                System.out.println();
            }
        }

        public void GetEnemysWievOfGrid(){

        for (int y = 1; y < 11; y++) {
            for (int x = 1; x < 11; x++) {

                System.out.print(
                        EnemyBattleGridWiev[y][x]
                );


            }
            System.out.println();
        }
    }



    public void AddShip(int ship,String type,int xPosition, int yPosition){

        if(type.toLowerCase().equals("horisontal")){
            for(int x = 0; x<ship ; x++ ){
                BattleGrid[yPosition][(xPosition+x)]="±";

            }
        }


        else if(type.toLowerCase().equals("vertical")){
            for(int y = 0; y<ship ; y++ ){
                BattleGrid[yPosition+y][(xPosition)]="±";

            }

        }


    }


    public  boolean CheckForShipCollition(int shipType, String type, int xPosition, int yPosition){

        if(type.toLowerCase().equals("horisontal")){
            for(int x = 0; x<shipType ; x++ ){
                if( BattleGrid[yPosition][(xPosition+x)]=="±")
                {
                    return true;
                }

            }
        }


        else if(type.toLowerCase().equals("vertical")){
            for(int y = 0; y<shipType ; y++ ){
              if( BattleGrid[yPosition+y][(xPosition)]=="±")
              {
                  return true;
              }

            }
        }

        return false;
    }


    public Boolean CheckIfHit(int x,int y){


        if(BattleGrid[y][x].equals("±")){
            EnemyBattleGridWiev[y][x]="X";
            BattleGrid[y][x]="X";
            return true;

        }


        else if(BattleGrid[y][x].equals("X")){
            return false;

        }


        else {
            EnemyBattleGridWiev[y][x]="O";
            return false;
        }


    }

    public String GetEnemyBattleGridTile(int y,int x) {
        return EnemyBattleGridWiev[y][x];
    }

}
