import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class bouncingBall extends Application{
	@Override
	public void start(Stage primaryStage){
		BallPane ballPane = new BallPane();
		BallPane ballPane2 = new BallPane();
		ballPane2.changeX(200);
		Slider slSpeed = new Slider();
		slSpeed.setMax(20);
		ballPane.rateProperty().bind(slSpeed.valueProperty());

		BorderPane pane = new BorderPane();


		pane.setCenter(ballPane, ballPane2);
		pane.setBottom(slSpeed);


		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("BouncyBall");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}