package gui.Wahrenuebersicht;

import business.TeeladenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class WarenuebersichtControl implements Observer{
	private WarenuebersichtView warenuebersichtView;
	private TeeladenModel teesModel;

	public WarenuebersichtControl(Stage primaryStage) {
		this.teesModel = TeeladenModel.getInstanz();
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, teesModel);
		this.teesModel.addObserver(this);
	}

	@Override
	public void update() {
		this.warenuebersichtView.zeigeTeesAn();
	}
}
