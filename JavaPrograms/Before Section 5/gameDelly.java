/* 
Travis Delly
Feb 6, 2015
CIS 279 module 4
Programming Assignment 4.1
Textbook Programming Exercises 7.21
Point of Assignment: Create a Bean Machine and position the balls accordingly.
*/


import java.util.Scanner;
/*Start class*/
public class gameDelly{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean game = true;
		/*initial variables*/
		
		while(game){
			System.out.print("Hello Welcome to the Bean Machine\n How many beans would you like: ");
			int beans = input.nextInt();
			System.out.print("How many rows: ");
			int rows = input.nextInt();
			/*initial Input*/
			
			/*start Ball Positions*/
			int[] row_array = new int[rows];
			for(int j = 0; j<beans;j++){
				int new_Position = rows/2;
				for(int i = 0; i<rows;i++){
					if(Math.random()*10 >= 5){
						new_Position++;
						if(new_Position > rows-1){
							new_Position--;
						}
						System.out.print("R");
					}
					else{
						new_Position--;
						if(new_Position < 0){
							new_Position++;
						}
						System.out.print("L");
					}
				}
				System.out.println();
				row_array[new_Position] = row_array[new_Position]+1;
			}
			/*Ball Position*/
			int bottomSize = 0;
			for(int i = 0; i<rows;i++){
				if(row_array[i] > bottomSize){
					bottomSize = row_array[i];
				}
			}
			/*Max Size of bottom*/
			for(int i = bottomSize; i>0;i--){
				/*Count backwards so balls stack up*/
				for(int j = 0; j<rows;j++){
					if(row_array[j] >= i){
						System.out.print("o");
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			/*Print balls*/
			
			System.out.println("\n\nPlay Again? Type y (Case Sensitive)");
			char playAgain = input.next().charAt(0);
			if(playAgain != 'y'){
				game = false;
			}
		}
		
		
	}
	/*I chose to use one method because this game was small enough. using more methods
	could've complicated the game design I feel.*/
}