package esercizio3;

public abstract class Regola {
	
	public boolean convalida(Account a) {
		if (a == null) {
			return false;
		}
		if (a.getPassword() == null || a.getPassword().isEmpty()) {
			return false;
		}
		return applica(a);
	}
	
	protected abstract boolean applica(Account a);

}
