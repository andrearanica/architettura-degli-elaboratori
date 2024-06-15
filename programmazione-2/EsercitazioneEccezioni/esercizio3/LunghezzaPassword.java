package esercizio3;

public class LunghezzaPassword extends Regola {

	private int lunghezzaMinima;
	
	public LunghezzaPassword(int lunghezzaMinima) {
		this.lunghezzaMinima = lunghezzaMinima;
	}

	@Override
	protected boolean applica(Account a) {
		return a.getPassword().length() >= lunghezzaMinima;
	}

}
