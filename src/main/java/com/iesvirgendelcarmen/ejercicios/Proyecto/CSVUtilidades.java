package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVUtilidades {
	


	public static ArrayList<Persona> leerCSV(String url) {
		
		ArrayList<Persona> personas = new ArrayList<>();
		ArrayList<String[]> datos = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(url);
			CSVParser parser =  CSVParser.parse(file, CSVFormat.RFC4180);
			for (CSVRecord csvRecord : parser) {
				
				datos.add(devolverCampos(csvRecord.toString()));
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		for (int i = 0; i < datos.size(); i++) {
					
			String nombre =  datos.get(i)[0].trim();
			
			if (nombre.equals("nombre"))
				continue;
			
			String apellido = datos.get(i)[1].trim();
			String dni = datos.get(i)[2].trim();
			String email = datos.get(i)[3].trim();
			
			personas.add(new Persona(nombre, apellido, dni, email));			
			
		}
		
		
		return personas;
		
		
	}
	
	private static String[] devolverCampos(String csv){
		
		int comienzo = csv.indexOf("=[");
		int cierre = csv.indexOf("]]");
		csv = csv.substring(comienzo + 2, cierre);
		String[] datos = csv.trim().split(",");
		
		return datos;
	}

}
