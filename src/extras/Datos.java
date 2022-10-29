package extras;

import logica.Equipo;
import logica.HistoricosFinales;
import logica.Serie;

public class Datos {
	public static void inicializarDatos(){
		Serie.getInstance().agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo");
		Serie.getInstance().agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino");
		Serie.getInstance().agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada");
		Serie.getInstance().agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado");
		Serie.getInstance().agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa");
		Serie.getInstance().agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret");
		Serie.getInstance().agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez");
		Serie.getInstance().agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado");
		Serie.getInstance().agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado");
		Serie.getInstance().agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		Serie.getInstance().agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil");
		Serie.getInstance().agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González");
		Serie.getInstance().agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí");
		Serie.getInstance().agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales");
		Serie.getInstance().agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó");
		Serie.getInstance().agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez");
		
		//PINAR_DEL_RIO
				Equipo e = Serie.getInstance().getEquipos().get(0);
				
				e.agregarJugador("Olber", "Peña", "69051268253", 10, 5, "Receptor", false);
				e.agregarJugador("William", "Saavedra", "97083069535", 6, 2, "Primera Base", false);
				e.agregarJugador("Dayron", "Hernández", "75120968254", 23, 19, "Campo Corto", false);
				e.agregarJugador("Reinaldo", "Lazaga", "95010443217", 17, 6, "Jardinero Izquierdo", true);
				e.agregarJugador("Pedro", "Dueñas", "83042512356", 8, 10, "Tercera Base", false);
				e.agregarJugador("Luis", "García", "89120456212", 3, 9, "Campo Corto", false);
				e.agregarJugador("Frank", "Díaz", "88022557814", 20, 11, "Jardinero Central", true);
				e.agregarJugador("Lázaro", "Blanco", "89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Reinier", "León", "88020156214", 5, 11, "Jardinero Central", false);
				e.agregarJugador("Luis", "Acosta", "77112349519", 24, 22, "Jardinero Derecho", false);
				e.agregarJugador("Frank", "Álvarez", "74082543212", 19, 22, "Segunda Base", false);
				
				e.agregarLanzador("Liván", "Moinelo", "96092253689", 1, 4, false);
				e.agregarLanzador("Vladimir", "Baños", "79122624599", 2, 20, true);
				e.agregarLanzador("Yosvani", "Torres", "78061525369", 13, 20, false);
				
				//ARTEMISA
				e = Serie.getInstance().getEquipos().get(1);
				
				e.agregarEntrenador("Daniel Enrique", "Valdespino", "59051426365", 11, 42, 39);
				
				e.agregarJugador("José Carlos", "Padrón","69121269253", 14, 5, "Receptor", true);
				e.agregarJugador("Jorge Enrique", "Aloma","97081569435", 6, 2, "Primera Base", true);
				e.agregarJugador("Lázaro","Hernández","76122968254", 22, 19, "Tercera Base", false);
				e.agregarJugador("José","Palacios","95011343217", 8, 6, "Receptor", false);
				e.agregarJugador("Lían Camilo","Dueñas", "84041512356", 24, 10, "Segunda Base", false);
				e.agregarJugador("Osbec Enrique","Pacheco","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Yonsue","Moré","88062157814", 20, 11, "Primera Base", false);
				e.agregarJugador("Lázaro Emilio","Dayan","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Dayron","Blanco","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Rodmy","Proenza","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Gerardo","Trujillo","74082543212", 17, 22, "Receptor", false);
				
				e.agregarLanzador("José Ángel", "García","96051253689", 1, 4, true);
				e.agregarLanzador("Yulieski", "González","78071725369", 13, 20, false);
				
				//INDUSTRIALES
				e = Serie.getInstance().getEquipos().get(2);
						
				e.agregarEntrenador("Rey Vicente", "Anglada","69010141256", 20, 32, 19);
						
				e.agregarJugador("Frank Camilo", "Morejón","69111560655", 14, 5, "Segunda Base", false);
				e.agregarJugador("Alexander", "Mayeta","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Juan Carlos","Torriente","78122968254", 11, 19, "Receptor", false);
				e.agregarJugador("Oscar","Valdes","91011245231", 8, 6, "Jardinero Derecho", true);
				e.agregarJugador("Andres","Hernández","81031512351", 24, 10, "Tercera Base", false);
				e.agregarJugador("Wilfredo Ernesto","Aroche","88020452319", 3, 9, "Campocorto", false);
				e.agregarJugador("Henry","Morales","87052853238", 22, 11, "Segunda Base", true);
				e.agregarJugador("Yoandry","Urgelles","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Yoasan","Guillén","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Stayler Abel","Hernández","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Yordanyz","Samón","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Frank", "Monthiet","96051253659", 1, 4, true);
				e.agregarLanzador("Noelvis", "Entenza","78071725339", 2, 20, false);
				
				//MAYABEQUE
				e = Serie.getInstance().getEquipos().get(3);
						
				e.agregarEntrenador("Vannoy", "Arado", "79010141256", 34, 25, 20);
						
				e.agregarJugador("Luis","Fernández","68121268253", 14, 5, "Receptor", false);
				e.agregarJugador("Dariel","Oliva","82011565435", 6, 2, "Primera Base", false);
				e.agregarJugador("Yunior", "Corvo","77122968154", 21, 19, "Segunda Base", false);
				e.agregarJugador("Javier", "Carabeo","91021343412", 8, 6, "Campocorto", true);
			    e.agregarJugador("William", "González","81041612151", 24, 10, "Tercera Base", false);
				e.agregarJugador("Michael", "Gonzalez","840219537178", 3, 9, "Campocorto", false);
				e.agregarJugador("Rangel", "Ramos","86112757215", 20, 11, "Tercera Base", true);
				e.agregarJugador("Dennis", "Laza","87080844217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Orlando", "Lavandera","8802175825", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Alexander", "Pozo","76122349915", 23, 22, "Jardinero Derecho", true);
				e.agregarJugador("Dayron", "Cabrera","76082546216", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Yadian","Martínez","90051257679", 1, 4, false);
				e.agregarLanzador("Darian","Alonso","76071725616", 13, 20, false);
						
				//MATANZAS
				e = Serie.getInstance().getEquipos().get(4);
						
				e.agregarEntrenador("Victor", "Figueroa", "84010941136", 12, 30, 29);
						
				e.agregarJugador("Ariel","Martínez","89121969116", 14, 5, "Receptor", false);
				e.agregarJugador("Yasiel","Santoya","79082566932", 6, 2, "Primera Base", false);
				e.agregarJugador("Yurisbel", "Gracial","90123068651", 21, 19, "Segunda Base", false);
				e.agregarJugador("Lázaro", "Herrera","95011249512", 8, 6, "Jardinero Derecho", false);
				e.agregarJugador("Jefferson", "Delgado","81042512458", 24, 10, "Tercera Base", false);
				e.agregarJugador("Anibal", "Medina","81020854231", 20, 9, "Campocorto", false);
				e.agregarJugador("Yariel", "Duque","89061157514", 3, 11, "Primera Base", true);
				e.agregarJugador("Ariel", "Sánchez","81020744819", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Ernesto", "Blanco","86021856214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Dariel", "Polledo","77112349519", 23, 22, "Jardinero Derecho", true);
				e.agregarJugador("Yoisnel", "Camejo","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Yoenni","Yera","96051253689", 1, 4, false);
				e.agregarLanzador("Yonder","Martínez","78071725369", 13, 20, true);

				//CIENFUEGOS
				e = Serie.getInstance().getEquipos().get(5);
						
				e.agregarEntrenador("Alain", "Álvarez", "83010141256", 20, 42, 39);
				e.agregarEntrenador("Aláin", "Álvarez", "84021536958", 18, 15, 9);
						
				e.agregarJugador("Richel","Lopéz","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Daniel","Pérez","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Edwin", "Vassell","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Asiel", "Rodríguez","95011343217", 11, 6, "Receptor", true);
				e.agregarJugador("César", "Prieto","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Orlando", "Santos","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Pavel", "Quesada","88062157814", 8, 11, "Primera Base", true);
				e.agregarJugador("Yusniel", "Ibañez","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Juan", "Soriano","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Lazaro", "Rodríguez","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Orlando", "Roa","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Carlos","Ramírez","96051253689", 1, 4, true);
				e.agregarLanzador("Yasiel","Morales","78071725369", 13, 20, false);

				//VILLA CLARA
				e = Serie.getInstance().getEquipos().get(6);
						
				e.agregarEntrenador("Eduardo", "Paret", "59072341256", 35, 52, 49);
						
				e.agregarJugador("Yulexis","La Rosa","69121269253", 6, 5, "Receptor", false);
				e.agregarJugador("Ivalio","Leiva","81081569435", 14, 2, "Primera Base", false);
				e.agregarJugador("Andy", "Sarduy","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Javier", "Fuste","95011343217", 8, 6, "Jardinero Central", false);
				e.agregarJugador("Yeniet", "Pérez","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Michel", "Triana","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Juan", "López","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Andy", "Zamora","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Leandro", "Turiño","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Yurien", "Vizcaino","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Duviel", "Zamora","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Freddy","Álvarez","96051253689", 1, 4, false);
				e.agregarLanzador("Alain","Sánchez","78071725369", 26, 20, true);
						
				//SANTI SPÍRITUS
				e = Serie.getInstance().getEquipos().get(7);
						
				e.agregarEntrenador("José", "Delgado", "59120141256", 22, 50, 47);
						
				e.agregarJugador("Yunior","Barra","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Yunier","Mendoza","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Yoandi", "Baguet","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Rafael", "Acebey","95011343217", 8, 6, "Receptor", false);
				e.agregarJugador("José", "González","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Luis", "Serrano","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Diasmany", "Palacio","88062157814", 11, 11, "Tercera Base", true);
				e.agregarJugador("Frederich", "Cepeda","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Dunieski", "Barroso","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Miguel", "Gómez","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Daviel", "Gómez","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Ángel","Peña","96051253689", 1, 4, false);
				e.agregarLanzador("Yoén","Socarrás","78071725369", 13, 20, false);
						
				//CIEGO DE ÁVILA
				e = Serie.getInstance().getEquipos().get(8);
						
				e.agregarEntrenador("Roger", "Machado", "59052341256", 8, 55, 53);
				
				e.agregarJugador("Osvaldo","Vázquez","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Humberto","Morales","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Yaimel", "Bravo","78122968254", 13, 19, "Receptor", false);
				e.agregarJugador("Raúl", "González","95011343217", 11, 6, "Receptor", true);
				e.agregarJugador("Yorbis", "Borroto","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Rubén", "Valdés","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Alexander", "Jiménez","88062157814", 12, 11, "Primera Base", true);
				e.agregarJugador("Yoelvis", "Fis","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Abdel", "Civil","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Yuddiel", "González","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Michel", "Artega","74082543212", 17, 22, "Segunda Base", false);
						
				e.agregarLanzador("Vladimir","García","96051253689", 1, 4, false);
				e.agregarLanzador("Dachel","Duquesme","78071725369", 20, 20, true);
						
				//CAMAGÜEY
				e = Serie.getInstance().getEquipos().get(9);
						
				e.agregarEntrenador("Orlando", "González", "59010141256", 22, 40, 39);
						
				e.agregarJugador("Yendry","Téllez","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Leonel","Segura","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Pedro", "Smith","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Luis", "Gómez","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Humberto", "Bravo","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Alexander", "Ayala","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Eglis", "Eugellés","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Jorge", "Cardosa","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Dariel", "Ávila","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Yanmichel", "Flores","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Liván", "Amaro","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Yariel","Rodríguez","96051253689", 1, 4, false);
				e.agregarLanzador("José","Rodríguez","78071725369", 13, 20, true);
							
				//LAS TUNAS
				e = Serie.getInstance().getEquipos().get(10);
						
				e.agregarEntrenador("Pablo", "Civil", "60110141256", 12, 43, 20);
						
				e.agregarJugador("Yosvany","Alarcón","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Dánel","Castro","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Ernesto", "Lalana","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Oberto", "Coca","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Eduardo", "García","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Yudier", "Rondón","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Magdiel", "Gómez","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Jorge", "Yhonson","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Yuniesky", "Larduet","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Andrés", "Quiala","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Yordanis", "Alarcón","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Yoalkis","Cruz","96051253689", 13, 4, true);
				e.agregarLanzador("Yudiel","Rodríguez","78071725369", 1, 20, false);			
						
				//GRANMA
				e = Serie.getInstance().getEquipos().get(11);
						
				e.agregarEntrenador("Carlos", "Martí", "83010141256", 22, 37, 15);
						
				e.agregarJugador("Huber","Sánchez","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Guillermo","Avilés","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Carlos", "Benítez","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Darién", "García","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Yulián", "Milán","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Lázaro", "Cedeño","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Wilfredo", "Sánchez","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Raico", "Santos","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Roel", "Santos","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Yoelqui", "Céspedes","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Alfredo", "Despaigne","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Lázaro","Blanco","96051253689", 11, 4, true);
				e.agregarLanzador("Leandro","Martínez","78071725369", 1, 20, false);
					
				//HOLGUÍN
				e = Serie.getInstance().getEquipos().get(12);
						
				e.agregarEntrenador("Noelvis", "González", "59010141256", 33, 42, 39);
						
				e.agregarJugador("Franklin","Aballe","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Yordan","Manduley","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Yunior", "Paumier","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Iván", "Prieto","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Michael", "Gorgüet","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Pedro", "Almeida","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Noel", "González","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Geydi", "Soler","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Jorge", "Peña","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Oscar", "Julián","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Luis", "Domínguez","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Carlos","Santiesteban","96051253689", 11, 4, false);
				e.agregarLanzador("Luis","Gómez","78071725369", 13, 20, false);
						
				//SANTIAGO DE CUBA
				e = Serie.getInstance().getEquipos().get(13);
						
				e.agregarEntrenador("Eriberto", "Rosales", "73102134126", 22, 39, 38);
						
				e.agregarJugador("Alexander","Yanez","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Edisel","Silva","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Alejandro", "Sánchez","78122968254", 21, 19, "Segunda Base", false);
			    e.agregarJugador("Alberto", "Díaz","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Michael", "Gorgüet","84041512356", 4, 10, "Tercera Base", false);
				e.agregarJugador("Adriel", "Labrada","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Santiago", "Torres","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Sergio", "Barthelemy","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Yoelquis", "Guibert","88020156214", 24, 11, "Jardinero Central", false);
				e.agregarJugador("Gelkis", "Jiménez","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Luis", "Domínguez","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Ulfrido","García","96051253689", 12, 4, true);
				e.agregarLanzador("Alberto","Biset","78071725369", 13, 20, false);
						
				//GUANTÁNAMO
				e = Serie.getInstance().getEquipos().get(14);
						
				e.agregarEntrenador("Eduardo", "Pavó", "87092141256", 31, 42, 39);
						
				e.agregarJugador("Félix","Carbonel","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Daikel","Manso","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Gabriel", "Garbey","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Yandri", "Gainza","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Orlando", "Morales","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Luis", "Sánchez","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Eulogio", "Marcillí","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Luis", "Hecheverría","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Leonelkis", "Escalalnte","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Abel", "Montoya","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Carlos", "Figueredo","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Pedro","Agüero","96051253689", 1, 4, true);
			    e.agregarLanzador("Maikel","Preval","78071725369", 13, 20, false);
						
						
				//ISLA DE LA JUVENTUD
				e = Serie.getInstance().getEquipos().get(15);
						
				e.agregarEntrenador("José", "Rodríguez", "97010141256", 16, 20, 18);
						
				e.agregarJugador("Jordanis","Acebal","69121269253", 14, 5, "Receptor", false);
				e.agregarJugador("Luis","Rivera","81081569435", 6, 2, "Primera Base", false);
				e.agregarJugador("Dainier", "Gálvez","78122968254", 21, 19, "Segunda Base", false);
				e.agregarJugador("Jorge", "Del Río","95011343217", 8, 6, "Receptor", true);
				e.agregarJugador("Michel", "Enríquez","84041512356", 24, 10, "Tercera Base", false);
				e.agregarJugador("Mainardo", "Diéguez","89020456212", 3, 9, "Campocorto", false);
				e.agregarJugador("Aquimo", "Jiménez","88062157814", 20, 11, "Primera Base", true);
				e.agregarJugador("Leonardo", "Urgellés","89020443217", 15, 12, "Jardinero Izquierdo", false);
				e.agregarJugador("Geovany", "Díaz","88020156214", 4, 11, "Jardinero Central", false);
				e.agregarJugador("Eliseo", "Rojas","77112349519", 23, 22, "Jardinero Derecho", false);
				e.agregarJugador("Yasmani", "Viera","74082543212", 17, 22, "Receptor", false);
						
				e.agregarLanzador("Wilmer","Pérez","96051253689", 1, 4, true);
				e.agregarLanzador("Danny","Aguilera","78071725369", 13, 20, false);
				
				//ESTADIOS
				Serie.getInstance().agregarEstadio("Capitán San Luis", "Pinar del Río", 1000);
				Serie.getInstance().agregarEstadio("Critóbal Labra", "Isla de la Juventud", 1500);
				Serie.getInstance().agregarEstadio("Nelson Fernández", "Mayabeque", 2300);
				Serie.getInstance().agregarEstadio("26 de Julio", "Artemisa", 2700);
				Serie.getInstance().agregarEstadio("Latinoamericano", "La Habana", 5500);
				Serie.getInstance().agregarEstadio("Victoria de Girón", "Matanzas", 3700);
				Serie.getInstance().agregarEstadio("5 de Septiempre", "Cienfuegos", 3500);
				Serie.getInstance().agregarEstadio("Augusto César Sandino", "Villa Clara", 3000);
				Serie.getInstance().agregarEstadio("José Antonio Huelga", "Sancti Spíritus", 2900);
				Serie.getInstance().agregarEstadio("José Ramón Cepero", "Ciego de Ávila", 3200);
				Serie.getInstance().agregarEstadio("Cándido González", "Camagüey", 4100);
				Serie.getInstance().agregarEstadio("Julio Antonio Mella", "Las Tunas", 3400);
				Serie.getInstance().agregarEstadio("Calixto García", "Holguín", 5000);
				Serie.getInstance().agregarEstadio("Mártires de Barbados","Granma", 4900);
				Serie.getInstance().agregarEstadio("Gillermón Moncada", "Santiago de Cuba", 4100);
				Serie.getInstance().agregarEstadio("Nguyen Van Troi", "Guantánamo", 5300);
				
				
				
				
				
				
				
				
				//PINAR_DEL_RIO
//				Equipo e = Serie.getInstance().getEquipos().get(0);
//				
//				e.agregarJugador("Olber", "Peña", "69051268253", 10, 5, "Receptor", false);
//				e.agregarJugador("William", "Saavedra", "97083069535", 6, 2, "Primera Base", false);
//				e.agregarJugador("Dayron", "Hernández", "75120968254", 23, 19, "Campo Corto", false);
//				e.agregarJugador("Reinaldo", "Lazaga", "95010443217", 17, 6, "Jardinero Izquierdo", true);
//				e.agregarJugador("Pedro", "Dueñas", "83042512356", 8, 10, "Tercera Base", false);
//				e.agregarJugador("Luis", "García", "89120456212", 3, 9, "Campo Corto", false);
//				e.agregarJugador("Frank", "Díaz", "88022557814", 20, 11, "Jardinero Central", true);
//				e.agregarJugador("Lázaro", "Blanco", "89020443217", 15, 12, "Jardinero Izquierdo", false);
//				e.agregarJugador("Reinier", "León", "88020156214", 5, 11, "Jardinero Central", false);
//				e.agregarJugador("Luis", "Acosta", "77112349519", 24, 22, "Jardinero Derecho", false);
//				e.agregarJugador("Frank", "Álvarez", "74082543212", 19, 22, "Segunda Base", false);
//				
//				e.agregarLanzador("Liván", "Moinelo", "96092253689", 1, 4, false);
//				e.agregarLanzador("Vladimir", "Baños", "79122624599", 2, 20, true);
//				e.agregarLanzador("Yosvani", "Torres", "78061525369", 13, 20, false);
//				
//				e.agregarEntrenador("Pedro Luis", "Lazo", "59033112365", 22, 41, 40);
//				e.agregarEntrenador("Pedro Lázaro", "Luis", "84021536958", 14, 15, 9);
				
				//ARTEMISA
//				e = Serie.getInstance().getEquipos().get(1);
//				
//				e.agregarEntrenador("Daniel Enrique", "Valdespino", "59051426365", 11, 42, 39);
//				
//				e.agregarJugador("José Carlos", "Padrón","69121269253", 14, 5, "Receptor", true, 150, 135, 64, 15);
//				e.agregarJugador("Jorge Enrique", "Aloma","97081569435", 6, 2, "Primera Base", true, 75, 65, 10, 10);
//				e.agregarJugador("Lázaro","Hernández","76122968254", 22, 19, "Tercera Base", false, 1005, 980, 139, 25);
//				e.agregarJugador("José","Palacios","95011343217", 8, 6, "Receptor", false, 98, 95, 12, 3);
//				e.agregarJugador("Lían Camilo","Dueñas", "84041512356", 24, 10, "Segunda Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Osbec Enrique","Pacheco","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Yonsue","Moré","88062157814", 20, 11, "Primera Base", false, 275, 210, 39, 65);
//				e.agregarJugador("Lázaro Emilio","Dayan","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Dayron","Blanco","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Rodmy","Proenza","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Gerardo","Trujillo","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//				
//				e.agregarLanzador("José Ángel", "García","96051253689", 1, 4, true, 54, 28, 13);
//				e.agregarLanzador("Yulieski", "González","78071725369", 13, 20, false, 274, 126, 63);
				
				//INDUSTRIALES
//				e = Serie.getInstance().getEquipos().get(2);
//						
//				e.agregarEntrenador("Rey Vicente", "Anglada","69010141256", 20, 32, 19);
//						
//				e.agregarJugador("Frank Camilo", "Morejón","69111560655", 14, 5, "Segunda Base", false, 150, 135, 64, 15);
//				e.agregarJugador("Alexander", "Mayeta","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Juan Carlos","Torriente","78122968254", 11, 19, "Receptor", false, 1000, 979, 149, 25);
//				e.agregarJugador("Oscar","Valdes","91011245231", 8, 6, "Jardinero Derecho", true, 98, 95, 12, 3);
//				e.agregarJugador("Andres","Hernández","81031512351", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Wilfredo Ernesto","Aroche","88020452319", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Henry","Morales","87052853238", 22, 11, "Segunda Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Yoandry","Urgelles","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Yoasan","Guillén","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Stayler Abel","Hernández","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Yordanyz","Samón","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Frank", "Monthiet","96051253659", 1, 4, true, 54, 28, 13);
//				e.agregarLanzador("Noelvis", "Entenza","78071725339", 2, 20, false, 274, 126, 63);
				
				//MAYABEQUE
//				e = Serie.getInstance().getEquipos().get(3);
//						
//				e.agregarEntrenador("Vannoy", "Arado", "79010141256", 34, 25, 20);
//						
//				e.agregarJugador("Luis","Fernández","68121268253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Dariel","Oliva","82011565435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Yunior", "Corvo","77122968154", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Javier", "Carabeo","91021343412", 8, 6, "Campocorto", true, 98, 95, 12, 3);
//			    e.agregarJugador("William", "González","81041612151", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Michael", "Gonzalez","840219537178", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Rangel", "Ramos","86112757215", 20, 11, "Tercera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Dennis", "Laza","87080844217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Orlando", "Lavandera","8802175825", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Alexander", "Pozo","76122349915", 23, 22, "Jardinero Derecho", true, 1645, 1540, 140, 105);
//				e.agregarJugador("Dayron", "Cabrera","76082546216", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Yadian","Martínez","90051257679", 1, 4, false, 54, 28, 13);
//				e.agregarLanzador("Darian","Alonso","76071725616", 13, 20, false, 274, 126, 63);
						
				//MATANZAS
//				e = Serie.getInstance().getEquipos().get(4);
//						
//				e.agregarEntrenador("Victor", "Figueroa", "84010941136", 12, 30, 29);
//						
//				e.agregarJugador("Ariel","Martínez","89121969116", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Yasiel","Santoya","79082566932", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Yurisbel", "Gracial","90123068651", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Lázaro", "Herrera","95011249512", 8, 6, "Jardinero Derecho", false, 98, 95, 12, 3);
//				e.agregarJugador("Jefferson", "Delgado","81042512458", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Anibal", "Medina","81020854231", 20, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Yariel", "Duque","89061157514", 3, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Ariel", "Sánchez","81020744819", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Ernesto", "Blanco","86021856214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Dariel", "Polledo","77112349519", 23, 22, "Jardinero Derecho", true, 1645, 1540, 140, 105);
//				e.agregarJugador("Yoisnel", "Camejo","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Yoenni","Yera","96051253689", 1, 4, false, 54, 28, 13);
//				e.agregarLanzador("Yonder","Martínez","78071725369", 13, 20, true, 274, 45, 63);

				//CIENFUEGOS
//				e = Serie.getInstance().getEquipos().get(5);
//						
//				e.agregarEntrenador("Alain", "Álvarez", "83010141256", 20, 42, 39);
//				e.agregarEntrenador("Aláin", "Álvarez", "84021536958", 18, 15, 9);
//						
//				e.agregarJugador("Richel","Lopéz","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Daniel","Pérez","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Edwin", "Vassell","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Asiel", "Rodríguez","95011343217", 11, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("César", "Prieto","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Orlando", "Santos","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Pavel", "Quesada","88062157814", 8, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Yusniel", "Ibañez","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Juan", "Soriano","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Lazaro", "Rodríguez","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Orlando", "Roa","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Carlos","Ramírez","96051253689", 1, 4, true, 54, 28, 13);
//				e.agregarLanzador("Yasiel","Morales","78071725369", 13, 20, false, 274, 126, 63);

				//VILLA CLARA
//				e = Serie.getInstance().getEquipos().get(6);
//						
//				e.agregarEntrenador("Eduardo", "Paret", "59072341256", 35, 52, 49);
//						
//				e.agregarJugador("Yulexis","La Rosa","69121269253", 6, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Ivalio","Leiva","81081569435", 14, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Andy", "Sarduy","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Javier", "Fuste","95011343217", 8, 6, "Jardinero Central", false, 98, 95, 12, 3);
//				e.agregarJugador("Yeniet", "Pérez","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Michel", "Triana","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Juan", "López","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Andy", "Zamora","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Leandro", "Turiño","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Yurien", "Vizcaino","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Duviel", "Zamora","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Freddy","Álvarez","96051253689", 1, 4, false, 54, 28, 13);
//				e.agregarLanzador("Alain","Sánchez","78071725369", 26, 20, true, 274, 226, 63);
						
				//SANTI SPÍRITUS
//				e = Serie.getInstance().getEquipos().get(7);
//						
//				e.agregarEntrenador("José", "Delgado", "59120141256", 22, 50, 47);
//						
//				e.agregarJugador("Yunior","Barra","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Yunier","Mendoza","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Yoandi", "Baguet","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Rafael", "Acebey","95011343217", 8, 6, "Receptor", false, 98, 95, 12, 3);
//				e.agregarJugador("José", "González","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Luis", "Serrano","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Diasmany", "Palacio","88062157814", 11, 11, "Tercera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Frederich", "Cepeda","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Dunieski", "Barroso","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Miguel", "Gómez","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Daviel", "Gómez","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Ángel","Peña","96051253689", 1, 4, false, 54, 28, 13);
//				e.agregarLanzador("Yoén","Socarrás","78071725369", 13, 20, false, 274, 126, 63);
						
				//CIEGO DE ÁVILA
//				e = Serie.getInstance().getEquipos().get(8);
//						
//				e.agregarEntrenador("Roger", "Machado", "59052341256", 8, 55, 53);
//				
//				e.agregarJugador("Osvaldo","Vázquez","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Humberto","Morales","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Yaimel", "Bravo","78122968254", 13, 19, "Receptor", false, 980, 978, 149, 25);
//				e.agregarJugador("Raúl", "González","95011343217", 11, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Yorbis", "Borroto","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Rubén", "Valdés","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Alexander", "Jiménez","88062157814", 12, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Yoelvis", "Fis","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Abdel", "Civil","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Yuddiel", "González","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Michel", "Artega","74082543212", 17, 22, "Segunda Base", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Vladimir","García","96051253689", 1, 4, false, 50, 10, 13);
//				e.agregarLanzador("Dachel","Duquesme","78071725369", 20, 20, true, 274, 126, 63);
						
				//CAMAGÜEY
//				e = Serie.getInstance().getEquipos().get(9);
//						
//				e.agregarEntrenador("Orlando", "González", "59010141256", 22, 40, 39);
//						
//				e.agregarJugador("Yendry","Téllez","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Leonel","Segura","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Pedro", "Smith","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Luis", "Gómez","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Humberto", "Bravo","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Alexander", "Ayala","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Eglis", "Eugellés","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Jorge", "Cardosa","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Dariel", "Ávila","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Yanmichel", "Flores","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Liván", "Amaro","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Yariel","Rodríguez","96051253689", 1, 4, false, 54, 28, 13);
//				e.agregarLanzador("José","Rodríguez","78071725369", 13, 20, true, 274, 126, 63);
							
				//LAS TUNAS
//				e = Serie.getInstance().getEquipos().get(10);
//						
//				e.agregarEntrenador("Pablo", "Civil", "60110141256", 12, 43, 20);
//						
//				e.agregarJugador("Yosvany","Alarcón","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Dánel","Castro","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Ernesto", "Lalana","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Oberto", "Coca","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Eduardo", "García","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Yudier", "Rondón","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Magdiel", "Gómez","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Jorge", "Yhonson","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Yuniesky", "Larduet","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Andrés", "Quiala","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Yordanis", "Alarcón","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Yoalkis","Cruz","96051253689", 13, 4, true, 44, 40, 13);
//				e.agregarLanzador("Yudiel","Rodríguez","78071725369", 1, 20, false, 274, 126, 63);			
						
				//GRANMA
//				e = Serie.getInstance().getEquipos().get(11);
//						
//				e.agregarEntrenador("Carlos", "Martí", "83010141256", 22, 37, 15);
//						
//				e.agregarJugador("Huber","Sánchez","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Guillermo","Avilés","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Carlos", "Benítez","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Darién", "García","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Yulián", "Milán","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Lázaro", "Cedeño","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Wilfredo", "Sánchez","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Raico", "Santos","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Roel", "Santos","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Yoelqui", "Céspedes","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Alfredo", "Despaigne","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Lázaro","Blanco","96051253689", 11, 4, true, 30, 29, 13);
//				e.agregarLanzador("Leandro","Martínez","78071725369", 1, 20, false, 274, 126, 63);
					
				//HOLGUÍN
//				e = Serie.getInstance().getEquipos().get(12);
//						
//				e.agregarEntrenador("Noelvis", "González", "59010141256", 33, 42, 39);
//						
//				e.agregarJugador("Franklin","Aballe","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Yordan","Manduley","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Yunior", "Paumier","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Iván", "Prieto","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Michael", "Gorgüet","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Pedro", "Almeida","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Noel", "González","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Geydi", "Soler","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Jorge", "Peña","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Oscar", "Julián","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Luis", "Domínguez","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Carlos","Santiesteban","96051253689", 11, 4, false, 54, 28, 13);
//				e.agregarLanzador("Luis","Gómez","78071725369", 13, 20, false, 274, 126, 63);
						
				//SANTIAGO DE CUBA
//				e = Serie.getInstance().getEquipos().get(13);
//						
//				e.agregarEntrenador("Eriberto", "Rosales", "73102134126", 22, 39, 38);
//						
//				e.agregarJugador("Alexander","Yanez","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Edisel","Silva","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Alejandro", "Sánchez","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//			    e.agregarJugador("Alberto", "Díaz","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Michael", "Gorgüet","84041512356", 4, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Adriel", "Labrada","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Santiago", "Torres","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Sergio", "Barthelemy","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Yoelquis", "Guibert","88020156214", 24, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Gelkis", "Jiménez","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Luis", "Domínguez","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Ulfrido","García","96051253689", 12, 4, true, 40, 20, 13);
//				e.agregarLanzador("Alberto","Biset","78071725369", 13, 20, false, 274, 126, 63);
						
				//GUANTÁNAMO
//				e = Serie.getInstance().getEquipos().get(14);
//						
//				e.agregarEntrenador("Eduardo", "Pavó", "87092141256", 31, 42, 39);
//						
//				e.agregarJugador("Félix","Carbonel","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Daikel","Manso","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Gabriel", "Garbey","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Yandri", "Gainza","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Orlando", "Morales","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Luis", "Sánchez","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Eulogio", "Marcillí","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Luis", "Hecheverría","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Leonelkis", "Escalalnte","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Abel", "Montoya","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Carlos", "Figueredo","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Pedro","Agüero","96051253689", 1, 4, true, 54, 28, 13);
//			    e.agregarLanzador("Maikel","Preval","78071725369", 13, 20, false, 274, 126, 63);
						
						
				//ISLA DE LA JUVENTUD
//				e = Serie.getInstance().getEquipos().get(15);
//						
//				e.agregarEntrenador("José", "Rodríguez", "97010141256", 16, 20, 18);
//						
//				e.agregarJugador("Jordanis","Acebal","69121269253", 14, 5, "Receptor", false, 150, 135, 64, 15);
//				e.agregarJugador("Luis","Rivera","81081569435", 6, 2, "Primera Base", false, 75, 65, 10, 10);
//				e.agregarJugador("Dainier", "Gálvez","78122968254", 21, 19, "Segunda Base", false, 1003, 978, 149, 25);
//				e.agregarJugador("Jorge", "Del Río","95011343217", 8, 6, "Receptor", true, 98, 95, 12, 3);
//				e.agregarJugador("Michel", "Enríquez","84041512356", 24, 10, "Tercera Base", false, 119, 89, 11, 30);
//				e.agregarJugador("Mainardo", "Diéguez","89020456212", 3, 9, "Campocorto", false, 120, 106, 12, 14);
//				e.agregarJugador("Aquimo", "Jiménez","88062157814", 20, 11, "Primera Base", true, 275, 210, 39, 65);
//				e.agregarJugador("Leonardo", "Urgellés","89020443217", 15, 12, "Jardinero Izquierdo", false, 356, 320, 56, 36);
//				e.agregarJugador("Geovany", "Díaz","88020156214", 4, 11, "Jardinero Central", false, 253, 208, 120, 45);
//				e.agregarJugador("Eliseo", "Rojas","77112349519", 23, 22, "Jardinero Derecho", false, 1645, 1540, 140, 105);
//				e.agregarJugador("Yasmani", "Viera","74082543212", 17, 22, "Receptor", false, 1598, 1504, 235, 94);
//						
//				e.agregarLanzador("Wilmer","Pérez","96051253689", 1, 4, true, 54, 28, 13);
//				e.agregarLanzador("Danny","Aguilera","78071725369", 13, 20, false, 274, 126, 63);
	}
	
	public static void cargarHistoricos(){
		HistoricosFinales.getInstance().getSeries().add(new Serie());
		Serie h1 = HistoricosFinales.getInstance().getSeries().get(0);
		h1.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 20);
		h1.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 18);
		h1.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 16);
		h1.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 14);
		h1.agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada", 12);
		h1.agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado", 10);
		h1.agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa", 8);
		h1.agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret", 46);
		h1.agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez", 4);
		h1.agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado", 2);
		h1.agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado", 1);
		h1.agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		h1.agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil", 13);
		h1.agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González", 25);
		h1.agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí");
		h1.agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales");
		h1.agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó");
		h1.agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez");
		
