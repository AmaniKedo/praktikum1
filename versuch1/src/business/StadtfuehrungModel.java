package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import gui.Stadt;

public class StadtfuehrungModel {
	
	
   private 	Stadtfuehrung stadt;
	
   


	public Stadtfuehrung getStadt() {
	return stadt;
}

public void setStadt(Stadtfuehrung stadt) {
	this.stadt = stadt;
}

	public void leseAusDatei(String typ) throws IOException{
    
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Stadt.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.stadt = new Stadtfuehrung(zeile[0], zeile[1], 
      			zeile[2], zeile[3], zeile[4].split("_"));
      				ein.close();
      	  
      		}
	}
		
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("StadtAusgabe.csv", true));
			aus.write(stadt.gibStadtZurueck(';'));
			aus.close();

	}

}
