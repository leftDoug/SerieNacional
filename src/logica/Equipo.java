package logica;

import java.util.ArrayList;


public class Equipo {

	private String nombre;
	private String provincia;
	private int campeonatosParticipados;
	private int campeonatosGanados;
	private String mascota;
	private String color;
	private String nombreDirector;
	private String apellido;
	private ArrayList<Pelotero>peloteros;
	private int puntos;

	public Equipo(String nombre, String provincia, int campeonatosParticipados,
			int campeonatosGanados, String mascota, String color,
			String nombreDirector, String apellido) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.campeonatosParticipados = campeonatosParticipados;
		this.campeonatosGanados = campeonatosGanados;
		this.mascota = mascota;
		this.color = color;
		this.nombreDirector = nombreDirector;
		this.apellido = apellido;
		peloteros = new ArrayList<Pelotero>();
	}

	public Equipo(String nombre, String provincia, int campeonatosParticipados,
			int campeonatosGanados, String mascota, String color,
			String nombreDirector, String apellido, int puntos) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.campeonatosParticipados = campeonatosParticipados;
		this.campeonatosGanados = campeonatosGanados;
		this.mascota = mascota;
		this.color = color;
		this.nombreDirector = nombreDirector;
		this.apellido = apellido;
		peloteros = new ArrayList<Pelotero>();
		this.puntos = puntos;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public int cantErrores() {
		int errores = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				errores += ((Jugador) peloteros.get(i)).getErrores();
			}
			else if(peloteros.get(i) instanceof Lanzador){
				errores += ((Lanzador) peloteros.get(i)).getErrores();
			}
		}
		return errores;
	}

	public int cantHits() {
		int hits = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				hits += ((Jugador) peloteros.get(i)).getHits();
			}
		}
		return hits;
	}

	public int cantHomeRuns() {
		int homeRuns = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				homeRuns += ((Jugador) peloteros.get(i)).getHomeRuns();
			}
		}
		return homeRuns;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCampeonatosParticipados() {
		return campeonatosParticipados;
	}

	public void setCampeonatosParticipados(int campeonatosParticipados) {
		this.campeonatosParticipados = campeonatosParticipados;
	}

	public int getCampeonatosGanados() {
		return campeonatosGanados;
	}

	public void setCampeonatosGanados(int campeonatosGanados) {
		this.campeonatosGanados = campeonatosGanados;
	}

	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<Pelotero> getPeloteros() {
		return peloteros;
	}

	public void setPeloteros(ArrayList<Pelotero> peloteros) {
		this.peloteros = peloteros;
	}

	public int cantVecesAlBate(){
		int totalVecesAlBate = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				totalVecesAlBate += ((Jugador)peloteros.get(i)).getVecesAlBate();
			}
		}
		return totalVecesAlBate;
	}

	public int calcPromBateo(){
		int totalPromBateo = 0;
		int contador = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				if(((Jugador)peloteros.get(i)).getVecesAlBate() > 0){
					totalPromBateo += ((Jugador)peloteros.get(i)).getPromedioBateo();
					contador++;
				}
			}
		}
		return contador != 0 ? totalPromBateo / contador : -1;
	}

	public float calcPromCarrerasLimpias(){
		float totalPromCarrerasLimpias = 0;
		int contador = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Lanzador){
				if(((Lanzador)peloteros.get(i)).getEntradasLanzadas() > 0){
					totalPromCarrerasLimpias += ((Lanzador)peloteros.get(i)).getCarrerasPermitidas();
					contador++;
				}
			}
		}
		return contador != 0 ? totalPromCarrerasLimpias / contador : -1;
	}

	public int cantLesionados(){
		int l = 0;

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				if(((Jugador)peloteros.get(i)).isLesionado()){
					l++;
				}
			}
		}

		return l;
	}

	public ArrayList<Lanzador>mejorPCL(){
		float PCL = 1000;
		ArrayList<Lanzador>l = new ArrayList<Lanzador>();

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Lanzador){
				if(((Lanzador)peloteros.get(i)).getEntradasLanzadas() > 0){
					if(((Lanzador)peloteros.get(i)).getPromCarrerasLimpias() < PCL){
						PCL = ((Lanzador)peloteros.get(i)).getPromCarrerasLimpias();
						if(l.size() != 0){
							l.removeAll(l);
						}
						l.add((Lanzador)peloteros.get(i));
					}
					else if(((Lanzador)peloteros.get(i)).getPromCarrerasLimpias() == PCL){
						l.add((Lanzador)peloteros.get(i));
					}
				}
			}
		}

		return l;
	}

	public ArrayList<Jugador>mejorAve(){
		int ave = 0;
		ArrayList<Jugador>ju = new ArrayList<Jugador>();

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				if(((Jugador)peloteros.get(i)).getVecesAlBate() > 0){
					if(((Jugador)peloteros.get(i)).getPromedioBateo() > ave){
						ave = ((Jugador)peloteros.get(i)).getPromedioBateo();
						if(ju.size() != 0){
							ju.removeAll(ju);
						}
						ju.add((Jugador)peloteros.get(i));
					}
					else if(((Jugador)peloteros.get(i)).getPromedioBateo() == ave && ave != 0){
						ju.add((Jugador)peloteros.get(i));
					}
				}
			}
		}

		return ju;
	}

	public ArrayList<Jugador>mayorHomeRuns(){
		int hr = 0;
		ArrayList<Jugador>ju = new ArrayList<Jugador>();

		for(int i = 0; i < peloteros.size(); i++){
			if(peloteros.get(i) instanceof Jugador){
				if(((Jugador)peloteros.get(i)).getVecesAlBate() > 0){
					if(((Jugador)peloteros.get(i)).getHomeRuns() > hr){
						hr = ((Jugador)peloteros.get(i)).getHomeRuns();
						if(ju.size() != 0){
							ju.removeAll(ju);
						}
						ju.add((Jugador)peloteros.get(i));
					}
					else if(((Jugador)peloteros.get(i)).getHomeRuns() == hr && hr != 0){
						ju.add((Jugador)peloteros.get(i));
					}
				}
			}
		}

		return ju;
	}

	public Pelotero buscarPelotero(int numero){
		Pelotero pelotero = null;
		boolean encontrado = false;
		int i = 0;

		while(!encontrado && i < peloteros.size()){
			if(peloteros.get(i).getNumero() == numero){
				pelotero = peloteros.get(i);
				encontrado = true;
			}
			else
				i++;
		}

		return pelotero;
	}

	public Pelotero buscarPelotero(String id){
		Pelotero pelotero = null;
		boolean encontrado = false;
		int i = 0;

		while(!encontrado && i < peloteros.size()){
			if(peloteros.get(i).getId().equals(id)){
				pelotero = peloteros.get(i);
				encontrado = true;
			}
			else
				i++;
		}

		return pelotero;
	}

	public boolean agregarJugador(String nombre, String apellido, String id, int numero,
			int aniosEnEquipo, String posicion, boolean lesionado){
		boolean agregado = false;

		if(buscarPelotero(numero) == null){
			agregado = peloteros.add(new Jugador(nombre, apellido, id, numero, aniosEnEquipo,
					posicion, lesionado));
		}

		return agregado;
	}

