package es.studium.TallerBlocDeNotas;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controlador extends WindowAdapter  implements ActionListener {
	
	private Vista v;
	private Modelo m;
	

	public Controlador(Modelo modelo, Vista vista) {
		this.m = modelo;
		this.v = vista;
		v.ventana.addWindowListener(this);
		v.dialogo.addWindowListener(this);
		v.mnuArchN.addActionListener(this);
		v.mnuArchA.addActionListener(this);
		v.mnuArchG.addActionListener(this);
		v.mnuArchS.addActionListener(this);
		v.mnuGestP.addActionListener(this);
		v.mnuGestL.addActionListener(this);
		v.mnuGestV.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(v.mnuArchS)) {
			System.exit(0);
		}
		else if(e.getSource().equals(v.mnuArchN)){
			v.txt.setText(null);
		}
		else if(e.getSource().equals(v.mnuArchA)){
			FileDialog fd = new FileDialog(v.ventana, "Seleccionar archivo", FileDialog.LOAD);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String filename = fd.getDirectory() + fd.getFile();
			String texto = m.abrir(filename);
			v.txt.setText(texto);
		}
		else if(e.getSource().equals(v.mnuArchG)){
			String texto = v.txt.getText();
			FileDialog fd = new FileDialog(v.ventana, "Seleccionar archivo", FileDialog.SAVE);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String filename = fd.getDirectory() + fd.getFile();
			m.guardar(texto, filename);
		}
		else if(e.getSource().equals(v.mnuGestP)){
			String texto = v.txt.getText();
			int contador;
			if (texto.isEmpty()) {
				contador = 0;
			}
			else {
				contador = m.contarPalabras(texto);
			}
			v.lblDia.setText("En el texto hay " + contador + " palabras.");
			v.dialogo.setTitle("Contador de palabras");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		}
		else if(e.getSource().equals(v.mnuGestL)){
			String texto = v.txt.getText();
			int contador;
			if (texto.isEmpty()) {
				contador = 0;
			}
			else {
				contador = m.contarLetras(texto);
			}
			v.lblDia.setText("En el texto hay " + contador + " letras.");
			v.dialogo.setTitle("Contador de letras");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		}
		else if(e.getSource().equals(v.mnuGestV)){
			String texto = v.txt.getText();
			int contador = m.contarVocales(texto);
			v.lblDia.setText("En el texto hay " + contador + " vocales.");
			v.dialogo.setTitle("Contador de vocales");
			v.dialogo.pack();
			v.dialogo.setVisible(true);
		}
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getSource().equals(v.ventana)) {
			System.exit(0);
		}
		else if (e.getSource().equals(v.dialogo)) {
			v.dialogo.dispose();
		}
	}

}
