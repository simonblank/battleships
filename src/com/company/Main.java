package com.company;

import com.company.GameModes.BattleshipGui;
import com.company.GameModes.CommandLineGame;
import com.company.Users.Player;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();



		Scanner scan = new Scanner(System.in);
		player1.PlaceAllShips();
		player2.PlaceAllShips();


		System.out.println("text or gui?");
		String input = scan.next();


		if(input.toLowerCase().equals("text")){
			CommandLineGame commandLineGame = new CommandLineGame(player1 ,player2 );
			commandLineGame.PlayCommandLineGame();

		}
		else if(input.toLowerCase().equals("gui")){
			BattleshipGui battleshipGui= new BattleshipGui(player1,player2);
			battleshipGui.LoadBattleshipGui();

		}



    }
}
