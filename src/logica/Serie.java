package logica;

import java.util.ArrayList;
import java.util.Date;

public class Serie {

	private ArrayList<Equipo>equipos;
	private ArrayList<Fase>fases;
	private ArrayList<Estadio>estadios;
	private static Serie serie = null;
	//	private ArrayList<HistoricosFinales>historicos;

	public Serie() {
		equipos = new ArrayList<Equipo>();
		fases = new ArrayList<Fase>();
		estadios = new ArrayList<Estadio>();
		//		historicos = new ArrayList<HistoricosFinales>();
	}

	public static Serie getInstance(){
		if (serie == null) {
			serie = new Serie();
		}

		return serie;
	}

	//	public ArrayList<HistoricosFinales> getHistoricos() {
	//		return historicos;
	//	}
	//
	//	public void setHistoricos(ArrayList<HistoricosFinales> historicos) {
	//		this.historicos = historicos;
	//	}

	public ArrayList<Estadio> getEstadios() {
		return estadios;
	}

	public void setEstadios(ArrayList<Estadio> estadios) {
		this.estadios = estadios;
	}

	public ArrayList<Fase> getFases() {
		return fases;
	}

	public void setFases(ArrayList<Fase> fases) {
		this.fases = fases;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo buscarEquipo(String nombre){
		Equipo e = null;
		int i = 0;

		while(i < equipos.size() && e == null){
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombre)){
				e = equipos.get(i);
			}
			i++;
		}

