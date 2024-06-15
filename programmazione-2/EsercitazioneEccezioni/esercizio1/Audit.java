import java.lang.NullPointerException;
import java.lang.ClassCastException;

public class Audit {
	public boolean benefitTroppoAlto(Dipendente dipendente) {
		Dirigente dirigente = (Dirigente)dipendente;
		try {
			double benefit = dirigente.getBenefit();
			if (benefit > 10000) {
				return true;
			} else {
				return false;
			}
		} catch(NullPointerException e) {
			System.out.println("Null pointer passed instead of Dipendente");
		} catch(ClassCastException e) {
			System.out.println("Null pointer passed instead of Dipendente");
		} catch (Exception e) {
			System.out.println("Bom");
		}
		return false;
	}
}
