/*
	Developper: Travis Delly
	Date: 4/8/2015
	Purpose: Diplsy interest rate
	Assignment: 15.5

*/


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class InvestmentCalculator extends Application {
	protected BorderPane getPane(){
		//Create panes
		HBox paneforSubmit = new HBox(20);
		VBox paneforUser = new VBox(20);
		Pane mainPane = new Pane();

		//Setup MainPane
		Text result = new Text(20,120,"$0.0");
		Text text = new Text(20, 40, "Total Return: ");
		text.setFont(new Font("SansSerif,", 20));
		result.setFont(new Font("Verdana", 40));
		mainPane.getChildren().addAll(text, result);

		//Setup paneforSubmit
		Button submit = new Button("submit");
		paneforSubmit.getChildren().add(submit);
		paneforSubmit.setAlignment(Pos.CENTER);
		paneforSubmit.setStyle("-fx-border-width: 2px; -fx-border-color: black");

		//Setup Pain for User
		TextField investAmmount = new TextField();
		TextField years = new TextField();
		TextField annualInterest = new TextField();
		Label invest = new Label("Investment Ammount: ");
		Label yearsLab = new Label("Years: ");
		Label annual = new Label("Annual Interest Ex. 50% = .5: ");
		paneforUser.getChildren().addAll(invest, investAmmount, annual, annualInterest, yearsLab, years);
		paneforUser.setStyle("-fx-border-width: 1px; -fx-border-color: black");

		//Setup the borderPane which inserts other pains.
		BorderPane borders = new BorderPane();
		borders.setCenter(mainPane);
		borders.setBottom(paneforSubmit);
		borders.setRight(paneforUser);

		//Button Actions
		submit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				if(investAmmount.getText().length() > 0 && years.getText().length() > 0 && annualInterest.getText().length() > 0){
					double inv = Double.parseDouble(investAmmount.getText());
					double yea = Double.parseDouble(years.getText());
					double ann = Double.parseDouble(annualInterest.getText());

					double futureValue = inv*(Math.pow((1.0+(ann/12.0)), yea*12));
					result.setFill(Color.BLACK);
					text.setFill(Color.BLACK);	
					result.setText("$" + String.format("%.5g%n", futureValue));
				} else { 
					result.setText("Fill out\n   ALL fields");
					result.setFill(Color.RED);
					text.setFill(Color.RED);
				}
			}
		});

		return borders;
	}
	@Override
	public void start(Stage primaryStage){


		Scene scene = new Scene(getPane(), 475, 250);
		primaryStage.setTitle("Investor Inc.");
		primaryStage.setScene(scene);
		primaryStage.show();



	}

	public static void main(String[] args){
		Application.launch(args);
	}
}