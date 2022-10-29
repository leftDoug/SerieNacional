package extras;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Validaciones {
	public static void texto(JTextField txt, KeyEvent k){
		char c = k.getKeyChar();

		if (!(Character.isLetter(c) || Character.isWhitespace(c))){
			k.consume();
		}
		else if(txt.getText().length() == 0){
			if(c == ' '){
				k.consume();
			}
		}
		else if(c == ' ' && txt.getText().charAt(txt.getText().length() - 1) == ' '){
			k.consume();
		}
	}
	
	public static void textoConNum(JTextField txt, KeyEvent k){
		char c = k.getKeyChar();

		if (!(Character.isLetter(c) || Character.isWhitespace(c) || Character.isDigit(c))){
			k.consume();
		}
		else if(txt.getText().length() == 0){
			if(c == ' '){
				k.consume();
			}
		}
		else if(c == ' ' && txt.getText().charAt(txt.getText().length() - 1) == ' '){
			k.consume();
		}
	}

	public static String ultimoEspacio(JTextField txt){
		String s = "";

		if(txt.getText().endsWith(" ")){
			s = (String) txt.getText().subSequence(0, txt.getText().length() - 1);
		}
		else{
			s = txt.getText();
		}
		return s;
	}
	
	public static void ID(JTextField txt, KeyEvent k){
		char c = k.getKeyChar();

		if (!Character.isDigit(c)){
			k.consume();
		}
		else if(txt.getText().length() == 11){
			k.consume();
		}
	}
}
