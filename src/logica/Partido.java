package logica;

import java.util.Date;

public class Partido {

	private Equipo visitante;
	private Equipo homeClub;
	private Date fecha;
	private Estadio estadio;
	private int carrerasVisitante;
	private int carrerasHomeClub;
	private int audiencia;

	public Partido(Equipo visitante, Equipo homeClub, Date fecha,
			Estadio estadio, int carrerasVisitante,
			int carrerasHomeClub, int audiencia) {
		this.visitante = visitante;
		this.homeClub = homeClub;
		this.fecha = fecha;
		this.estadio = estadio;
		this.carrerasVisitante = carrerasVisitante;//no puede ser negativa
		this.carrerasHomeClub = carrerasHomeClub;//no puede ser negativa
		this.audiencia = audiencia;//no puede ser mayor que la del estadio ni negativa
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public Equipo getHomeClub() {
		return homeClub;
	}

	public void setHomeClub(Equipo homeClub) {
		this.homeClub = homeClub;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public int getCarrerasVisitante() {
		return carrerasVisitante;
	}

	public void setCarrerasVisitante(int carrerasVisitante) {
		this.carrerasVisitante = carrerasVisitante;
	}
	
	public int getCarrerasHomeClub() {
		return carrerasHomeClub;
	}

	public void setCarrerasHomeClub(int carrerasHomeClub) {
		this.carrerasHomeClub = carrerasHomeClub;
	}

	public int getAudiencia() {
		return audiencia;
	}

	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	public void ganador(){
		if(carrerasHomeClub > carrerasVisitante){
			homeClub.setPuntos(homeClub.getPuntos() + 1);
		}
		else if(carrerasVisitante > carrerasHomeClub){
			visitante.setPuntos(visitante.getPuntos() + 1);
		}
	}
}
