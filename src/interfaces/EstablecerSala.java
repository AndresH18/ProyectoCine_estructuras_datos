package interfaces;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cine.Cine;
import cine.pelicula.Pelicula;
import cine.sala.Sala;
import exceptions.SalaNotFoundE;
import interfaces.renderers.JComboBoxPeliculaRender;
import interfaces.renderers.JComboBoxSalaRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EstablecerSala extends JPanel implements ItemListener{

	private final Cine cine;
	
	private JFrame frame;
	
	private final JLabel salas_title_lbl;
	private final JComboBox<Sala> salas_cmbx;
	private final JLabel peliculas_title_lbl;
	private final JComboBox<Pelicula> peliculas_cmbx;
	private final JLabel infoSala_actual_lbl;
	private final JButton actualizar_btn;
	private JComboBoxSalaRenderer salaBoxRenderer = new JComboBoxSalaRenderer();
	private JComboBoxPeliculaRender peliculaBoxRenderer = new JComboBoxPeliculaRender();

	/**
	 * Create the panel.
	 */
	public EstablecerSala(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 500, 300);
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

		peliculas_title_lbl = new JLabel("Pelicula");
		peliculas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		peliculas_title_lbl.setBounds(31, 121, 45, 13);
		add(peliculas_title_lbl);

		peliculas_cmbx = new JComboBox<>();
		peliculas_cmbx.setBounds(31, 143, 90, 21);
		add(peliculas_cmbx);

		infoSala_actual_lbl = new JLabel("INFO SALA");
		infoSala_actual_lbl.setVerticalAlignment(SwingConstants.CENTER);
		infoSala_actual_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		infoSala_actual_lbl.setBounds(181, 50, 112, 114);
		add(infoSala_actual_lbl);

		actualizar_btn = new JButton("Actualizar");
		actualizar_btn.setBounds(31, 225, 85, 21);
		add(actualizar_btn);
		
		JLabel infoSala_nueva_lbl_1 = new JLabel("INFO SALA");
		infoSala_nueva_lbl_1.setVerticalAlignment(SwingConstants.CENTER);
		infoSala_nueva_lbl_1.setHorizontalAlignment(SwingConstants.LEFT);
		infoSala_nueva_lbl_1.setBounds(334, 50, 112, 114);
		add(infoSala_nueva_lbl_1);
		//TODO
		//FIXME
		//DESCOMENTAR LAS SIGUIENTES 2 LINEAS
//		initialize();
//		setActionListeners();

	}

	private void initialize() {
		for (Sala sala: cine.getSalas()) {
			salas_cmbx.addItem(sala);
		}
		for (Pelicula pelicula: cine.getPeliculas()) {
			peliculas_cmbx.addItem(pelicula);
		}
//		salaBoxRenderer = new JComboBoxSalaRenderer();
		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		salas_cmbx.setRenderer(salaBoxRenderer);
		peliculaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		peliculas_cmbx.setRenderer(peliculaBoxRenderer);
		
		itemStateChanged(null);
//		setActionListeners();

//		updateSala();
	}
	
	private void setActionListeners() {
		
		actualizar_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSala();
				
			}
		});
		salas_cmbx.addItemListener(this);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		StringBuilder sb = new StringBuilder();
		final Sala item = (Sala)salas_cmbx.getSelectedItem();
		if(item == cine.getSalas()[salas_cmbx.getSelectedIndex()]) {
			sb.append("<html>").append("ID: ").append(item.getId()).append("<br>").append("PELICULA: ").append(item.getPelicula()).append("<br>").append("TIPO: ").append(item.getTipoSala().toString()).append("</html>");
			infoSala_actual_lbl.setText(sb.toString());
		}
				
	}
	

	private void updateSala() {
		// CHECKING SALA
		final int index = salas_cmbx.getSelectedIndex();
		final Object item = salas_cmbx.getSelectedItem();
		final Sala itemSala = (Sala) item;
		final Sala itemByIndex = salas_cmbx.getItemAt(index);
		
		//CHECKING PELICULA
		// TODO: CHECK PELICULA
		
		if(itemSala == itemByIndex) {
			try {
				cine.establecerSala(itemSala, null);
			} catch (SalaNotFoundE e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(frame, "ERROR AL MODIFICAR LA SALA\nINTENELO MAS TARDE","", JOptionPane.WARNING_MESSAGE);
			}
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
}
