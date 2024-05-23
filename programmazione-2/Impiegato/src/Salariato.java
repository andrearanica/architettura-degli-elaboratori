
public class Salariato extends Impiegato {
	private double salario;
	
	public Salariato(String nome, double salario) {
		super(nome);
		this.salario = salario;
	}
	
	@Override
	public double paga() {
		return salario;
	}
	
	public String toString() {
		return "Impiegato " + getNome() + " con contratto fisso. Stipeidio: " + paga();
	}
}
