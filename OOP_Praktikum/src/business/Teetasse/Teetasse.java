package business.Teetasse;

public class Teetasse {
	
	private String bezeichnung;
	private int milliliter;
	private int preis;
	
	public Teetasse(String bezeichnung, String milliliter, String preis) {
		super();
		this.bezeichnung = bezeichnung;
		this.milliliter = Integer.parseInt(milliliter);
		this.preis = Integer.parseInt(preis);
	}
	
	public String gibTeetasseZurueck(char trenner){
  		return this.getBezeichnung() + trenner 
  			+ this.getMilliliter() + trenner
  		    + this.getPreis();
   	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getMilliliter() {
		return milliliter;
	}

	public void setMilliliter(int milliliter) {
		this.milliliter = milliliter;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}
}
