/*
	Programmer: Travis Delly
	Date: April 7 2015
	Purpose: Create a Hangman game Learning JavaFX
	Assignment: 14.17

*/
import java.util.*;

class Game{

	public static String[] words = {"woopy", "zoom", "goldberg", "playground","sports","season","balance","lilly"};
	public static Random rand = new Random();
	public static String word;
	public static int chances = 0;
	public static boolean game = false;

	public Game(){
		word = words[rand.nextInt(words.length)];
		game = true;
		chances = 0;
	}
	public void setGameOver(){
		game = false;
	}
	public void setGameOn(){
		game = true;
	}
	public boolean getGame(){
		return game;
	}

	public String getWord(){
		return word;
	}
	public int getChances(){
		return chances;
	}
	public void rmChance(){
		chances+=1;
	}
	public boolean guess(String letter){
		if (word.toLowerCase().contains(letter.toLowerCase())){
			return true;
		}
		return false;
	}
}