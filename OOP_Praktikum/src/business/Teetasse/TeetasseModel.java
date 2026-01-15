package business.Teetasse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.Tees.TeeladenModel;
import business.Tees.Teesorte;
import javafx.scene.Node;

public class TeetasseModel {

	private ArrayList<Teetasse> tt = new ArrayList<Teetasse>();
	private static TeetasseModel instanz = null;

	private TeetasseModel() {
	}

	public void leseTeetasseAusCsvDatei() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Teetasse.csv"));
		ArrayList<Teetasse> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Teetasse(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.tt = ergebnis;
	}

	public static TeetasseModel getInstanz() {
		if (instanz == null) {
			instanz = new TeetasseModel();
		}
		return instanz;
	}

	public ArrayList<Teetasse> getTt() {
		return tt;
	}
}
