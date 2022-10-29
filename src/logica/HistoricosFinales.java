package logica;

import java.util.ArrayList;

public class HistoricosFinales {
//	private String equipo;
//	private int puntos;
//	private int numero;
	private ArrayList<Serie>series;
	private static HistoricosFinales historicos = null;
	
	public HistoricosFinales(){
//		this.equipo = equipo;
//		this.puntos = puntos;
//		this.numero = numero;
		series = new ArrayList<Serie>();
	}

//	public String getEquipo() {
//		return equipo;
//	}
//
//	public void setEquipo(String equipo) {
//		this.equipo = equipo;
//	}
//
//	public int getPuntos() {
//		return puntos;
//	}
//
//	public void setPuntos(int puntos) {
//		this.puntos = puntos;
//	}

	public static HistoricosFinales getInstance(){
		if (historicos == null) {
			historicos = new HistoricosFinales();
		}

		return historicos;
	}

	public ArrayList<Serie> getSeries() {
		return series;
	}

	public void setSeries(ArrayList<Serie> series) {
		this.series = series;
	}

//	public static HistoricosFinales getHistoricos() {
//		return historicos;
//	}
//
//	public static void setHistoricos(HistoricosFinales historicos) {
//		HistoricosFinales.historicos = historicos;
//	}
	
	public void agregarSerie(Serie x){
		
		series.add(x);
	}
//	public int getNumero() {
//		return numero;
//	}
//
//	public void setNumero(int serie) {
//		this.numero = serie;
//	}
}
