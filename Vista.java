package es.studium.TallerBlocDeNotas;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class Vista {

	Frame ventana = new Frame ("Gestión de archivos");
	
	
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
	
	TextArea txt = new TextArea();
	
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	Dialog dialogo = new Dialog(ventana, "Dialogo", true);
	Label lblDia = new Label("");
	
	public Vista() {
		
		ventana.setLayout(gridbag);
		ventana.setSize(400, 700);
		
		
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
		
		ventana.setMenuBar(mnubar);
		
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
	}

}
