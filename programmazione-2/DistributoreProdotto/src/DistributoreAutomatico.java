import java.util.ArrayList;
import java.util.Collection;

public class DistributoreAutomatico {
	private ArrayList<Prodotto> prodotti;
	
	public DistributoreAutomatico(Collection<Prodotto> prodotti) {
		this.prodotti = new ArrayList<Prodotto>();
		for (Prodotto prodotto: prodotti) {
			this.prodotti.add(prodotto);
		}
	}
	
	public Prodotto getProdotto(int position) throws PosizioneNonValidaException {
		if (position < 0 || position >= this.prodotti.size()) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else {
			return this.prodotti.get(position);
		}
	}
	
	public void incrementaQuantitaProdotto(int position, int quantita) throws PosizioneNonValidaException {
		if (position < 0 || position >= this.prodotti.size()) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else {
			this.prodotti.get(position).incrementaQuantita(quantita);
		}
	}
	
	public int acquista(int position, int valore) throws PosizioneNonValidaException, ProdottoNonAcquistabileException {
		if (position >= this.prodotti.size()) {
			throw new PosizioneNonValidaException("Position "+position+" is not a valid position");
		} else {
			Prodotto prodotto = this.prodotti.get(position);
			if (prodotto.getQuantita() == 0) {
				throw new ProdottoNonAcquistabileException("quantita insufficiente");					
			} else if (valore < prodotto.getPrezzoUnitario()){
				throw new ProdottoNonAcquistabileException("valore insufficiente");
			} else {
				prodotto.decrementaQuantita(1);
				return valore - prodotto.getPrezzoUnitario();
			}
		}
	}
}
