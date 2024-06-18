import java.util.ArrayList;

public class DisegnoGeometrico {
	private ArrayList<Poligono> poligoni;
	
	public DisegnoGeometrico() {
		this.poligoni = new ArrayList<Poligono>();
	}
	
	public void aggiungiPoligono(Poligono poligono) {
		this.poligoni.add(poligono);
	}
	
	public double calcolaAreaTotale() throws NoPoligoniException {
		if (this.poligoni.size() == 0) {
			throw new NoPoligoniException("There are no polygons in this design");
		} else {
			double area = 0;
			for (Poligono poligono: this.poligoni) {
				area += poligono.calcolaArea();
			}
			return area;
		}
	}
}
