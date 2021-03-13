package interfaces;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import cine.Cine;
import cine.pelicula.Pelicula;
import cine.sala.Sala;
import cine.sala.TipoSala;
/**
 * @deprecated
 * @author andre
 *
 */
public class EstablecerSala2 extends JPanel {

	private final Cine cine;

	private JFrame frame;

	private final JLabel salas_title_lbl;
	private final JComboBox<Integer> salas_cmbx;
	private final JLabel peliculas_title_lbl;
	private final JComboBox<String> peliculas_cmbx;
	private final JLabel infoSala_actual_lbl;
	private final JLabel infoSala_nueva_lbl;
	private final JButton actualizar_btn;
	private final JRadioButton normal_rdBtn;
	private final JRadioButton d3_rdBtn;
	private final JRadioButton dx4_rdBtn;
	private final JRadioButton superNova_rdBtn;
	private final JRadioButton cineArte_rdBtn;
	private final JRadioButton starKids_rdBtn;
	private final JRadioButton blackStar_rdBtn;

	/**
	 * Create the panel.
	 */
	public EstablecerSala2(JFrame frame, Cine cine) {
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
		peliculas_title_lbl.setBounds(106, 37, 45, 13);
		add(peliculas_title_lbl);

		peliculas_cmbx = new JComboBox<>();
		peliculas_cmbx.setBounds(106, 60, 90, 21);
		add(peliculas_cmbx);

		infoSala_actual_lbl = new JLabel("INFO SALA");
		infoSala_actual_lbl.setVerticalAlignment(SwingConstants.CENTER);
		infoSala_actual_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		infoSala_actual_lbl.setBounds(334, 178, 112, 114);
		add(infoSala_actual_lbl);

		actualizar_btn = new JButton("Actualizar");
		actualizar_btn.setBounds(31, 225, 85, 21);
		add(actualizar_btn);

		infoSala_nueva_lbl = new JLabel("INFO SALA");
		infoSala_nueva_lbl.setVerticalAlignment(SwingConstants.CENTER);
		infoSala_nueva_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		infoSala_nueva_lbl.setBounds(334, 50, 112, 114);
		add(infoSala_nueva_lbl);

		normal_rdBtn = new JRadioButton("NORMAL");
		normal_rdBtn.setBounds(31, 113, 103, 21);
		add(normal_rdBtn);

		d3_rdBtn = new JRadioButton("3D");
		d3_rdBtn.setBounds(31, 136, 103, 21);
		add(d3_rdBtn);

		dx4_rdBtn = new JRadioButton("4DX");
		dx4_rdBtn.setBounds(31, 159, 103, 21);
		add(dx4_rdBtn);

		superNova_rdBtn = new JRadioButton("SUPER NOVA");
		superNova_rdBtn.setBounds(136, 113, 103, 21);
		add(superNova_rdBtn);

		cineArte_rdBtn = new JRadioButton("CINE ARTE");
		cineArte_rdBtn.setBounds(136, 136, 103, 21);
		add(cineArte_rdBtn);

		starKids_rdBtn = new JRadioButton("STAR KIDS");
		starKids_rdBtn.setBounds(136, 159, 103, 21);
		add(starKids_rdBtn);

		blackStar_rdBtn = new JRadioButton("BLACK STAR");
		blackStar_rdBtn.setBounds(31, 178, 103, 21);
		add(blackStar_rdBtn);

		final ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(normal_rdBtn);
		bGroup.add(d3_rdBtn);
		bGroup.add(dx4_rdBtn);
		bGroup.add(superNova_rdBtn);
		bGroup.add(cineArte_rdBtn);
		bGroup.add(blackStar_rdBtn);
		bGroup.add(starKids_rdBtn);

		// TODO
		// FIXME
		// DESCOMENTAR LAS SIGUIENTES 2 LINEAS
		initialize();
		setActionListeners();
	}

	private void initialize() {
		for (int i = 0; i < cine.getSalas().length; i++) {
			salas_cmbx.addItem(Integer.valueOf(cine.getSalas()[i].getId()));
		}
		for (int i = 0; i < cine.getPeliculas().length; i++) {
			peliculas_cmbx.addItem(cine.getPeliculas()[i].getId());
		}

		salas_cmbx.setSelectedIndex(0);
		System.err.println(indexOfPelicula(salas_cmbx.getSelectedIndex()));
		peliculas_cmbx.setSelectedIndex(indexOfPelicula(salas_cmbx.getSelectedIndex()));

	}
	
	private void setActionListeners() {
		
	}

	private void setSelectedRadioButton(TipoSala tipoSala) {
		switch (tipoSala) {
		case NORMAL:
			normal_rdBtn.setSelected(true);
			break;
		case D3:
			d3_rdBtn.setSelected(true);
			break;
		case DX4:
			dx4_rdBtn.setSelected(true);
			break;
		case BLACK_STAR:
			blackStar_rdBtn.setSelected(true);
			break;
		case SUPER_NOVA:
			superNova_rdBtn.setSelected(true);
			break;
		case CINE_ARTE:
			cineArte_rdBtn.setSelected(true);
			break;
		case STAR_KIDS:
			starKids_rdBtn.setSelected(true);
			break;

		default:
			break;
		}

	}
	private ItemListener salasListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			final int sala_int = salas_cmbx.getSelectedIndex();
			final int indexPelicula = indexOfPelicula(sala_int);
			
		}
	};
	/**
	 * Busca el indice de la pelicula de la sala.
	 * @param i posicion de la sala en el arreglo del Salas del Cine
	 * @return
	 */
	private int indexOfPelicula(int i) {
		final Sala s = cine.getSalas()[i];
		int n = -1;
		while (++n < cine.getPeliculas().length && cine.getPeliculas()[n] != s.getPelicula())
			;
		return n < cine.getPeliculas().length ? n : -1;
	}

	private int indexOfSala(int i) {
		
		return -1;
	}
	
	

}
