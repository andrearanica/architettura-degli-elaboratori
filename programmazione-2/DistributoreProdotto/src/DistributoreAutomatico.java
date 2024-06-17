import java.util.ArrayList;
import java.util.Collection;

public class DistributoreAutomatico {
	private ArrayList<Prodotto> prodotti;
	
	public DistributoreAutomatico(Collection<Prodotto> prodotti) {
		for (Prodotto prodotto: prodotti) {
			this.prodotti.add(prodotto);
		}
	}
	
	public Prodotto getProdotto(int position) throws PosizioneNonValidaException {
		if (this.prodotti.get(position) != null) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else {
			return this.prodotti.get(position);
		}
	}
	
	public void incrementaQuantitaProdotto(int position, int quantita) throws PosizioneNonValidaException {
		if (this.prodotti.indexOf(prodotti) == -1) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else {
			this.prodotti.get(position).incrementaQuantita(quantita);
		}
	}
	
	public int acquista(int position, int valore) throws PosizioneNonValidaException, ProdottoNonAcquistabileException {
		Prodotto prodotto = this.prodotti.get(position);
		if (prodotto == null) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else if (prodotto.getQuantita() == 0) {
			throw new ProdottoNonAcquistabileException("quantita insufficiente");					
		} else if (valore < prodotto.getPrezzoUnitario()){
			throw new ProdottoNonAcquistabileException("valore insufficiente");
		} else {
			return valore - prodotto.getPrezzoUnitario();
		}
	}
}
