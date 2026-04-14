package es.studium;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

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
		String texto = txtArea.replaceAll("[^a-zA-Z ]", " ");
		String[] palabrasSeparadas = texto.trim().split("\\s+");
		int palabras = palabrasSeparadas.length;
		return palabras;
	}

	public int contarLetras(String txtArea) {
		String texto = txtArea.replaceAll("[^a-zA-Z ]", "");
		String[] letrasSeparadas = texto.trim().split("");
		int letras = letrasSeparadas.length;
		return letras;
	}

	public String abrir(String filename) {
		String contenidoFichero = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader entrada = new BufferedReader(fr);
			String linea;
			while ((linea = entrada.readLine()) != null) {
				contenidoFichero += linea;
			}
			entrada.close();
			fr.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("Error, no se encuentra el archivo");
		} catch (IOException ioe) {
			System.err.println("Error de lectura");
		}
		return contenidoFichero;
	}

	public void guardar(String txtArea, String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.print(txtArea);
			salida.close();
			bw.close();
			fw.close();
		} catch (IOException ioe) {
			System.err.println("Error de Archivo");
		}
	}
	
	public String leerDocumento(String rutaDocumentoActual) {
		String contenidoFichero = "";
		try {
			FileReader fr = new FileReader(rutaDocumentoActual);
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

	public Font elegirFuente(String ruta, int estilo, int tamano) {
		try {
			InputStream is = Modelo.class.getResourceAsStream(ruta);
			Font nuevaFuente = Font.createFont(Font.TRUETYPE_FONT, is);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nuevaFuente);
			return nuevaFuente.deriveFont(estilo, (float) tamano);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			return new Font("Dialog", estilo, tamano);
		} catch (FontFormatException ffe) {
			System.err.println(ffe.getMessage());
			return new Font("Dialog", estilo, tamano);
		}
	}
	
	public Image cargarIcono(String ruta) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(ruta));
        } catch (Exception e) {
        	System.err.println(e.getMessage());
            return null;
        }
    }
	public void aplicarIcono(String ruta, Frame... ventanas) {
        Image icono = cargarIcono(ruta);
        if (icono != null) {
            for (Frame ventana : ventanas) {
                ventana.setIconImage(icono);
            }
        }
    }
}
