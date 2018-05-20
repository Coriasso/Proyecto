package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)  {
		
	

		ArrayList<Persona> personas = new ArrayList<>();
	
		
		/*ArrayList<Persona> personas2 = new ArrayList<>();
		personas2.add(new Persona("Jorge", "Sánchez", "277-57-4687", "loquesea"));
		personas2.add(new Persona ("Antonio", "Sánchez", "56-4684", "loquesea"));
		personas2.add(new Persona("Valentina", "Sánchez", "646767", "loquesea"));

		JsonUtilidades.escribirJson(new File("archivos/nuevoJson.json"), personas);*/

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca la ruta del archivo para leer");

		String url = sc.next();


		//Deteminamos cual es la extensión del fichero
		//Declaramos valores por defecto para el caso de que se introduzca un archivo sin extensión
		int posicionPunto = 0;
		String extension = "ninguna";


		//Esta expresión cogerá cualquier cosa introducida que lleve un punto en mitad.
		//Rutas o archivos que tengan puntos extra no funcionarán o con espacios
		if(url.matches("^.*\\..*$")) {
			posicionPunto = url.indexOf(".");
			extension = url.substring(posicionPunto);
		}

		sc.close();


		//Switch que determinará con qué método se obtienen los objetos
		switch (extension) {
		
		case ".json":
			personas = JsonUtilidades.leerJson(url);
			break;

		case ".csv":
			
			personas = CSVUtilidades.leerCSV(url);
			break; 

		case ".xml":
			personas = XMLUtilidades.leerXML(url);
			break;
			
		default:
			System.out.println("Extensión de archivo incompatible");
			break;
		}




		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro", "root", "");
			//Connection c = DriverManager.getConnection("jdbc:sqlite:bbdd/persona.db");

			Statement st = c.createStatement();

			st.executeUpdate("DELETE FROM persona");
			for(int i = 0; i < personas.size(); i++) {
				//INSERT INTO persona (nombre, apellido, dni, email) VALUES ('Syd','Crauford','887-18-7486','scrauford1d@geocities.jp')
				String sql = "INSERT INTO persona (nombre, apellido, dni, email) VALUES  ('" + personas.get(i).getNombre() + "', '" + personas.get(i).getApellido() + "', '" + personas.get(i).getdni() + "', '"
				+	personas.get(i).getEmail() + "');";
				st.executeUpdate(sql);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("DONE");



	}

}
