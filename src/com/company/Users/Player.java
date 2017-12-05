package com.company.Users;

import com.company.BattleGrid;

import java.util.Scanner;

/**
 * Created by simon on 02/11/2017.
 */
public class Player {


    BattleGrid battleGrid = new BattleGrid();
    private Boolean
             carrierIsPlaced    = false
            ,battleShipIsPlaced = false
            ,cruiserIsPlaced    = false
            ,destroyer1IsPlaced = false
            ,destroyer2IsPlaced = false
            ,submarine1IsPlaced = false
            ,submarine2IsPlaced = false;

    private int lives=18;


    public Player() {
        battleGrid.ClearGrid();
    }


    public Boolean PlaceShip(int ship){
        Scanner scan = new Scanner(System.in);
        String type;
        int xPosition=0,yPosition=0;


        System.out.println("a ship of size " + ship + " will be placed");
            System.out.println("horisontal or vertical ship?");
            type = scan.next();



            if(type.equals("horisontal")){
                System.out.println("enter a x value between 1-" + (11-ship));
            }
            else {
                System.out.println("enter a x value between 1-10");
            }
            try{ xPosition = scan.nextInt(); } catch (Exception e){}



            if(type.equals("vertical")){
                System.out.println("enter a y value between 1-" + (11-ship));
            }
            else {
                System.out.println("enter a y value between 1-10");

            }
            try { yPosition = scan.nextInt(); }  catch (Exception e){}




            if(!CorrectInputCheck(type,ship,xPosition,yPosition)) {
                System.out.println("something went wrong try again \n");
                return false;

            }
             else if(battleGrid.CheckForShipCollition(ship,type,xPosition,yPosition)){
                System.out.println("your ship collided with another ship and sank. Place another one");
                return false;

            }
            else {
                battleGrid.AddShip(ship,type,xPosition,yPosition);
                PrintGrid();
                return true;

            }


    }


    public void PlaceAllShips(){
        Boolean areAllShipsPlaced=false;
        PrintGrid();



        System.out.println("the ship will be placed from right to left or top to down. select the start direction of the ship");
        while(!areAllShipsPlaced){

            if(!carrierIsPlaced){
                if(PlaceShip(5)){carrierIsPlaced=true;}

            }
            else if(!battleShipIsPlaced){
                if(PlaceShip(4)){battleShipIsPlaced=true;}

            }
            else if(!cruiserIsPlaced){
                if(PlaceShip(3)){cruiserIsPlaced=true;}

            }
            else if(!destroyer1IsPlaced){
                if(PlaceShip(2)){destroyer1IsPlaced=true;}

            }
            else if(!destroyer2IsPlaced){
                if(PlaceShip(2)){destroyer2IsPlaced=true;}

            }
            else if(!submarine1IsPlaced){
                if(PlaceShip(1)){submarine1IsPlaced=true;}

            }
            else if(!submarine2IsPlaced){
                if(PlaceShip(1)){submarine2IsPlaced=true;}

            }
            else {areAllShipsPlaced=true;}







        }
        System.out.println("all ships are placed");
    }


    public boolean CorrectInputCheck(String type,int ship, int x , int y){

        if(!type.toLowerCase().equals("horisontal")  &&  !type.toLowerCase().equals("vertical")){

            System.out.println("misspelled direction ");
            return false;
        }


        if(type.toLowerCase().equals("horisontal")) {

            if (x < 1 || x > (11 - ship)) {
                System.out.println("illegal x number given");
                return false;
            }
            if(y < 1 || y >= 11){
                System.out.println("illegal y number given");
                return false;
            }
        }


        if(type.toLowerCase().equals("vertical")) {

            if (x < 1 || x >= 11) {
                System.out.println("illegal x number given");
                return false;
            }
            if (y < 1 || y > (11 - ship)) {
                System.out.println("illegal y number given");
                return false;
            }
        }


        return true;
    }


    public void CheckIfHit(int x,int y){

        if(battleGrid.CheckIfHit(x, y)){
            System.out.println("Direct Hit!");
            lives--;
        }
        else {
            System.out.println("miss");

        }


    }


    public void GetEnemysWievOfGrid(){
        battleGrid.GetEnemysWievOfGrid();
    }


    public void PrintGrid(){
        battleGrid.PrintOutGrid();
    }


    public int GetLives() {
        return lives;
    }


    public String GetEnemyBattleGridTile(int y,int x) {
        return battleGrid.GetEnemyBattleGridTile(y,x);
    }


}
