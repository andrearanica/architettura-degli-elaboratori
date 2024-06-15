public class Dirigente extends Dipendente {
	private double benefit;
	
	public Dirigente(String nome, int matricola, double salario, double benefit) {
		super(nome, matricola, salario);
		this.benefit = benefit;
	}

	@Override
	public double calcolaRal() {
		return 14 * getSalarioMensile() + benefit;
	}

	public double getBenefit() {
		return benefit;
	}

}
