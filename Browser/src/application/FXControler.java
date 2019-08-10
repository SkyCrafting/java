package application;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FXControler {
	@FXML
	Button find = new Button();
	@FXML
	Button reloadpage = new Button();
	@FXML
	Button back = new Button();
	@FXML
	Button Forward = new Button();
	@FXML
	Button addpage = new Button();
	@FXML
	Button delpage = new Button();
	@FXML
	TextField textfind = new TextField();
	@FXML
	ProgressBar progressBar = new ProgressBar();
	@FXML
	WebView web = new WebView();
	@FXML
	WebEngine we = new WebEngine();
	@FXML
	TabPane tab = new TabPane();
	
	Timer timer;
	
	Timer timer2;
	public void progress() {
		Worker<Void> worker = web.getEngine().getLoadWorker();
		progressBar.progressProperty().bind(worker.progressProperty());
	}
	
	
	public void find() {
		Worker<Void> worker = web.getEngine().getLoadWorker();
		progressBar.setVisible(false);
		
			find.setDisable(true);
			progressBar.setVisible(true);
			progressBar.progressProperty().bind(worker.progressProperty());
			
			timer = new Timer(1000, new ActionListener() {
				int y = 0;
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					y++;
					if(y == 4) {
						progressBar.setVisible(false);
						System.out.println(y);
						timer.stop();
						find.setDisable(false);
					}
				}
				
			});
			timer.start();
			if(textfind.getText().isEmpty()) {
				web.getEngine().load("https://yandex.ru/");
				return;
			}
			web.getEngine().load("https://yandex.ru/search/?lr=76&text=" + textfind.getText());
			
	}
	
	public void goBack() {
		progress();
	    Platform.runLater(() -> {
	        web.getEngine().executeScript("history.back()");
	    });
	}

	public void goForward() {
		progress();
	    Platform.runLater(() -> {
	    	web.getEngine().executeScript("history.forward()");
	    });
	}
	
	public void goRefresh() {
		progress();
		web.getEngine().load(web.getEngine().getLocation());
		
		//web.getEngine().loadContent(web.getEngine().getHistory().getClass().getTypeName());
	}
	
	@FXML
	public void initialize() {	
		web.getEngine().load("https://yandex.ru/");
		progress();
		find.setOnAction(e->{
			find();
		});
		Forward.setOnAction(e->{
			goForward();
		});
		back.setOnAction(e->{
			goBack();
			
		});
		reloadpage.setOnAction(e->{
			goRefresh();
		});
		addpage.setOnAction(e->{
			
		});
			
		
	}

}
