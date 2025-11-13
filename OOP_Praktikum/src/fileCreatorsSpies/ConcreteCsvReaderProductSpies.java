package fileCreatorsSpies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProductSpies extends ReaderProductSpies{

	private BufferedReader ein;
	@Override
	public String[] leseAusDatei()throws IOException {
		this.ein = new BufferedReader(new FileReader("Teesorte.csv"));
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {	
		ein.close();
	}

}
