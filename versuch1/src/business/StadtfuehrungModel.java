package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import factory.ConcreteCreatorAB;
import factory.Creator;
import factory.Product;

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
		
		Creator creator= new ConcreteCreatorAB();
		Product reader= creator.factoryMethode(typ);
		
		String [] zeile= reader.leseAusDatei();
		this.stadt = new Stadtfuehrung(zeile[0], zeile[1], 
      			zeile[2], zeile[3], zeile[4].split("_"));
		reader.schlisseDatei();
		
		
      		/*if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("StadtAusgabe.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.stadt = new Stadtfuehrung(zeile[0], zeile[1], 
      			zeile[2], zeile[3], zeile[4].split("_"));
      				ein.close();
      	  
      		}*/
	}
		
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("StadtAusgabe.csv"));
			aus.write(stadt.gibStadtZurueck(';'));
			aus.close();

	}

}
