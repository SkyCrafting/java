package application;
	

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class Main extends Application{
	@SuppressWarnings("unused")
	private Stage stage;
	private Scene scene;
	private AnchorPane pane;
	
	@FXML
	static Button loadurl = new Button();
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = new Stage();
		pane = (AnchorPane) FXMLLoader.load(Main.class.getResource("Main.fxml"));
		scene = new Scene(pane, 1280 ,720);
		stage.setTitle("Browser");
		stage.setMaximized(true);
		stage.setMinHeight(200);
		stage.setMinWidth(500);
		stage.setFullScreen(true);
		stage.setScene(scene);	
		stage.show();
	}
	
	
	public static void main(String[] args) {			
		launch(args);	
	}
}