		HistoricosFinales.getInstance().getSeries().add(new Serie());
		Serie h2 = HistoricosFinales.getInstance().getSeries().get(1);
		h2.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 58);
		h2.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 18);
		h2.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 16);
		h2.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 14);
		h2.agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada", 12);
		h2.agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado", 10);
		h2.agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa", 8);
		h2.agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret", 6);
		h2.agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez", 4);
		h2.agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado", 2);
		h2.agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado", 1);
		h2.agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		h2.agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil");
		h2.agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González", 31);
		h2.agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí");
		h2.agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales", 36);
		h2.agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó");
		h2.agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez");
		
		HistoricosFinales.getInstance().getSeries().add(new Serie());
		Serie h3 = HistoricosFinales.getInstance().getSeries().get(2);
		h3.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 20);
		h3.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 18);
		h3.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 16);
		h3.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 14);
		h3.agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada", 12);
		h3.agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado", 10);
		h3.agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa", 8);
		h3.agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret", 6);
		h3.agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez", 4);
		h3.agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado", 2);
		h3.agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado", 61);
		h3.agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		h3.agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil",7);
		h3.agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González");
		h3.agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí");
		h3.agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales");
		h3.agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó");
		h3.agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez", 27);
		
		HistoricosFinales.getInstance().getSeries().add(new Serie());
		Serie h4 = HistoricosFinales.getInstance().getSeries().get(3);
		h4.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 20);
		h4.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 18);
		h4.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 16);
		h4.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 14);
		h4.agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada", 12);
		h4.agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado", 10);
		h4.agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa", 8);
		h4.agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret", 6);
		h4.agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez", 4);
		h4.agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado", 2);
		h4.agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado", 1);
		h4.agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		h4.agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil", 4);
		h4.agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González");
		h4.agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí", 41);
		h4.agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales", 35);
		h4.agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó");
		h4.agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez", 14);
		
		HistoricosFinales.getInstance().getSeries().add(new Serie());
		Serie h5 = HistoricosFinales.getInstance().getSeries().get(4);
		h5.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 2);
		h5.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 18);
		h5.agregarEquipo("Pinar del Río", "Pinar del Río", 44, 4, "Hoja de Tabaco", "Verde", "Pedro Luis", "Lazo", 16);
		h5.agregarEquipo("Artemisa", "Artemisa", 8, 0, "Diosa Artemisa", "Blanco", "Dany", "Valdespino", 14);
		h5.agregarEquipo("Industriales", "La Habana", 56, 12, "León", "Azul", "Rey Vicente", "Anglada", 12);
		h5.agregarEquipo("Mayabeque", "Mayabeque", 8, 0, "Huracán", "Gris", "Vannoy", "Arado", 10);
		h5.agregarEquipo("Matanzas", "Matanzas", 52, 0, "Cocodrilo", "Rojo", "Victor", "Figueroa", 8);
		h5.agregarEquipo("Villa Clara", "Villa Clara", 42, 5, "Naranja", "Naranja", "Eduardo", "Paret", 6);
		h5.agregarEquipo("Cienfuegos", "Cienfuegos", 41, 0, "Elefante", "Gris", "Alaín", "Alvárez", 4);
		h5.agregarEquipo("Sancti Spiritus", "Sancti Spiritus", 42, 1, "Gallo", "Naranja", "José Raúl", "Delgado", 2);
		h5.agregarEquipo("Ciego de Ávila", "Ciego de Ávila", 42, 3, "Tigre", "Azul", "Roger", "Machado", 1);
		h5.agregarEquipo("Camagüey", "Camagüey", 52, 0, "Tinajón", "Blanco", "Orlando", "González");
		h5.agregarEquipo("Las Tunas", "Las Tunas", 42, 1, "Leñador", "Verde", "Pablo Alberto", "Civil", 11);
		h5.agregarEquipo("Holguín", "Holguín", 42, 1, "Perro", "Negro", "Noelvis", "González");
		h5.agregarEquipo("Granma", "Granma", 42, 2, "Caballo", "Azul", "Carlos", "Martí", 50);
		h5.agregarEquipo("Santiago de Cuba", "Santiago de Cuba", 42, 8, "Avispa", "Rojo", "Eriberto", "Rosales");
		h5.agregarEquipo("Guantánamo", "Guantánamo", 42, 0, "Indio", "Negro", "Eduardo", "Pavó",15);
		h5.agregarEquipo("Isla de la Juventud", "Isla de la Juventud", 42, 0, "Pirata", "Blanco", "José Luis", "Rodríguez");
	}
}
