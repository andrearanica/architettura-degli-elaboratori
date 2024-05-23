
public class AdOre extends Impiegato {
	private double pagaOraria;
	private double ore;
	
	public AdOre(String nome, double pagaOraria, double ore) {
		super(nome);
		this.pagaOraria = pagaOraria;
		this.ore = ore;
	}
	
	@Override
	public double paga() {
		return pagaOraria * ore;
	}
	
	public String toString() {
		return "Impiegato " + this.getNome() + " con contratto ad ore. La paga oraria è di " + pagaOraria + " e le ore svolte sono " + ore + ". Stipendio: " + paga();
	}
}
