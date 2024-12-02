package gui.guiStadt;




import business.StadtfuehrungModel;
import javafx.stage.Stage;
import ownUtil.Observer;



public class StadtTerrismousControl implements Observer {
	

	private StadtfuehrungModel stadtfuehrungModel;
	private StadtTerrismousView  stadtView;
	
	
	public StadtTerrismousControl(Stage primaryStage) {
		super();
		this.stadtfuehrungModel = stadtfuehrungModel.getInstanz();
		this.stadtView = new StadtTerrismousView(this, primaryStage, stadtfuehrungModel);
		stadtfuehrungModel.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		stadtView.zeigeStadtAn();
		
 }
}