package es.studium.TallerBlocDeNotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Modelo {

	public int contarVocales(String txtArea) {
		int vocales = 0;
		for (int i = 0; i < txtArea.length(); i++) {
			switch (txtArea.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'á':
			case 'é':
			case 'í':
			case 'ó':
			case 'ú':
			case 'Á':
			case 'É':
			case 'Í':
			case 'Ó':
			case 'Ú':
				vocales++;
			}

		}
		return vocales;
	}
	
	public int contarPalabras(String txtArea) {
		String texto = txtArea.replaceAll("[^a-zA-Z0-9 ]", "");
		String[] palabrasSeparadas = texto.split("[ |\n]");
		int palabras = palabrasSeparadas.length;
		return palabras;
	}
	
	public int contarLetras(String txtArea) {
		String texto = txtArea.replaceAll("[^a-zA-Z0-9 ]", "");
		String[] letrasSeparadas = texto.split("");
		int letras = letrasSeparadas.length;
		return letras;
	}
	
	public String abrir(String filename) {
		String contenidoFichero = null;
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader entrada = new BufferedReader(fr);
			String linea;
			while((linea = entrada.readLine())!=null) {
				contenidoFichero += linea;
			}
			entrada.close();
			fr.close();
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("Error, no se encuentra el archivo");
		}
		catch(IOException ioe){
			System.err.println("Error de lectura");
		}
		return contenidoFichero;
}
	
	
	public void guardar(String txtArea, String filename) {
		try {
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.print(txtArea);
			salida.close();
			bw.close();
			fw.close();
		}
		catch(IOException ioe){
			System.err.println("Error de Archivo");
		}
	}
}
