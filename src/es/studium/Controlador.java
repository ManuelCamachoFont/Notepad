package es.studium;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controlador extends WindowAdapter implements ActionListener, ItemListener {

	private Vista v;
	private Modelo m;

	String fuente = "Comfortaa";
	String rutaFuente = "/fuentes/" + fuente + ".ttf";
	int estilo = 0;
	int tamano = 12;
	Font fuenteActual;

	String textoActual = "";
	String rutaDocumentoActual = "";
	String contenidoDocumentoActual = "";
	String contenidoGuardado = "";
	boolean guardado = false;

	public Controlador(Modelo modelo, Vista vista) {
		this.m = modelo;
		this.v = vista;
		m.aplicarIcono("/iconos/bloc.png", v.ventana);
		fuenteActual = m.elegirFuente(rutaFuente, estilo, tamano);
		v.txt.setFont(fuenteActual);
		v.txtEjemFue.setFont(fuenteActual);
		v.txtEjemTam.setFont(fuenteActual);
		v.txt.setFont(fuenteActual);
		v.txt.validate();
		v.txt.repaint();
		v.txtEjemTam.validate();
		v.txtEjemTam.repaint();
		v.txtEjemFue.validate();
		v.txtEjemFue.repaint();
		v.ventana.addWindowListener(this);
		v.dialogo.addWindowListener(this);
		v.diaOpFue.addWindowListener(this);
		v.diaOpTam.addWindowListener(this);
		v.diaComf.addWindowListener(this);
		v.mnuArchN.addActionListener(this);
		v.mnuArchA.addActionListener(this);
		v.mnuArchG.addActionListener(this);
		v.mnuArchS.addActionListener(this);
		v.mnuGestP.addActionListener(this);
		v.mnuGestL.addActionListener(this);
		v.mnuGestV.addActionListener(this);
		v.mnuTemasD.addActionListener(this);
		v.mnuTemasL.addActionListener(this);
		v.mnuOpFue.addActionListener(this);
		v.mnuOpTam.addActionListener(this);
		v.btnSi.addActionListener(this);
		v.btnNo.addActionListener(this);
		v.choTam.addItemListener(this);
		v.choFue.addItemListener(this);

	}

	// Tengo que ordenar botones de mas a menos usados
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(v.mnuArchS)) {
			textoActual = v.txt.getText();
			if (!contenidoGuardado.isEmpty() && contenidoGuardado.equals(textoActual)) {
				guardado = true;
			} else if (!contenidoGuardado.isEmpty() && !contenidoGuardado.equals(textoActual)) {
				guardado = false;
			}
			if ((!guardado) && (rutaDocumentoActual == "")) {
				v.txtComf1.setText("El documento nuevo está sin guardar");
				v.diaComf.setVisible(true);
			} else if (!guardado) {
				contenidoDocumentoActual = m.leerDocumento(rutaDocumentoActual);
				textoActual = v.txt.getText();
				if (!contenidoDocumentoActual.equals(textoActual)) {
					v.diaComf.setVisible(true);
				} else {
					System.exit(0);
				}
			} else if (guardado) {
				System.exit(0);
			}
		} else if (e.getSource().equals(v.mnuArchN)) {
			v.txt.setText(null);
		} else if (e.getSource().equals(v.mnuArchA)) {
			FileDialog fd = new FileDialog(v.ventana, "Seleccionar archivo", FileDialog.LOAD);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String archivoSeleccionado = fd.getFile();
			if (archivoSeleccionado != null) {
				String filename = fd.getDirectory() + fd.getFile();
				rutaDocumentoActual = filename;
				String texto = m.abrir(filename);
				v.txt.setText(texto);
				textoActual = texto;
			}
		} else if (e.getSource().equals(v.mnuArchG)) {
			String texto = v.txt.getText();
			FileDialog fd = new FileDialog(v.ventana, "Seleccionar archivo", FileDialog.SAVE);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String filename = fd.getDirectory() + fd.getFile();
			rutaDocumentoActual = filename;
			m.guardar(texto, filename);
			contenidoGuardado = texto;
		} else if (e.getSource().equals(v.mnuGestP)) {
			String texto = v.txt.getText();
			int contador;
			if (texto.isEmpty()) {
				contador = 0;
			} else {
				contador = m.contarPalabras(texto);
			}
			v.lblDia.setText("En el texto hay " + contador + " palabras.");
			v.dialogo.setTitle("Contador de palabras");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		} else if (e.getSource().equals(v.mnuGestL)) {
			String texto = v.txt.getText();
			int contador;
			if (texto.isEmpty()) {
				contador = 0;
			} else {
				contador = m.contarLetras(texto);
			}
			v.lblDia.setText("En el texto hay " + contador + " letras.");
			v.dialogo.setTitle("Contador de letras");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		} else if (e.getSource().equals(v.mnuGestV)) {
			String texto = v.txt.getText();
			int contador = m.contarVocales(texto);
			v.lblDia.setText("En el texto hay " + contador + " vocales.");
			v.dialogo.setTitle("Contador de vocales");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		} else if (e.getSource().equals(v.mnuTemasD)) {
			v.ventana.setIgnoreRepaint(true);
			v.ventana.setBackground(Color.BLACK);
			v.txt.setBackground(Color.BLACK);
			v.txt.setForeground(Color.WHITE);
			v.ventana.setIgnoreRepaint(false);
			v.ventana.repaint();
		} else if (e.getSource().equals(v.mnuTemasL)) {
			v.ventana.setIgnoreRepaint(true);
			v.ventana.setBackground(Color.WHITE);
			v.txt.setBackground(Color.WHITE);
			v.txt.setForeground(Color.BLACK);
			v.ventana.setIgnoreRepaint(false);
			v.ventana.repaint();
		} else if (e.getSource().equals(v.btnSi)) {
			// guardado sin filedialog, usando la ruta de documento actual
			if (!rutaDocumentoActual.isEmpty()) {
				String texto = v.txt.getText();
				m.guardar(texto, rutaDocumentoActual);
				System.exit(0);
			} else {
				String texto = v.txt.getText();
				FileDialog fd = new FileDialog(v.ventana, "Seleccionar archivo", FileDialog.SAVE);
				fd.setFile("*.txt");
				fd.setVisible(true);
				String filename = fd.getDirectory() + fd.getFile();
				m.guardar(texto, filename);
				System.exit(0);
			}
		} else if (e.getSource().equals(v.btnNo)) {
			System.exit(0);
		}

		else if (e.getSource().equals(v.mnuOpTam)) {

			v.diaOpTam.pack();
			v.diaOpTam.setVisible(true);

		} else if (e.getSource().equals(v.mnuOpFue)) {
			v.diaOpFue.pack();
			v.diaOpFue.setVisible(true);

		}

	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getSource().equals(v.ventana)) {
			textoActual = v.txt.getText();
			if (!contenidoGuardado.isEmpty() && contenidoGuardado.equals(textoActual)) {
				guardado = true;
			} else if (!contenidoGuardado.isEmpty() && !contenidoGuardado.equals(textoActual)) {
				guardado = false;
			}
			if ((!guardado) && (rutaDocumentoActual == "")) {
				v.txtComf1.setText("El documento nuevo está sin guardar");
				v.diaComf.setVisible(true);
			} else if (!guardado) {
				contenidoDocumentoActual = m.leerDocumento(rutaDocumentoActual);
				textoActual = v.txt.getText();
				if (!contenidoDocumentoActual.equals(textoActual)) {
					v.diaComf.setVisible(true);
				} else {
					System.exit(0);
				}
			} else if (guardado) {
				System.exit(0);
			}
		} else if (e.getSource().equals(v.dialogo)) {
			v.dialogo.dispose();
		} else if (e.getSource().equals(v.diaOpTam)) {
			fuenteActual = m.elegirFuente("/fuentes/" + fuente + ".ttf", estilo, tamano);
			v.txt.setFont(fuenteActual);
			v.diaOpTam.dispose();
			v.ventana.validate();
			v.ventana.repaint();
		} else if (e.getSource().equals(v.diaOpFue)) {
			fuenteActual = m.elegirFuente("/fuentes/" + fuente + ".ttf", estilo, tamano);
			v.txt.setFont(fuenteActual);
			v.diaOpFue.dispose();
			v.ventana.validate();
			v.ventana.repaint();

		} else if (e.getSource().equals(v.diaComf)) {
			v.diaComf.dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(v.choFue) && v.choFue.getSelectedIndex() != 0) {
			fuente = v.choFue.getSelectedItem();
			rutaFuente = "/fuentes/" + fuente + ".ttf";
			fuenteActual = m.elegirFuente(rutaFuente, estilo, tamano);
			v.txtEjemFue.setFont(fuenteActual);
			v.txtEjemTam.setFont(fuenteActual);
			v.diaOpFue.validate();
			v.diaOpFue.repaint();
			v.diaOpFue.pack();

		} else if (e.getSource().equals(v.choTam) && v.choTam.getSelectedIndex() != 0) {
			tamano = Integer.parseInt(v.choTam.getSelectedItem());
			rutaFuente = "/fuentes/" + fuente + ".ttf";
			fuenteActual = m.elegirFuente(rutaFuente, estilo, tamano);
			v.txtEjemTam.setFont(fuenteActual);
			v.txtEjemFue.setFont(fuenteActual);
			v.diaOpTam.validate();
			v.diaOpTam.repaint();
			v.diaOpTam.pack();
		}
	}

}