		return e;
	}

	public boolean agregarEquipo(String nombre, String provincia, int campeonatosParticipados,
			int campeonatosGanados, String mascota, String color,
			String nombreDirector, String apellido){
		boolean agregado = false;

		if(buscarEquipo(nombre) == null){
			agregado = equipos.add(new Equipo(nombre, provincia, campeonatosParticipados,
					campeonatosGanados, mascota, color, nombreDirector, apellido));
		}

		return agregado;
	}

	public boolean agregarEquipo(String nombre, String provincia, int campeonatosParticipados,
			int campeonatosGanados, String mascota, String color,
			String nombreDirector, String apellido, int puntos){
		boolean agregado = false;

		if(buscarEquipo(nombre) == null){
			agregado = equipos.add(new Equipo(nombre, provincia, campeonatosParticipados,
					campeonatosGanados, mascota, color, nombreDirector, apellido, puntos));
		}

		return agregado;
	}

	public boolean modificarEquipo(String nombre, String provincia, int campeonatosParticipados,
			int campeonatosGanados, String mascota, String color,
			String nombreDirector, String apellido, String nombreN){
		boolean modificado = false;

		if(buscarEquipo(nombre).getCampeonatosParticipados() != campeonatosParticipados){
			buscarEquipo(nombre).setCampeonatosParticipados(campeonatosParticipados);
			modificado = true;
		}

		if(buscarEquipo(nombre).getCampeonatosGanados() != campeonatosGanados){
			buscarEquipo(nombre).setCampeonatosGanados(campeonatosGanados);
			modificado = true;
		}

		if(!buscarEquipo(nombre).getMascota().equalsIgnoreCase(mascota)){
			buscarEquipo(nombre).setMascota(mascota);
			modificado = true;
		}

		if(!buscarEquipo(nombre).getColor().equalsIgnoreCase(color)){
			buscarEquipo(nombre).setColor(color);
			modificado = true;
		}

		if(!buscarEquipo(nombre).getNombreDirector().equalsIgnoreCase(nombreDirector)){
			buscarEquipo(nombre).setNombreDirector(nombreDirector);
			modificado = true;
		}

		if(!buscarEquipo(nombre).getApellido().equalsIgnoreCase(apellido)){
			buscarEquipo(nombre).setApellido(apellido);
			modificado = true;
		}

		if(!buscarEquipo(nombre).getNombre().equalsIgnoreCase(nombreN)){
			buscarEquipo(nombre).setNombre(nombreN);
			modificado = true;
		}

		return modificado;
	}

	public ArrayList<Equipo>tablaPosiciones(){
		int x = 0;
		int y = 0;
		ArrayList<Equipo>e1=new ArrayList<Equipo>();
		ArrayList<Equipo>e2=new ArrayList<Equipo>();
		e1.addAll(equipos);

		while(e1.size() > 0){
			for(int i = 0; i < e1.size(); i++){
				if(e1.get(i).getPuntos() > x){
					x = e1.get(i).getPuntos();
					y = i;
				}
				else if(e1.get(i).getPuntos() == x && e1.get(i).calcPromBateo() > e1.get(y).calcPromBateo()){
					y = i;
				}
			}
			if(x != 0){
				e2.add(e1.get(y));
				e1.remove(e1.get(y));
				x = 0;
				y = 0;
			}
			else{
				e2.add(e1.get(0));
				e1.remove(e1.get(0));
			}
		}

		return e2;
	}

	public ArrayList<Lanzador>mejorPCLLanzador(){
		float PCL = 1000;
		ArrayList<Lanzador>l = new ArrayList<Lanzador>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mejorPCL().size() != 0){
				if(equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias() < PCL){
					PCL = equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias();
					if(l.size() != 0){
						l.removeAll(l);
					}
					l.addAll(equipos.get(i).mejorPCL());
				}
				else if(equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias() == PCL){
					l.addAll(equipos.get(i).mejorPCL());
				}
			}
			i++;
		}

		return l;
	}

	public ArrayList<Equipo>mejorPCLEquipo(){
		float PCL = 1000;
		ArrayList<Equipo>e = new ArrayList<Equipo>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mejorPCL().size() != 0){
				if(equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias() < PCL){
					PCL = equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias();
					if(e.size() != 0){
						e.removeAll(e);
					}
					for(int j = 0; j < equipos.get(i).mejorPCL().size(); j++){
						e.add(equipos.get(i));
					}
				}
				else if(equipos.get(i).mejorPCL().get(0).getPromCarrerasLimpias() == PCL){
					for(int k = 0; k < equipos.get(i).mejorPCL().size(); k++){
						e.add(equipos.get(i));
					}
				}
			}
			i++;
		}

		return e;
	}

	public ArrayList<Jugador>mejorAveJugador(){
		int ave = 0;
		ArrayList<Jugador>ju = new ArrayList<Jugador>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mejorAve().size() != 0){
				if(equipos.get(i).mejorAve().get(0).getPromedioBateo() > ave){
					ave = equipos.get(i).mejorAve().get(0).getPromedioBateo();
					if(ju.size() != 0){
						ju.removeAll(ju);
					}
					ju.addAll(equipos.get(i).mejorAve());
				}
				else if(equipos.get(i).mejorAve().get(0).getPromedioBateo() == ave){
					ju.addAll(equipos.get(i).mejorAve());
				}
			}
			i++;
		}

		return ju;
	}

	public ArrayList<Equipo>mejorAveEquipo(){
		int ave = 0;
		ArrayList<Equipo>e = new ArrayList<Equipo>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mejorAve().size() != 0){
				if(equipos.get(i).mejorAve().get(0).getPromedioBateo() > ave){
					ave = equipos.get(i).mejorAve().get(0).getPromedioBateo();
					if(e.size() != 0){
						e.removeAll(e);
					}
					for(int j = 0; j < equipos.get(i).mejorAve().size(); j++){
						e.add(equipos.get(i));
					}
				}
				else if(equipos.get(i).mejorAve().get(0).getPromedioBateo() == ave){
					for(int k = 0; k < equipos.get(i).mejorAve().size(); k++){
						e.add(equipos.get(i));
					}
				}
			}
			i++;
		}

		return e;
	}

	public ArrayList<Jugador>mayorHomeRunJugador(){
		int hr = 0;
		ArrayList<Jugador>ju = new ArrayList<Jugador>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mayorHomeRuns().size() != 0){
				if(equipos.get(i).mayorHomeRuns().get(0).getHomeRuns() > hr){
					hr = equipos.get(i).mayorHomeRuns().get(0).getHomeRuns();
					if(ju.size() != 0){
						ju.removeAll(ju);
					}
					ju.addAll(equipos.get(i).mayorHomeRuns());
				}
				else if(equipos.get(i).mayorHomeRuns().get(0).getHomeRuns() == hr){
					ju.addAll(equipos.get(i).mayorHomeRuns());
				}
			}
			i++;
		}

		return ju;
	}

	public ArrayList<Equipo>mayorHomeRunEquipo(){
		int hr = 0;
		ArrayList<Equipo>e = new ArrayList<Equipo>();
		int i = 0;

		while(i < equipos.size()){
			if(equipos.get(i).mayorHomeRuns().size() != 0){
				if(equipos.get(i).mayorHomeRuns().get(0).getHomeRuns() > hr){
					hr = equipos.get(i).mayorHomeRuns().get(0).getHomeRuns();
					if(e.size() != 0){
						e.removeAll(e);
					}
					for(int j = 0; j < equipos.get(i).mayorHomeRuns().size(); j++){
						e.add(equipos.get(i));
					}
				}
				else if(equipos.get(i).mayorHomeRuns().get(0).getHomeRuns() == hr){
					for(int k = 0; k < equipos.get(i).mayorHomeRuns().size(); k++){
						e.add(equipos.get(i));
					}
				}
			}
			i++;
		}

		return e;
	}

	public static Serie getSerie() {
		return serie;
	}

	public static void setSerie(Serie serie) {
		Serie.serie = serie;
	}

	public Estadio buscarEstadio(String nombre, String provincia){
		Estadio e = null;
		int i = 0;

		while(i < estadios.size() && e == null){
			if((estadios.get(i).getNombre().equalsIgnoreCase(nombre)) &&
					estadios.get(i).getProvincia().equalsIgnoreCase(provincia)){
				e = estadios.get(i);
			}
			i++;
		}

		return e;
	}

	public boolean agregarEstadio(String nombre, String provincia, int capacidad){
		boolean agregado = false;

		if(buscarEstadio(nombre, provincia) == null){
			agregado = estadios.add(new Estadio(nombre, capacidad, provincia));
		}

		return agregado;
	}

	public boolean modificarEstadio(Estadio e, String nombre, String provincia, int capacidad){
		boolean modificado = false;

		if(e.getCapacidad() != capacidad){
			e.setCapacidad(capacidad);
			modificado = true;
		}

		if(!e.getNombre().equalsIgnoreCase(nombre)){
			e.setNombre(nombre);
			modificado = true;
		}

		if(!e.getProvincia().equalsIgnoreCase(provincia)){
			e.setProvincia(provincia);
			modificado = true;
		}

		return modificado;
	}

	public Fase buscarFase(String nombre){
		Fase f = null;
		int i = 0;

		while(i < fases.size() && f == null){
			if(fases.get(i).getNombre().equalsIgnoreCase(nombre)){
				f = fases.get(i);
			}
			i++;
		}

		return f;
	}

	public boolean agregarFase(String nombre, Date fechaI, Date fechaF){
		boolean agregado = false;

		if(buscarFase(nombre) == null){
			fases.add(new Fase(nombre, fechaI, fechaF));
			agregado = true;
		}

		return agregado;
	}

	public boolean modificarFase(Fase f, Date fechaI, Date fechaF){
		boolean modificado = false;

		if(buscarFase(f.getNombre()) != null){
			if(!f.getFechaInicio().equals(fechaI)){
				f.setFechaInicio(fechaI);
				modificado = true;
			}
			if(!f.getFechaFin().equals(fechaF)){
				f.setFechaFin(fechaF);
				modificado = true;
			}
		}
		return modificado;
	}

	public void actualizarHistoricos(Serie x){
		HistoricosFinales.getInstance().agregarSerie(x);
	}

}
