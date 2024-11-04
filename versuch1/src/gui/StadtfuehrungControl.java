package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import business.Stadtfuehrung;
import business.StadtfuehrungModel;
import javafx.stage.Stage;

public class StadtfuehrungControl {
	
	private StadtfuehrungModel stadtfuehrungModel;
	private StadtfuehrungView stadtfuehrungView;
	
	public StadtfuehrungControl(Stage primaryStage){
		super();
		this.stadtfuehrungModel= new StadtfuehrungModel();
		this.stadtfuehrungView= new StadtfuehrungView( this, stadtfuehrungModel,primaryStage );
		
	}
	
	public void nehmeStadtAuf(){
    	try{
    		this.stadtfuehrungModel.setStadt(new Stadtfuehrung (
    			this.stadtfuehrungView.getTxtTitel().getText(), 
   	            this.stadtfuehrungView.getTxtIdentnummer().getText(),
   	            this.stadtfuehrungView.getTxtKurzbeschreibung().getText(),
    		    this.stadtfuehrungView.getTxtStartuhrzeit().getText(),
    		    this.stadtfuehrungView.getTxtDatum().getText().split(";")));
    		 stadtfuehrungView.zeigeInformationsfensterAn("Das Stadt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		stadtfuehrungView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
	
	public void leseAusDatei(String typ){
    	try {
      		this.stadtfuehrungModel.leseAusDatei(typ);
      		       	
		}
		catch(IOException exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		}
		catch(Exception exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeBuergeraemterInCsvDatei() {
		try {
			this.stadtfuehrungModel.schreibeBuergeraemterInCsvDatei();
			stadtfuehrungView.zeigeInformationsfensterAn(
	   			"Der Stadt wurden gespeichert!");
		}	
		catch(IOException exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	

}
