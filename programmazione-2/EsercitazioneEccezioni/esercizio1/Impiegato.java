public class Impiegato extends Dipendente {

	public Impiegato(String nome, int matricola, double salario) {
		super(nome, matricola, salario);
	}

	@Override
	public double calcolaRal() {
		return 13 * getSalarioMensile();
	}

}
