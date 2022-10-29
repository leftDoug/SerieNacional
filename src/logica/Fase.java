package logica;

import java.util.ArrayList;
import java.util.Date;

public class Fase {

	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private ArrayList<Partido>partidos;

	public Fase(String nombre, Date fechaInicio, Date fechaFin) {
		this.nombre=nombre;
		this.fechaFin=fechaFin;
		this.fechaInicio=fechaInicio;
		partidos = new ArrayList<Partido>();
	}

	public String getNombre(){
		return nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public void agregarPartido(Equipo visitante, Equipo homeClub, Date fecha, Estadio estadio, int carrerasVisitante,
			int carrerasHomeClub, int audiencia){
		partidos.add(new Partido(visitante,homeClub,fecha,estadio,carrerasVisitante,carrerasHomeClub,audiencia));
		partidos.get(partidos.size()-1).ganador();
	}
	
//	public Partido buscarPartido(int x){
//		Partido p = null;
//		int i = 0;
//		
//		while(i < partidos.size() && p == null){
//			if(x == i){
//				p = partidos.get(x);
//			}
//			i++;
//		}
//		
//		return p;
//	}
	
//	public boolean modificarPartido(int x, Equipo visitante, Equipo homeClub, Date fecha, Estadio estadio, int carrerasVisitante,
//			int carrerasHomeClub, int audiencia){
//		boolean modificado = false;
//		
//		if(partidos.get(x) != null){
//			if(!partidos.get(x).getVisitante().equals(visitante)){
//				partidos.get(x).setVisitante(visitante);
//				modificado = true;
//			}
//			if(!partidos.get(x).getHomeClub().equals(homeClub)){
//				partidos.get(x).setHomeClub(homeClub);
//				modificado = true;
//			}
//			if(!partidos.get(x).getFecha().equals(fecha)){
//				partidos.get(x).setFecha(fecha);
//				modificado = true;
//			}
//			if(!partidos.get(x).getEstadio().equals(estadio)){
//				partidos.get(x).setEstadio(estadio);
//				modificado = true;
//			}
//			if(partidos.get(x).getCarrerasVisitante() != carrerasVisitante){
//				partidos.get(x).setCarrerasVisitante(carrerasVisitante);
//				modificado = true;
//			}
//			if(partidos.get(x).getCarrerasHomeClub() != carrerasHomeClub){
//				partidos.get(x).setCarrerasHomeClub(carrerasHomeClub);
//				modificado = true;
//			}
//			if(partidos.get(x).getAudiencia() != audiencia){
//				partidos.get(x).setAudiencia(audiencia);
//				modificado = true;
//			}
//		}
//		
//		return modificado;
//	}
	
}