//		public boolean agregarJugador(String nombre, String apellido, String id, int numero,
//				int aniosEnEquipo, String posicion, boolean lesionado, int vecesAlBate, int hits, int homeRuns, int errores){
//			boolean agregado = false;
//	
//			if(buscarPelotero(numero) == null){
//				agregado = peloteros.add(new Jugador(nombre, apellido, id, numero, aniosEnEquipo,
//						posicion, lesionado, vecesAlBate, hits, homeRuns, errores));
//				cantHits();
//			}
//	
//			return agregado;
//		}

	public boolean modificarJugador(String nombre, String apellido, int numero, String posicion, String id, int aniosEq, int vecesAlBate, int hits, int homeRuns, int errores, boolean lesionado,
			String nombreN, String apellidoN, int numeroN, String posicionN, String idN, int aniosEqN, int vecesAlBateN, int hitsN, int homeRunsN, int erroresN, boolean lesionadoN){
		boolean modificado = false;

		if(!nombre.equalsIgnoreCase(nombreN)){
			((Jugador)buscarPelotero(numero)).setNombre(nombreN);
			modificado = true;
		}
		if(!apellido.equalsIgnoreCase(apellidoN)){
			((Jugador)buscarPelotero(numero)).setApellido(apellidoN);
			modificado = true;
		}
		if(!id.equalsIgnoreCase(idN)){
			((Jugador)buscarPelotero(numero)).setId(idN);
			modificado = true;
		}
		if(aniosEq != aniosEqN){
			((Jugador)buscarPelotero(numero)).setAniosEnEquipo(aniosEqN);
			modificado = true;
		}
		if(vecesAlBate != vecesAlBateN){
			((Jugador)buscarPelotero(numero)).setVecesAlBate(vecesAlBateN);
			modificado = true;
		}
		if(hits != hitsN){
			((Jugador)buscarPelotero(numero)).setHits(hitsN);
			modificado = true;
			cantHits();
		}
		if(homeRuns != homeRunsN){
			((Jugador)buscarPelotero(numero)).setHomeRuns(homeRunsN);
			modificado = true;
		}
		if(errores != erroresN){
			((Jugador)buscarPelotero(numero)).setErrores(erroresN);
			modificado = true;
		}
		if(lesionado != lesionadoN){
			((Jugador)buscarPelotero(numero)).setLesionado(lesionadoN);;
			modificado = true;
		}
		if(numero != numeroN){
			((Jugador)buscarPelotero(numero)).setNumero(numeroN);
			modificado = true;
		}
		if(!posicion.equalsIgnoreCase(posicionN)){
			((Jugador)buscarPelotero(numero)).setPosicion(posicionN);
			if(posicionN.equals("Lanzador")){
				peloteros.remove((Jugador) buscarPelotero(numeroN));
				agregarLanzador(nombreN, apellidoN, idN, numeroN, aniosEqN, lesionadoN);
			}
			modificado = true;
		}

		return modificado;
	}

	public boolean agregarLanzador(String nombre, String apellido, String id, int numero,
			int aniosEnEquipo, boolean lesionado){
		boolean agregado = false;

		if(buscarPelotero(numero) == null){
			agregado = peloteros.add(new Lanzador(nombre, apellido, id,
					numero, aniosEnEquipo, lesionado));
		}

		return agregado;
	}

