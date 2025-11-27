
package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fileCreatorsSpies.ConcreteReaderCreatorSpies;
import fileCreatorsSpies.ReaderCreatorSpies;
import fileCreatorsSpies.ReaderProductSpies;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeeladenModel implements Observable {

	private Teesorte ts;
	private static TeeladenModel instanz = null;
	private Vector<Observer> obs = new Vector<Observer>();

	private TeeladenModel() {

	}

	public static TeeladenModel getInstanz() {
		if (instanz == null) {
			instanz = new TeeladenModel();
		}
		return instanz;
	}

	public void createTeesorte(int identnummer, String bezeichnung, String kategorie, String mitKoffein,
			String[] enthalteneKraeuter) {
		this.ts = new Teesorte(identnummer, bezeichnung, kategorie, mitKoffein, enthalteneKraeuter);
		notifyObserver();
	}

	public Teesorte getTs() {
		return ts;
	}

	public void setTs(Teesorte ts) {
		this.ts = ts;
	}

	// Methoden / Datenverarbeitung
	public void leseAusDatei(String typ) throws IOException {

		ConcreteReaderCreatorSpies creator = new ConcreteReaderCreatorSpies();
		ReaderProductSpies product = creator.factoryMethod(typ);
		String arr[] = product.leseAusDatei();
		createTeesorte(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4].split("_"));
		product.schliesseDatei();

	}

	public void schreibeTeesInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
		aus.write(ts.gibTeesorteZurueck(';'));
		aus.close();
	}

	@Override
	public void addObserver(Observer obs) {
		this.obs.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.obs.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for (Observer obs : obs) {
			obs.update();
		}
	}
}
