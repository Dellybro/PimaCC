/*
	Programmer: Travis Delly
	Date: April 7 2015
	Purpose: Create a Hangman game Learning JavaFX
	Assignment: 14.17

*/



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.Arrays;

public class Hangman extends Application {

	public char[] correctGuesses = new char[5];
	public Game newGame = new Game();
	public LinePane hangman = new LinePane();
	public Text textForInstruction = new Text(50,50, "Press reset to start a game!");
	public ArrayList<Character> incorrectGuesses = new ArrayList<>();
	
	public BorderPane getLayout(){

		hangman.addHead();
		hangman.addBody();
		hangman.addArm1();
		hangman.addArm2();
		hangman.addLeg1();
		hangman.addLeg2();
		newGame.setGameOver();
		//Initial Setup

		Button btnSubmit = new Button("Submit");
		TextField userLetter = new TextField();
		Button btnStart = new Button("Reset");
		//3Button on the bottom

		HBox paneForButtons = new HBox(20);
		//Create pane for start and Labels
		paneForButtons.getChildren().addAll(btnStart,btnSubmit,userLetter);
		paneForButtons.setAlignment(Pos.CENTER);
		Pane paneForHanging = new Pane();
		paneForHanging.getChildren().add(hangman);
		//Create main pain for hangman
		BorderPane pane = new BorderPane();
		//Create BorderPane for to insert Pane
		pane.setBottom(paneForButtons);
		//Put Buttons in pane
		pane.setCenter(paneForHanging);
		//Set Hangman as Center

		VBox paneForInstructions = new VBox(20);
		paneForInstructions.getChildren().add(textForInstruction);
		pane.setRight(paneForInstructions);
		//InstructionsBox


		btnSubmit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				if (newGame.getGame()){ //If game isnt over(Button unresponsive when gameOver)
					if (userLetter.getText().length() > 0){//If userLetter is greater then 0
						String letter = userLetter.getText().toLowerCase(); //SetLowercase and helperVariable
						if (newGame.guess(letter.substring(0))){ //Guess is a function in the class Game which returns true or false
							char[] let = letter.toCharArray(); //If guesss returns true turn letter into char array to check for first spot
							if (Arrays.asList(correctGuesses).contains(let[0]) == false){ //Check if correctGuessesContains guess in spot 0(This way the only spot checked it 0 if the user places more than just that letter)
								String hold = newGame.getWord(); //Create a holder for the newGame variable
								int count = hold.replaceAll("[^"+ let[0] +"]", "").length(); //I think i change the variable here by creating count now hold is a useless variable
								for(int i = 0; i < count; i++){ 
									char[] wordArray = newGame.getWord().toCharArray(); //Create char array of word this time
									for(int y = 0; y < wordArray.length; y++){
										if(wordArray[y]==let[0]){
											correctGuesses[y] = let[0];
										}//If all the tests have passed this far, that means this answer is golden.
									}//This loop will only place a letter in the spot a letter needs to be so that it is easier to figure out the word
								}//I don't have a lot of knowledge of javafx yet so creating countless labels depending on word size was confusing
								String instruct = "Correct!\n Chances Left: " + (6-newGame.getChances()) + "\n The current correct Letters are\n"
									+ Arrays.toString(correctGuesses) + "\n\nThe current incorrect Letters are:\n" + incorrectGuesses.toString();
								if (Arrays.equals(correctGuesses, newGame.getWord().toCharArray())){
									newGame.setGameOver();
									instruct = instruct +"\n\nGameOver! \nPress Reset to start a new Game!";
								}//Create new instructions if game is over, stop pause game. by turning setGameOver on.
								textForInstruction.setText(instruct);
							} else {
								String instruct = "You Already Guessed " + let[0] +"\n Chances Left: " + (6-newGame.getChances()) + "\n The current correct Letters are\n"
									+ Arrays.toString(correctGuesses) + "\n\nThe current incorrect Letters are:\n" + incorrectGuesses.toString();
								textForInstruction.setText(instruct);
							}//If letter was already guessed this catches it, and returns new instructions

						} else {//If letter chosen was wrong, start hangman
							char[] let = letter.toCharArray();
							if(incorrectGuesses.contains(let[0])){
								String instruct = "You Already Guessed " + let[0] +"\n Chances Left: " + (6-newGame.getChances()) + "\n The current correct Letters are:\n"
									+ Arrays.toString(correctGuesses) + "\n\nThe current incorrect Letters are:\n" + incorrectGuesses.toString();
								textForInstruction.setText(instruct);
							}else{
								newGame.rmChance();
								incorrectGuesses.add(let[0]);
								switch(newGame.getChances()){
								case 1:
									hangman.addHead();
									break;
								case 2:
									hangman.addBody();
									break;
								case 3:
									hangman.addArm1();
									break;
								case 4:
									hangman.addArm2();
									break;
								case 5:
									hangman.addLeg1();
									break;
								case 6:
									hangman.addLeg2();
									newGame.setGameOver();
									break;
								}
								String instruct = "Incorrect!\n Chances Left: " + (6-newGame.getChances()) + "\n The current correct Letters are\n"
									+ Arrays.toString(correctGuesses) + "\n\nThe current incorrect Letters are:\n" + incorrectGuesses.toString();
								if (newGame.getGame() == false){
									instruct = instruct +"\n\nGameOver! \nPress Reset to start a new Game!";
								}//Checks if game over, if game not over than continue playing.
								textForInstruction.setText(instruct);
							}
						}
					} 
				}
                userLetter.clear(); //Clear user response
			}	
		});
		

		
		btnStart.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				newGame = new Game();
				incorrectGuesses = new ArrayList<>();
				correctGuesses = new char[newGame.getWord().length()];
				textForInstruction.setText("Type a letter into the box,\n than press submit!\n LettersLength:  " + correctGuesses.length);
				//hangman = new LinePane(); <--- Doesnt seem to work
				hangman.rmBody();
				hangman.rmHead();
				hangman.rmArm1();
				hangman.rmArm2();
				hangman.rmLeg1();
				hangman.rmLeg2();
			}
		});
		return pane;

	}
	public void start(Stage primaryStage){


		Scene scene = new Scene(getLayout(), 700, 700);
		primaryStage.setTitle("Hang-Man");
		primaryStage.setScene(scene);
		primaryStage.show();



	}



	class LinePane extends Pane {
		public Line body = new Line(250,350,250,200);
		public Circle head = new Circle();
		public Line arm1 = new Line(250,225,200,275);
		public Line arm2 = new Line(250,225,300,275);
		public Line leg1 = new Line(250,350,200,460);
		public Line leg2 = new Line(250,350,300,460);
		//Different BodyParts


		//GetterSetter Methods for bodyparts

		public void rmBody(){
			getChildren().remove(body);
		}
		public void addBody(){
			getChildren().add(body);
		}
		public void rmHead(){
			getChildren().remove(head);
		}
		public void addHead(){
			head.setCenterX(250);
			head.setCenterY(175);
			head.setRadius(25);
			head.setFill(Color.WHITE);
			head.setStroke(Color.BLACK);
			getChildren().add(head);
		}
		public void rmArm1(){
			getChildren().remove(arm1);
		}
		public void addArm1(){
			getChildren().add(arm1);
		}
		public void rmArm2(){
			getChildren().remove(arm2);
		}
		public void addArm2(){
			getChildren().add(arm2);
		}
		public void rmLeg1(){
			getChildren().remove(leg1);
		}
		public void addLeg1(){
			getChildren().add(leg1);

		}
		public void rmLeg2(){
			getChildren().remove(leg2);
		}
		public void addLeg2(){
			getChildren().add(leg2);
		}

		public LinePane(){ //The initial Pole
			Line pole = new Line(120,600,120,70);
			getChildren().add(pole);
			Line hanger = new Line(120,70,250,70);
			getChildren().add(hanger);
			Line hangerExt = new Line(250,70,250,150);
			getChildren().add(hangerExt);
			Arc stand = new Arc(120,630,60,30,40,100);
			stand.setType(ArcType.OPEN);
			stand.setFill(Color.WHITE);
			stand.setStroke(Color.BLACK);
			getChildren().add(stand);

		}
	}

	public static void main(String[] args){
		Application.launch(args);
	}
}