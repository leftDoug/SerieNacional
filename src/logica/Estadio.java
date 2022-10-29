package logica;

public class Estadio {

	private String nombre;
	private int capacidad;
	private String provincia;

	public Estadio(String nombre, int capacidad, String provincia) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
