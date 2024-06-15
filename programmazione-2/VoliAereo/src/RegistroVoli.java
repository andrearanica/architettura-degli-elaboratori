import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RegistroVoli {
	private HashMap<String, Volo> voli;
	
	public RegistroVoli() {
		this.voli = new HashMap<String, Volo>();
	}
	
	public void aggiungiVolo(String codice, Volo volo) throws CodiceVoloNonValidoException {
		if (codice.length() == 5) {
			this.voli.put(codice, volo);
		} else {
			throw new CodiceVoloNonValidoException("Codice " + codice + " non valido");
		}
	}
	
	public void aggiungiVolo(String codice, String aeroportoPartenza, String aeroportoDestinazione, int durata) throws CodiceVoloNonValidoException, VoloNonValidoException {
		if (codice.length() == 5) {
			Volo volo = new VoloDiretto(aeroportoPartenza, aeroportoDestinazione, durata);
			this.voli.put(codice, volo);
		} else {
			throw new CodiceVoloNonValidoException("Codice " + codice + " non valido");
		}
	}
	
	public Volo getVolo(String codice) {
		return this.voli.get(codice);
	}
	
	public String[] getListaCodiciDeiVoli() {
		Set<String> codes = this.voli.keySet();
		String[] codici = new String[voli.size()];
		int nCodici = 0;
		for (String code: codes) {
			codici[nCodici] = code;
			nCodici++;
		}
		return codici;
	}
	
	public void dumpSuFile(String nomeFile) {
		File file = new File(nomeFile);
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
			for (String codice: this.getListaCodiciDeiVoli()) {
				Volo volo = this.voli.get(codice);
				writer.write(volo.toString() + "\n");
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
