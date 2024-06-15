package esercizio3;

public class Uguaglianza extends Regola {

	@Override
	protected boolean applica(Account a) {
		return !a.getPassword().equalsIgnoreCase(a.getUsername());
	}

}
