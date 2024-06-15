package esercizio2;

public class Smartphone extends Device implements ICamera, ITelephone {
	private Photo[] gallery;
	private int credit;
	
	public Smartphone(int maxPhoto) {
		if (maxPhoto > 0) {
			gallery = new Photo[maxPhoto];
		}
		credit = 0;
	}
	
	public void addCredit(int credit) {
		if (credit > 0) {
			this.credit += credit;
		}
	}

	@Override
	public boolean call(long number) {
		if (!isReady()) {
			return false;
		}
		if (number > 0 && credit > 0) {
			return true;
		} else {	
			return false;
		}
	}

	@Override
	public boolean takePhoto() {
		if (!isReady()) {
			return false;
		}
		for (int i = 0; i < gallery.length; i++) {
			if (gallery[i] == null) {
				gallery[i] = new Photo();
				return true;
			}
		}
		return false;
	}

}
