package extras;

public class Seguridad {
	private static final String usuario = "controlador";
	private static final String contrasenia = "1234";
	
	public static boolean acceso(String u, String c){
		return (usuario.equals(u) && contrasenia.equals(c));
	}
}