//	public boolean agregarLanzador(String nombre, String apellido, String id, int numero,
//			int aniosEnEquipo, boolean lesionado, int entradasLanzadas, int carrerasPermitidas, int errores){
//		boolean agregado = false;
//
//		if(buscarPelotero(numero) == null){
//			agregado = peloteros.add(new Lanzador(nombre, apellido, id,
//					numero, aniosEnEquipo, lesionado, entradasLanzadas, carrerasPermitidas, errores));
//		}
//
//		return agregado;
//	}

	public boolean modificarLanzador(String nombre, String apellido, int numero, String id, int aniosEq, int entradasLanzadas, int carrerasPermitidas, int errores, boolean lesionado,
			String nombreN, String apellidoN, int numeroN, String idN, int aniosEqN, int entradasLanzadasN, int carrerasPermitidasN, int erroresN, boolean lesionadoN){
		boolean modificado = false;

		if(!nombre.equalsIgnoreCase(nombreN)){
			((Lanzador)buscarPelotero(numero)).setNombre(nombreN);
			modificado = true;
		}
		if(!apellido.equalsIgnoreCase(apellidoN)){
			((Lanzador)buscarPelotero(numero)).setApellido(apellidoN);
			modificado = true;
		}
		if(!id.equalsIgnoreCase(idN)){
			((Lanzador)buscarPelotero(numero)).setId(idN);
			modificado = true;
		}
		if(aniosEq != aniosEqN){
			((Lanzador)buscarPelotero(numero)).setAniosEnEquipo(aniosEqN);
			modificado = true;
		}
		if(entradasLanzadas != entradasLanzadasN){
			((Lanzador)buscarPelotero(numero)).setEntradasLanzadas(entradasLanzadasN);
			modificado = true;
		}
		if(carrerasPermitidas != carrerasPermitidasN){
			((Lanzador)buscarPelotero(numero)).setCarrerasPermitidas(carrerasPermitidasN);
			modificado = true;
		}
		if(errores != erroresN){
			((Lanzador)buscarPelotero(numero)).setErrores(erroresN);
			modificado = true;
		}
		if(lesionado != lesionadoN){
			((Lanzador)buscarPelotero(numero)).setLesionado(lesionadoN);;
			modificado = true;
		}
		if(numero != numeroN){
			((Lanzador)buscarPelotero(numero)).setNumero(numeroN);
			modificado = true;
		}

		return modificado;
	}

	public boolean agregarEntrenador(String nombre, String apellido, String id, int numero,
			int aniosEnEquipo, int aniosExp){
		boolean agregado = false;

		if(buscarPelotero(numero) == null){
			agregado = peloteros.add(new Entrenador(nombre, apellido, id,
					numero, aniosEnEquipo, aniosExp));
		}

		return agregado;
	}

	public boolean modificarEntrenador(String nombre, String apellido, int numero, String id, int aniosEq, int aniosExp,
			String nombreN, String apellidoN, int numeroN, String idN, int aniosEqN, int aniosExpN){
		boolean modificado = false;

		if(!nombre.equalsIgnoreCase(nombreN)){
			((Entrenador)buscarPelotero(numero)).setNombre(nombreN);
			modificado = true;
		}
		if(!apellido.equalsIgnoreCase(apellidoN)){
			((Entrenador)buscarPelotero(numero)).setApellido(apellidoN);
			modificado = true;
		}
		if(!id.equalsIgnoreCase(idN)){
			((Entrenador)buscarPelotero(numero)).setId(idN);
			modificado = true;
		}
		if(aniosEq != aniosEqN){
			((Entrenador)buscarPelotero(numero)).setAniosEnEquipo(aniosEqN);
			modificado = true;
		}
		if(aniosExp != aniosExpN){
			((Entrenador)buscarPelotero(numero)).setAnosDeExperiencia(aniosExpN);
			modificado = true;
		}
		if(numero != numeroN){
			((Entrenador)buscarPelotero(numero)).setNumero(numeroN);
			modificado = true;
		}

		return modificado;
	}
}
