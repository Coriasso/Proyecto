package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultorBaseDatos {

	public static ArrayList<String> sacarListaNombres() {
		ArrayList<String> personas = new ArrayList<>();
		
		try {
		
			Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro", "root", "");
			
			String sql = "Select * from persona";
			
			Statement st = conection.prepareStatement(sql);
			
			ResultSet resultado = st.executeQuery(sql);
			
			while (resultado.next()) {
				
			//	System.out.println(resultado.getString(1));
				personas.add("Nombre: " + resultado.getString(1) + " Apellido: " + resultado.getString(2) + " DNI: " + resultado.getString(3) + " email: " + resultado.getString(4));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personas;
	}
}
