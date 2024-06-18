import java.util.Objects;

public class Rettangolo implements Poligono {
	private double altezza;
	private double base;
	
	public Rettangolo(double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public double calcolaArea() {
		return base*altezza;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Rettangolo) obj;
		return Math.abs(this.calcolaArea() - other.calcolaArea()) <= 0.001;
	}
}
