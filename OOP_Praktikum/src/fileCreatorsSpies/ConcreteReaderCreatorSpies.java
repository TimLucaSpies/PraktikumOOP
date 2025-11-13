package fileCreatorsSpies;

public class ConcreteReaderCreatorSpies extends ReaderCreatorSpies {

	ReaderProductSpies product;

	@Override
	public ReaderProductSpies factoryMethod(String typ) {
		if (typ.equals("csv")) {
			this.product = new ConcreteCsvReaderProductSpies();
		} else {
			this.product = new ConcreteTxtReaderProductSpies();
		}
		return product;
	}

}
