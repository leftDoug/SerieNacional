package logica;

public class Lanzador extends Pelotero {

	private final String posicion = "Lanzador";
	private boolean lesionado;
	private int entradasLanzadas;
	private int carrerasPermitidas;
	private int errores;
	private float promCarrerasLimpias;

	public Lanzador(String nombre, String apellido, String id,
			int numero, int anosEnEquipo, boolean lesionado) {
		super(nombre, apellido, id, numero, anosEnEquipo);
		this.lesionado = lesionado;
	}
	
	public Lanzador(String nombre, String apellido, String id,
			int numero, int anosEnEquipo, boolean lesionado, int entradasLanzadas, int carrerasPermitidas, int errores) {
		super(nombre, apellido, id, numero, anosEnEquipo);
		this.lesionado = lesionado;
		this.entradasLanzadas = entradasLanzadas;
		this.carrerasPermitidas = carrerasPermitidas;
		this.errores = errores;
		calcPromCarrerasLimpias();
	}

	public int getErrores() {
		return errores;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public boolean isLesionado() {
		return lesionado;
	}

	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}

	public String getPosicion() {
		return posicion;
	}

	public int getEntradasLanzadas() {
		return entradasLanzadas;
	}

	public void setEntradasLanzadas(int entradasLanzadas) {
		this.entradasLanzadas = entradasLanzadas;
	}

	public int getCarrerasPermitidas() {
		return carrerasPermitidas;
	}

	public void setCarrerasPermitidas(int carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}

	public float getPromCarrerasLimpias() {
		return promCarrerasLimpias;
	}

	public void calcPromCarrerasLimpias(){
		promCarrerasLimpias = (carrerasPermitidas * 9) / entradasLanzadas;
	}
}
