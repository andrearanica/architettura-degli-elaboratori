public abstract class Dipendente {
	private String nome;
	private int matricola;
	private double salarioMensile;
	
	public Dipendente(String nome, int matricola, double salario) {
		this.nome = nome;
		this.matricola = matricola;
		this.salarioMensile = salario;
	}
	
	public double getSalarioMensile() {
		return salarioMensile;
	}
	
	public abstract double calcolaRal();

}
