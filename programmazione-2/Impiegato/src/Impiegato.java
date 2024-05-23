
public abstract class Impiegato {
	private String nome;
	
	public Impiegato(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract double paga();
}