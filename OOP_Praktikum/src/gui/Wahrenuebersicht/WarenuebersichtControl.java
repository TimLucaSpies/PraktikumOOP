package gui.Wahrenuebersicht;

import java.io.IOException;

import business.Tees.TeeladenModel;
import business.Teetasse.TeetasseModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class WarenuebersichtControl implements Observer{
	private WarenuebersichtView warenuebersichtView;
	private TeeladenModel teesModel;
	private TeetasseModel teetasseModel;

	public WarenuebersichtControl(Stage primaryStage) {
		this.teesModel = TeeladenModel.getInstanz();
		this.teetasseModel = TeetasseModel.getInstanz();
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, teesModel, teetasseModel);
		this.teesModel.addObserver(this);
	}

	@Override
	public void update() {
		this.warenuebersichtView.zeigeTeesAn();
	}
	
	public void leseTeetassenAusCsvDatei() {
		try {
			this.teetasseModel.leseTeetasseAusCsvDatei();
		}catch(IOException exc) {
			this.warenuebersichtView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Teetassen!");
		}catch(Exception exc){
			this.warenuebersichtView.zeigeFehlermeldungsfensterAn("Unbekannter fehler beim Lesen von Teetassen!");
			exc.printStackTrace();
		}
	}
}
