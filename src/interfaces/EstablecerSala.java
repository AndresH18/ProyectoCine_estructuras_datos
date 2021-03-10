package interfaces;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cine.Cine;
import cine.pelicula.Pelicula;
import cine.sala.Sala;
import interfaces.renderers.JComboBoxPeliculaRender;
import interfaces.renderers.JComboBoxSalaRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class EstablecerSala extends JPanel {

	private final Cine cine;

	private final JLabel salas_title_lbl;
	private final JComboBox<Sala> salas_cmbx;
	private final JLabel peliculas_title_lbl;
	private final JComboBox<Pelicula> peliculas_cmbx;
	private final JLabel infoSala_lbl;
	private final JButton actualizar_btn;
	private JComboBoxSalaRenderer salaBoxRenderer = new JComboBoxSalaRenderer();
	private JComboBoxPeliculaRender peliculaBoxRenderer = new JComboBoxPeliculaRender();

	/**
	 * Create the panel.
	 */
	public EstablecerSala(Cine cine) {
		this.cine = cine;

		setBounds(0, 0, 499, 282);
		setLayout(null);

//		

		salas_title_lbl = new JLabel("Sala");
		salas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salas_title_lbl.setBounds(31, 37, 45, 13);
		add(salas_title_lbl);

		salas_cmbx = new JComboBox<>(cine.getSalas());
		salas_cmbx.setBounds(31, 60, 45, 21);
		add(salas_cmbx);

//		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
//		salas_cmbx.setRenderer(salaBoxRenderer);

		peliculas_title_lbl = new JLabel("Pelicula");
		peliculas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		peliculas_title_lbl.setBounds(31, 121, 45, 13);
		add(peliculas_title_lbl);

		peliculas_cmbx = new JComboBox<>();
		peliculas_cmbx.setBounds(31, 143, 90, 21);
		add(peliculas_cmbx);

		infoSala_lbl = new JLabel("INFO SALA");
		infoSala_lbl.setBounds(181, 50, 223, 114);
		add(infoSala_lbl);

		actualizar_btn = new JButton("New button");
		actualizar_btn.setBounds(31, 225, 85, 21);
		add(actualizar_btn);

//		initialize();

	}

	private void initialize() {
//		salaBoxRenderer = new JComboBoxSalaRenderer();
		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		salas_cmbx.setRenderer(salaBoxRenderer);
		peliculaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		peliculas_cmbx.setRenderer(peliculaBoxRenderer);

		updateSalas();
	}

	private void updateSalas() {
		// CHECKING SALA
		final int index = salas_cmbx.getSelectedIndex();
		final Object item = salas_cmbx.getSelectedItem();
		final Sala itemSala = (Sala) item;
		final Sala itemByIndex = salas_cmbx.getItemAt(index);
		
		//CHECKING PELICULA
		// TODO: CHECK PELICULA
		
		if(itemSala == itemByIndex) {
			cine.establecerSala(itemSala, null);
		}
		
		
		
//
//		// MEANWHILE
//		Sala s1 = new Sala(new Pelicula("id", "nombre", "nombreOrig", null, false), null, 5, 6);
//		Sala s2 = new Sala(new Pelicula("id", "nombre", "nombreOrig", null, false), null, 5, 6);
//		salas_cmbx.addItem(s1);
//		salas_cmbx.addItem(s2);
//
//		final File dir = new File(System.getProperty("user.dir") + "\\data\\salas");
//		if (dir.isDirectory()) {
//			final var index = salas_cmbx.getSelectedIndex();
//			final var item = salas_cmbx.getSelectedItem();
//			final var itemByIndex = salas_cmbx.getItemAt(index);
//			if (item != null && index >= 0 && item == cine.getSalas()[index] && item == itemByIndex) {
//				
//				
//				for(Sala s : cine.getSalas()) {
//					String id = String.valueOf(s.getId());
//					try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(dir,id)))){
//						out.writeObject(s);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
////			if(salas_cmbx.getSelectedItem() == cine.getSalas()[salas_cmbx.getSelectedIndex()]) {
////				
////			}
//		}
//
//		// TipoSala.BLACK_STAR, 5, 10)

	}
	

	private void updateMovies() {
		// TODO: ACCES MOVIES REGISTRY
	}
}
