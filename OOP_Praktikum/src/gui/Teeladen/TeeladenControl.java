package gui.Teeladen;

import java.io.IOException;

import business.TeeladenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class TeeladenControl implements Observer{

	// Attribute / Objekte
	private TeeladenView tv;
	private TeeladenModel tm;

	// Konstruktor
	public TeeladenControl(Stage primaryStage) {

		this.tm = TeeladenModel.getInstanz();
		this.tm.addObserver(this);
		this.tv = new TeeladenView(primaryStage, this, tm);

	}

	// Methoden / Fehler abfangen
	void nehmeTeeAuf() {
		try {
			tm.createTeesorte(Integer.parseInt(tv.getTxtIdentnummer().getText()), tv.getTxtBezeichnung().getText(),
					tv.getTxtKategorie().getText(), tv.getTxtMitKoffein().getText(),
					tv.getTxtEnthalteneKraeuter().getText().split(";"));
			tv.zeigeInformationsfensterAn("Die Teesorte wurde aufgenommen!");
		} catch (Exception exc) {
			tv.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	void leseAusDatei(String typ) {
		try {
			tm.leseAusDatei(typ);
			tv.zeigeInformationsfensterAn("Die Teesorte wurde gelesen!");

		} catch (IOException exc) {
			tv.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			tv.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	void schreibeTeesInCsvDatei() {
		try {
			tm.schreibeTeesInCsvDatei();
			tv.zeigeInformationsfensterAn("Die Teesorten wurden gespeichert!");
		} catch (IOException exc) {
			tv.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			tv.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		this.tv.zeigeTeesAn();
	}
}