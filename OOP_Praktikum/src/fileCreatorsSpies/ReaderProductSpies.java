package fileCreatorsSpies;

import java.io.IOException;

public abstract class ReaderProductSpies {

	public abstract String[] leseAusDatei() throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
