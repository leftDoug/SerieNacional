package logica;

public class Jugador extends Pelotero {

	private String posicion;
	private int errores;
	private int vecesAlBate;
	private int hits;
	private int homeRuns;
	private int promedioBateo;
	private boolean lesionado;

	public Jugador(String nombre, String apellido, String id, int numero,
			int aniosEnEquipo, String posicion, boolean lesionado) {
		super(nombre, apellido, id, numero, aniosEnEquipo);
		this.posicion = posicion;
		this.lesionado = lesionado;
	}
	
	public Jugador(String nombre, String apellido, String id, int numero,
			int aniosEnEquipo, String posicion, boolean lesionado, int vecesAlBate, int hits, int homeRuns, int errores) {
		super(nombre, apellido, id, numero, aniosEnEquipo);
		this.posicion = posicion;
		this.vecesAlBate = vecesAlBate;
		this.hits = hits;
		this.homeRuns = homeRuns;
		this.errores = errores;
		calcPromBateo();
		this.lesionado = lesionado;
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

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getErrores() {
		return errores;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public int getVecesAlBate() {
		return vecesAlBate;
	}

	public void setVecesAlBate(int vecesAlBate) {
		this.vecesAlBate = vecesAlBate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getHomeRuns() {
		return homeRuns;
	}

	public void setHomeRuns(int homeRuns) {
		this.homeRuns = homeRuns;
	}

	public int getPromedioBateo() {
		return promedioBateo;
	}

	public void calcPromBateo(){
		promedioBateo = (hits * 1000) / vecesAlBate;
	}

}
