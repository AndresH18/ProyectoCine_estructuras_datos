package interfaces;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cine.pelicula.Pelicula;
import cine.sala.Sala;
import interfaces.renderers.JComboBoxSalaRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstablecerSala extends JPanel {

	private final JLabel salas_title_lbl;
	private final JComboBox<Sala> salas_cmbx;
	private final JLabel peliculas_cmbx;
	private final JComboBox<String> peliculas_title_lbl;
	private final JLabel infoSala_lbl;
	private JComboBoxSalaRenderer salaBoxRenderer = new JComboBoxSalaRenderer();

	/**
	 * Create the panel.
	 */
	public EstablecerSala() {

//		initialize();

		setBounds(0, 0, 499, 282);
		setLayout(null);

//		

		salas_title_lbl = new JLabel("Sala");
		salas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salas_title_lbl.setBounds(31, 37, 45, 13);
		add(salas_title_lbl);

		salas_cmbx = new JComboBox<>();
		salas_cmbx.setBounds(31, 60, 45, 21);
		add(salas_cmbx);

//		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
//		salas_cmbx.setRenderer(salaBoxRenderer);

		peliculas_cmbx = new JLabel("Pelicula");
		peliculas_cmbx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		peliculas_cmbx.setBounds(31, 121, 45, 13);
		add(peliculas_cmbx);

		peliculas_title_lbl = new JComboBox<>();
		peliculas_title_lbl.setBounds(31, 143, 90, 21);
		add(peliculas_title_lbl);
		
		infoSala_lbl = new JLabel("INFO SALA");
		infoSala_lbl.setBounds(181, 50, 223, 114);
		add(infoSala_lbl);

		

//		updateSalas();
		initialize();

	}
	
	private void initialize() {
		
	}

	private void updateSalas() {
		// TODO: ACCES SALAS REGISTRY

		// MEANWHILE
		Sala s1 = new Sala(new Pelicula("id", "nombre", "nombreOrig", null, false), null, 5, 6);
		Sala s2 = new Sala(new Pelicula("id", "nombre", "nombreOrig", null, false), null, 5, 6);
		salas_cmbx.addItem(s1);
		salas_cmbx.addItem(s2);

		salaBoxRenderer = new JComboBoxSalaRenderer();
		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		salas_cmbx.setRenderer(salaBoxRenderer);

		// TipoSala.BLACK_STAR, 5, 10)

	}
	
	private void updateMovies() {
		//TODO: ACCES MOVIES REGISTRY
	}
}
