package main;


import gui.guiStadt.StadtTerrismousControl;
import gui.guiStadtfuehrung.StadtfuehrungControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new StadtfuehrungControl(primaryStage);
		Stage fenster= new Stage();
		new StadtTerrismousControl(fenster);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
