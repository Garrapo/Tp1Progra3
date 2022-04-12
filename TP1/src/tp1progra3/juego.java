package tp1progra3;

import java.util.ArrayList;

public class juego {
	
private ArrayList <String> listado = new ArrayList <String> ();
private Integer contador_intentos=5;
	

	public juego () {
		listado.add("fede");
		listado.add("diana");
		listado.add("nelson");
	    listado.add("tigre");
		listado.add("maxima");
		listado.add("fineza");
	}
	
	public ArrayList <String> get_listado(){
		return this.listado;
	}
	public Integer getContador_intentos() {
		return contador_intentos;
	}
	public void setContador_intentos(Integer contador_intentos) {
		this.contador_intentos = contador_intentos;
	}
	public void reiniciar_intentos() {
		contador_intentos=5;
	}
	public void reducir_intentos() {
		contador_intentos--;
	}
	public String dame_palabra () {  //devuelve una palabra al azar de la lista
		int numero = (int) (Math.random() * listado.size());
		return listado.get(numero);
	}

	public boolean son_iguales (String palabra , String ingresa) { //devuelve true si las palabras son iguales
		
			return palabra.equals(ingresa.toLowerCase());	
	}
	
	public boolean contiene_letra (String palabra,String caracter) { //devuelve true si el caracter esta en el string
			char letra = caracter.toLowerCase().charAt(0);
		for (int i = 0 ; i<palabra.length();i++) {
			if (letra==palabra.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String palabra_a_mostar (String palabra,String caracter) { //devuelve una palabra con caracteres "_" y las letras encontradas

		String devolver="";
		
		
		for (int i = 0 ; i<palabra.length();i++) {
			if (palabra.charAt(i)== caracter.toLowerCase().charAt(0)) {
				devolver=devolver+caracter.toLowerCase().charAt(0)+"";
			}else {
				devolver=devolver+"_";
			}
		}
		return devolver;
	}
	
public String unir_palabras (String palabra,String sub) {
	String devolver="";
	for (int i=0 ;i<palabra.length();i++ ) {
		if (palabra.toLowerCase().charAt(i)!='_') {
			devolver=devolver+palabra.charAt(i);	
		}
		else if (sub.toLowerCase().charAt(i)!='_') {
			devolver=devolver+sub.toLowerCase().charAt(i);
		}
		else {
			devolver=devolver+"_";
		}
		
	}
	return devolver;
}
public String agregar_separacion (String palabra) {
	String devolver="";
	for(int i=0 ;i<palabra.length();i++) {
		devolver=devolver+palabra.toLowerCase().charAt(i)+"  ";
	}
	return devolver;
}



	

}
