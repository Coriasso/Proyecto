package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LeerJson {

	public static void main(String[] args) {

		File file = new File("archivos/Jsonescrito.json");
		
		
		ArrayList<Persona> personas = generarLista(file);
		
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
		
		/*
		try (Scanner sc = new Scanner(new File("archivos/Jsonescrito.json"))){
	
			String [] lineas = null;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
			 lineas = line.split("}");
			
			}
			
			//System.out.println(lineas[0].toString());
			
			Gson gson = new GsonBuilder().create();
			lineas[0] = lineas[0] + "}";
			Persona p1 = gson.fromJson(lineas[0], Persona.class);
			
			System.out.println(p1.toString());
			
		} catch (Exception e) {
		e.printStackTrace();
		}*/
	}
	
	
	
	
	
	
	
	public static ArrayList<Persona> generarLista(File file){
		
		try (Scanner sc = new Scanner(file);){
			Gson gson = new GsonBuilder().create();
			String[] lineas = null;
			ArrayList <Persona> personas = new ArrayList<>();
			
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				lineas = line.split("}");
			}
			System.out.println("El lenght the lineas es: " + lineas.length);
			for (int i = 0; i < lineas.length; i++) {
				lineas[i] = lineas[i] + "}";
			//	System.out.println(Arrays.toString(lineas));
				personas.add(gson.fromJson(lineas[i], Persona.class));
				
			}
		
			return personas;
			
			
		} catch (Exception e) {
		System.out.println("ERROR EN EL MÉTODO");
		e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	

}
