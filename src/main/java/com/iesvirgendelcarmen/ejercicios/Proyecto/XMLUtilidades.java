package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;



public class XMLUtilidades {

	public static ArrayList<Persona> leerXML(String url) {

		ArrayList<Persona> personas = new ArrayList<>();
		try {

			File archivo = new File ("archivos/dataset.xml");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(archivo);

			document.getDocumentElement().normalize();



			NodeList nList = document.getElementsByTagName("persona");


			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {


					Element eElement = (Element) node;
					/* 
				 System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
				 System.out.println("Apellido: " + eElement.getElementsByTagName("apellido").item(0).getTextContent());
				 System.out.println("dni: " + eElement.getElementsByTagName("dni").item(0).getTextContent());
				 System.out.println("email: " + eElement.getElementsByTagName("email").item(0).getTextContent());
					 */
					personas.add(new Persona(eElement.getElementsByTagName("nombre").item(0).getTextContent(),eElement.getElementsByTagName("apellido").item(0).getTextContent(),eElement.getElementsByTagName("dni").item(0).getTextContent(),eElement.getElementsByTagName("email").item(0).getTextContent()));
				}


			}





		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personas;


	}

}
