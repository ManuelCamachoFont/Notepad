package es.studium;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Vista {

	Frame ventana = new Frame ("Notepad");
	
	
	MenuBar mnubar = new MenuBar();
	
	Menu mnuArch = new Menu("Archivo");	
	MenuItem mnuArchN = new MenuItem("Nuevo");
	MenuItem mnuArchA = new MenuItem("Abrir");
	MenuItem mnuArchG = new MenuItem("Guardar");
	MenuItem mnuArchS = new MenuItem("Salir");
	
	Menu mnuGest = new Menu("Gestión");
	MenuItem mnuGestP = new MenuItem("Contar palabras");
	MenuItem mnuGestL = new MenuItem("Contar letras");
	MenuItem mnuGestV = new MenuItem("Contar vocales");
	
	Menu mnuOpciones = new Menu("Opciones");
	Menu mnuTemas = new Menu("Temas");
	MenuItem mnuTemasL = new MenuItem("Claro");
	MenuItem mnuTemasD = new MenuItem("Oscuro");
	MenuItem mnuOpTam = new MenuItem("Cambiar tamaño");
	MenuItem mnuOpFue = new MenuItem("Cambiar fuente");
	
	JTextArea txt = new JTextArea();
	
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	Dialog dialogo = new Dialog(ventana, "Dialogo", true);
	Label lblDia = new Label("");

	// Dialogo Tamaño
	GridBagLayout gridbagOp = new GridBagLayout();
	GridBagConstraints gbcOp = new GridBagConstraints();
	Dialog diaOpTam = new Dialog(ventana, "Tamaño", true);
	Choice choTam = new Choice();
	Label lblChoTam = new Label("Seleccione el tamaño de fuente");
	JLabel txtEjemTam = new JLabel("Este es un texto de ejemplo");
	
	// Dialogo Fuente
	GridBagLayout gridbagOp2 = new GridBagLayout();
	GridBagConstraints gbcOp2 = new GridBagConstraints();
	Dialog diaOpFue = new Dialog(ventana, "Fuente", true);
	Choice choFue = new Choice();
	Label lblChoFue = new Label("Seleccione el estilo de fuente");
	JLabel txtEjemFue = new JLabel("Este es un texto de ejemplo");
	
	// Dialogo Confirmacion
	GridBagLayout gridbagComf= new GridBagLayout();
	GridBagConstraints gbcComf = new GridBagConstraints();
	Dialog diaComf = new Dialog(ventana, "Confirmación", true);
	Label txtComf1 = new Label("El documento se ha modificado", Label.CENTER);
	Label txtComf2 = new Label("¿Desea salir y conservar los cambios?", Label.CENTER);
	Button btnSi = new Button("Guardar");
	Button btnNo = new Button("No Guardar");

	
	public Vista() {
		
		ventana.setLayout(gridbag);
		ventana.setSize(500, 500);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		mnubar.add(mnuArch);
		mnuArch.add(mnuArchN);
		mnuArch.add(mnuArchA);
		mnuArch.add(mnuArchG);
		mnuArch.addSeparator();
		mnuArch.add(mnuArchS);
		
		mnubar.add(mnuGest);
		mnuGest.add(mnuGestP);
		mnuGest.add(mnuGestL);
		mnuGest.add(mnuGestV);
		
		mnubar.add(mnuOpciones);
		mnuOpciones.add(mnuTemas);
		mnuTemas.add(mnuTemasL);
		mnuTemas.add(mnuTemasD);
		mnuOpciones.add(mnuOpTam);
		mnuOpciones.add(mnuOpFue);
		
		ventana.setMenuBar(mnubar);
		
		gbc.insets = new Insets (15, 15, 15, 15);
		ventana.add(txt, gbc);
		ventana.setVisible(true);
		ventana.setResizable(true);
		ventana.setLocationRelativeTo(null);
		
		dialogo.setLayout(new FlowLayout());
		dialogo.setSize(150, 150);
		dialogo.add(lblDia);
		dialogo.setResizable(false);
		dialogo.setVisible(false);
		dialogo.setLocationRelativeTo(null);
		
		// Opciones Tamaño
		diaOpTam.setLayout(gridbagOp);
		diaOpTam.setSize(250, 250);
		gbcOp.insets = new Insets (10, 10, 10, 10);
	
		gbcOp.gridx = 0;
		gbcOp.gridy = 0;
		diaOpTam.add(lblChoTam, gbcOp);
		
		choTam.add("-- Seleccione Tamaño--");
		choTam.add("12");
		choTam.add("24");
		choTam.add("48");
		gbcOp.gridx = 0;
		gbcOp.gridy = 1;
		diaOpTam.add(choTam, gbcOp);
		
		gbcOp.gridx = 0;
		gbcOp.gridy = 2;
		diaOpTam.add(txtEjemTam, gbcOp);
		
		diaOpTam.setVisible(false);
		diaOpTam.setResizable(false);
		diaOpTam.setLocationRelativeTo(null);
		
		// Opciones Fuentes
		diaOpFue.setLayout(gridbagOp2);
		diaOpFue.setSize(250, 250);
		gbcOp2.insets = new Insets (10, 10, 10, 10);
		
		gbcOp2.gridx = 0;
		gbcOp2.gridy = 0;
		diaOpFue.add(lblChoFue, gbcOp2);
		
		choFue.add("-- Seleccione Fuente --");
		choFue.add("Merienda");
		choFue.add("RockSalt");
		choFue.add("NanumGothic");
		gbcOp2.gridx = 0;
		gbcOp2.gridy = 1;
		diaOpFue.add(choFue, gbcOp2);
		
		gbcOp2.gridx = 0;
		gbcOp2.gridy = 2;
		diaOpFue.add(txtEjemFue, gbcOp2);
		
		diaOpFue.setVisible(false);
		diaOpFue.setResizable(false);
		diaOpFue.setLocationRelativeTo(null);
		
		// Confirmación
		diaComf.setLayout(gridbagComf);
		diaComf.setSize(400, 250);
		gbcComf.insets = new Insets (10, 10, 10, 10);
		
		gbcComf.gridx = 0;
		gbcComf.gridy = 0;
		gbcComf.gridwidth = 2;
		diaComf.add(txtComf1, gbcComf);
		
		gbcComf.gridy = 1;
		diaComf.add(txtComf2, gbcComf);
		gbcComf.gridwidth = 1;
		
		gbcComf.anchor = GridBagConstraints.WEST;
		gbcComf.gridy = 2;
		diaComf.add(btnSi, gbcComf);
		
		gbcComf.anchor = GridBagConstraints.EAST;
		gbcComf.gridx = 1;
		diaComf.add(btnNo, gbcComf);
		
		diaComf.setVisible(false);
		diaComf.setResizable(false);
		diaComf.setLocationRelativeTo(null);
		
	}

}
