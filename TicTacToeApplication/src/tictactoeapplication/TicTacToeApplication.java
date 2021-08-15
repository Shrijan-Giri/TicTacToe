package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		
		//Getting Input
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//Allows for continuous game
		boolean doyouWantToPlay=true;
		
		while(doyouWantToPlay) {
			//Setting up our tokens and AI
			System.out.println("Welcome to Tic Toc Toe! You are about to go against  "
		   +"the master of  Tic Tac Toe.Are  You ready?  I hope so!\n   But First,you  "
			+"must pick what character  you want to be and which character I will be");
		
		System.out.println();
		System.out.println("Enter a single character that will represent you on the board");
		char playerToken=sc.next().charAt(0);
		System.out.println("Enter a single character that will represent your opponent on the board");
	   char opponentToken=sc.next().charAt(0);
	   TicTacToe game=new TicTacToe(playerToken, opponentToken);
	   AI ai=new AI();
	
	   //Set up the game
	   System.out.println();
	   System.out.println("Now we can start the game.To play, enter a number and your token shall be put"
			   +"in its place.\n The numbers go from 1-9, left to right.We shall see who will win this round." );
	   TicTacToe.printIndexBoard();
	   System.out.println();
	   
	   //Let's play!
	   while(game.gameOver().equals("notOver")) {
		   if(game.currentMarker==game.userMarker) {
			   //User turn
			   System.out.print("It's your turn!  Enter a spot for  your token  ");
			   int spot=sc.nextInt();
			   while(!game.playTurn(spot)) {
				   System.out.println("Try again.  "+spot+" is invalid. This spot is already taken"+
			   "or it is out of range");
				   spot=sc.nextInt();
			   }
			   System.out.print("You picked  "+spot+"  !");
		   }else {
			   //AI Turn
			   System.out.print("It's  my turn!  ");
			   //Pick spot
			   int aiSpot=ai.pickSpot(game);
			   game.playTurn(aiSpot);
			   System.out.print("I picked "+aiSpot+" !");
		   }
		   //Print out now board
		   System.out.println();
		   game.printBoard();
	   }
	   System.out.println(game.gameOver());
	   System.out.println();
	   
	   // Set up a new game....or not depending on the response
	   System.out.println("Do you want to play again? Enter Y if you do."+
	   "Enter anything else if you are tired of me");
	   char response =sc.next().charAt(0);
	   doyouWantToPlay=(response =='Y');
	   System.out.println();
	   System.out.println();
	   }
	}
}
