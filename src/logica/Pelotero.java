package logica;

public abstract class Pelotero {

	protected String nombre;
	protected String apellido;
	protected String id;
	protected int numero;
	protected int aniosEnEquipo;

	public Pelotero(String nombre, String apellido, String id,
			int numero, int aniosEnEquipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.numero = numero;
		this.aniosEnEquipo = aniosEnEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAniosEnEquipo() {
		return aniosEnEquipo;
	}

	public void setAniosEnEquipo(int aniosEnEquipo) {
		this.aniosEnEquipo = aniosEnEquipo;
	}

}
