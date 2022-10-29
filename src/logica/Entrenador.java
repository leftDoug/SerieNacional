package logica;

public class Entrenador extends Pelotero {

	private int aniosExp;

	public Entrenador(String nombre, String apellido, String id,
			int numero, int aniosEnEquipo, int aniosExp) {
		super(nombre, apellido, id, numero, aniosEnEquipo);
		this.aniosExp = aniosExp;
	}
	
	public int getAnosDeExperiencia() {
		return aniosExp;
	}

	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.aniosExp = anosDeExperiencia;
	}

}
