package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LeyendoMockarro {

	public static void main(String[] args) {
		
		
		File file = new File("archivos/personas.json");
		ArrayList<String> jsonMoc = new ArrayList<>();
		
		try (Scanner sc = new Scanner(file);){
			Gson gson = new GsonBuilder().create();
			//String[] lineas = null;
			ArrayList <Persona> personas = new ArrayList<>();
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				jsonMoc.add(line);
			//	lineas = line.split("}");
			}
			System.out.println("El lenght the jsonMoc es: " + jsonMoc.size() );
			
			for (int i = 0; i < jsonMoc.size(); i++) {
				String objetoJson = jsonMoc.get(i).replaceAll("},", "}");
				System.out.println(objetoJson);
				personas.add(gson.fromJson(objetoJson, Persona.class));
				
			}
			
			for (int i = 0; i < 10; i++) {
				
				System.out.println(personas.get(i));
				
				
			}
			
			/*for (int i = 0; i < lineas.length; i++) {
				lineas[i] = lineas[i] + "}";
			//	System.out.println(Arrays.toString(lineas));
				personas.add(gson.fromJson(lineas[i], Persona.class));
				
			}*/
		
			
			
		} catch (Exception e) {
		System.out.println("ERROR EN EL MÉTODO");
		e.printStackTrace();
		}
		
		
		
	}

}
