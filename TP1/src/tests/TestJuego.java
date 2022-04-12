package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tp1progra3.juego;

public class TestJuego {

	private juego Juego ;
	
	
	String Buscada;
	String Arriesgada;
	String ArriesgadaMayuscula;
	String ArriesgadaIncorrecta;
	String MediaPalabra;
	String Caracter;
	String SoloVocal;
	
	@Before 
	
	public void inicializar() {
		Juego = new juego();
		
		Buscada = Juego.get_listado().get(0);
		Arriesgada = "fede";
		ArriesgadaMayuscula = "FeDe";
		ArriesgadaIncorrecta = "tigre";
		MediaPalabra = "f_d_";
		Caracter = "e";
		SoloVocal = "_e_e";
		
		
		
	}

	
	@Test
	public void dame_palanbra_test() {
	//	El metodo original devuelve una palabra al azar. 
	//Me parece que demostrar que la palabra es aleatoria por el momento no tiene demasiado sentido.
		assertEquals( "fede",Juego.get_listado().get(0));
	}

	@Test
	public void son_iguales_test() {  
		//con dos palabras iguales
		
		assertTrue(Juego.son_iguales(Buscada, Arriesgada));
		
	}
	
	@Test
	public void son_iguales_mayuscula_test() 
	{  //con dos palabras iguales pero una contiene mayusculas
		
		assertTrue(Juego.son_iguales(Buscada, ArriesgadaMayuscula));
		
	}
	
	@Test
	public void no_son_iguales_test() 
	{  //con dos palabras distintas
		
		assertFalse(Juego.son_iguales(Buscada, ArriesgadaIncorrecta));
		
	}
	
	@Test
	public void contiene_letra_test() {  
		//Busca solo el primer caracter de "arriesgada" en la palabra Buscada
		
		assertTrue(Juego.contiene_letra(Buscada, Arriesgada));
	}
	
	@Test
	public void contiene_letra_mayuscula_test() {  
		//Busca solo el primer caracter de "arriesgada" (en mayuscula) en la palabra Buscada
		assertTrue(Juego.contiene_letra(Buscada, ArriesgadaMayuscula));
	}
	
	@Test
	public void no_contiene_letra_test() {  //dos palabras distintas
		//Busca solo el primer caracter de "arriesgadaIncorrecta" (t, no aparece) en la palabra Buscada
		assertFalse(Juego.contiene_letra(Buscada, ArriesgadaIncorrecta));
	}
	
	@Test
	public void palabra_a_mostrar_test() {
		
		// Se envia Caracter (letra e) para buscarla en Buscada (fede) y como resultado tiene que devolver SoloVocal(_e_e)
		
		assertEquals(Juego.palabra_a_mostar(Buscada, Caracter ), SoloVocal);
	}

	@Test
	public void unir_palabras_test() {
		// Se le agregan a las letras adivinadas anteriormente, lo adivinado en el ultimo intento
		assertEquals(Juego.unir_palabras(MediaPalabra, SoloVocal ), Buscada);
	}

	
	
	
	}

