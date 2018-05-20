package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.util.Arrays;

public class datosUsuario {

	private String usuario1;
	private char[] pass;
	
	public datosUsuario() {
		
		
	}
	
	public int probarPass() {
		usuario1= Vista.userText.getText();
		pass=Vista.passwordText.getPassword();
		
		System.out.println(usuario1);
		if(usuario1 == null || pass == null)
			return 0;
		
		if(usuario1.equals("Jorge") && Arrays.equals(pass, "1234".toCharArray()))
			return 1;
		else
			return 0; 
		
		
		
		
		
	}
	
}
