/*
	Developper: Travis Delly
	Date: 4/9/2015
	Purpose: Diplsy interest rate
	Assignment: 15.5

*/


import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
import java.util.Arrays;
import javafx.scene.control.TextArea;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.control.CheckBox;

public class LetterCounter extends Application {

	public Stage barStage = new Stage();
	public Histogram graph = new Histogram();
	//Created here so that the Stage barScene isnt recreated over and over.
	final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	public TextField userFile = new TextField();
	protected @SuppressWarnings("unchecked") BorderPane getPane(){
		//Create panes

		HBox paneforSubmit = new HBox(20);
		Pane mainPane = new Pane();


		//Setup paneforSubmit
		CheckBox stack = new CheckBox("Compare");
		Button view = new Button("View");
		userFile.setPrefWidth(285);
		Label info = new Label("File name");
		paneforSubmit.getChildren().addAll(info, userFile, view, stack);
		paneforSubmit.setAlignment(Pos.CENTER);
		paneforSubmit.setStyle("-fx-border-width: 2px; -fx-border-color: black");

		//Setup the borderPane which inserts other panes.
		BorderPane borders = new BorderPane();
		borders.setCenter(new BarChart(new CategoryAxis(), new NumberAxis()));
		borders.setBottom(paneforSubmit);

		//Button Actions
		userFile.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				if(stack.isSelected() == false){
					graph = new Histogram();
				}
				borders.setCenter(setGraph(userFile, graph));
			}
		});
		view.setOnMouseClicked(e -> {
			if(stack.isSelected() == false){
					graph = new Histogram();
			}
			borders.setCenter(setGraph(userFile,graph));
		});//Checks to see if anything is valid.
		return borders;
	}

	public BarChart setGraph(TextField userFile, Histogram graph){
			String fileName = userFile.getText().toString();
			java.io.File file = new java.io.File(fileName);

			if(file.exists()){
				try{
					graph.makeArray(file);
					graph.createHistogram(userFile.getText().toString());
				} catch(Exception g){
					System.out.println(g);
				}
				userFile.clear();
			}
			return graph.getBC();
	}//Creates graph for Pane, used twice.

	@Override
	public void start(Stage primaryStage){

		Scene scene = new Scene(getPane(), 575, 300);
		primaryStage.setTitle("Letter Counter");
		primaryStage.setScene(scene);
		primaryStage.show();

		userFile.requestFocus();

	}

	public static void main(String[] args){
		Application.launch(args);
	}
}