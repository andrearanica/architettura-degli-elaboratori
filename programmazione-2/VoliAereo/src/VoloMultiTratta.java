import java.util.List;

public class VoloMultiTratta extends Volo {
	private static String estraiAeroportoPartenza(List<VoloDiretto> tratte) {
		return tratte.get(0).getAeroportoPartenza();
	}
	
	private static String estraiAeroportoDestinazione(List<VoloDiretto> tratte) {
		return tratte.get(tratte.size()-1).getAeroportoArrivo();
	}
	
	private static boolean checkTratte(List<VoloDiretto> tratte) {
		if (tratte.size() < 2) {
			return false;
		}
		for (int i = 1; i < tratte.size(); i++) {
			if (tratte.get(i).getAeroportoPartenza() != tratte.get(i-1).getAeroportoArrivo()) {
				return false;
			}
		}
		return true;
	}
	
	private List<VoloDiretto> tratte;
	
	public VoloMultiTratta(List<VoloDiretto> tratte) throws VoloNonValidoException {
		super(estraiAeroportoPartenza(tratte), estraiAeroportoDestinazione(tratte));
		if (checkTratte(tratte)) {
			this.tratte = tratte;
		} else {
			throw new VoloNonValidoException("Combinazione di tratte non valida");
		}
	}
	
	public int getDurataInMinuti() {
		int durataTot = 0;
		for (VoloDiretto volo: this.tratte) {
			durataTot += volo.getDurataInMinuti();
		}
		return durataTot;
	}
	
	public int getNumeroTratte() {
		return this.tratte.size();
	}
}
