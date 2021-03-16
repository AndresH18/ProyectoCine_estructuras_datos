package interfaces;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import cine.Cine;
import cine.pelicula.Pelicula;
import cine.sala.Sala;
import cine.sala.TipoSala;
import exceptions.SalaNotFoundE;
import interfaces.utilities.renderers.JComboBoxPeliculaRender;
import interfaces.utilities.renderers.JComboBoxSalaRenderer;

public class EstablecerSalaGUI extends JPanel {

	private final Cine cine;
	private JFrame frame;
	
	public final int HEIGH, WIDTH;

	private final JLabel salas_title_lbl;
	private final JComboBox<Sala> salas_cmbx;
	private final JLabel peliculas_title_lbl;
	private final JComboBox<Pelicula> peliculas_cmbx;
	private final JLabel infoSala_actual_lbl;
	private final JButton actualizar_btn;
	private final ButtonGroup bGroup;
	private final JRadioButton normal_rdBtn;
	private final JRadioButton d3_rdBtn;
	private final JRadioButton dx4_rdBtn;
	private final JRadioButton superNova_rdBtn;
	private final JRadioButton cineArte_rdBtn;
	private final JRadioButton starKids_rdBtn;
	private final JRadioButton blackStar_rdBtn;
	
	private JButton regresar_btn;


	private final JComboBoxSalaRenderer salaBoxRenderer = new JComboBoxSalaRenderer();
	private final JComboBoxPeliculaRender peliculaBoxRenderer = new JComboBoxPeliculaRender();

	/**
	 * Create the panel.
	 */
	public EstablecerSalaGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 479, 300);
		setLayout(null);

		this.HEIGH = getHeight();
		this.WIDTH = getWidth();
//		

		salas_title_lbl = new JLabel("Sala");
		salas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salas_title_lbl.setBounds(30, 23, 45, 13);
		add(salas_title_lbl);

		salas_cmbx = new JComboBox<>();
		salas_cmbx.setBounds(30, 46, 45, 21);
		add(salas_cmbx);

//		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
//		salas_cmbx.setRenderer(salaBoxRenderer);

		peliculas_title_lbl = new JLabel("Pelicula");
		peliculas_title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		peliculas_title_lbl.setBounds(105, 23, 45, 13);
		add(peliculas_title_lbl);

		peliculas_cmbx = new JComboBox<>();
		peliculas_cmbx.setBounds(105, 46, 90, 21);
		add(peliculas_cmbx);

		infoSala_actual_lbl = new JLabel("INFO SALA");
		infoSala_actual_lbl.setVerticalAlignment(SwingConstants.CENTER);
		infoSala_actual_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		infoSala_actual_lbl.setBounds(271, 46, 174, 114);
		add(infoSala_actual_lbl);

		actualizar_btn = new JButton("Actualizar");
		actualizar_btn.setBounds(30, 211, 103, 21);
		add(actualizar_btn);

		normal_rdBtn = new JRadioButton("NORMAL");
		normal_rdBtn.setBounds(30, 99, 103, 21);
		add(normal_rdBtn);

		d3_rdBtn = new JRadioButton("3D");
		d3_rdBtn.setBounds(30, 122, 103, 21);
		add(d3_rdBtn);

		dx4_rdBtn = new JRadioButton("4DX");
		dx4_rdBtn.setBounds(30, 145, 103, 21);
		add(dx4_rdBtn);

		superNova_rdBtn = new JRadioButton("SUPER NOVA");
		superNova_rdBtn.setBounds(135, 99, 103, 21);
		add(superNova_rdBtn);

		cineArte_rdBtn = new JRadioButton("CINE ARTE");
		cineArte_rdBtn.setBounds(135, 122, 103, 21);
		add(cineArte_rdBtn);

		starKids_rdBtn = new JRadioButton("STAR KIDS");
		starKids_rdBtn.setBounds(135, 145, 103, 21);
		add(starKids_rdBtn);

		blackStar_rdBtn = new JRadioButton("BLACK STAR");
		blackStar_rdBtn.setBounds(30, 164, 103, 21);
		add(blackStar_rdBtn);

		bGroup = new ButtonGroup();
		bGroup.add(normal_rdBtn);
		bGroup.add(d3_rdBtn);
		bGroup.add(dx4_rdBtn);
		bGroup.add(superNova_rdBtn);
		bGroup.add(cineArte_rdBtn);
		bGroup.add(blackStar_rdBtn);
		bGroup.add(starKids_rdBtn);
		
		regresar_btn = new JButton("Regresar");
		regresar_btn.setBounds(234, 211, 90, 21);
		add(regresar_btn);

		// TODO
		// FIXME
		// DESCOMENTAR LA SIGUIENTE LINEA
		initialize();

	}

	private void initialize() {
		for (Sala sala : cine.getSalas()) {
			salas_cmbx.addItem(sala);
		}

		for (Pelicula pelicula : cine.getPeliculas()) {
			peliculas_cmbx.addItem(pelicula);
		}
		salas_cmbx.setSelectedIndex(0);
		peliculas_cmbx.setSelectedItem(((Sala) salas_cmbx.getSelectedItem()).getPelicula());
		displaySala();

		setSelectedRadioButton(((Sala) salas_cmbx.getSelectedItem()).getTipoSala());
//		salaBoxRenderer = new JComboBoxSalaRenderer();
		salaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		salas_cmbx.setRenderer(salaBoxRenderer);
		peliculaBoxRenderer.setPreferredSize(new Dimension(50, 20));
		peliculas_cmbx.setRenderer(peliculaBoxRenderer);

		startListeners();

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

	private void startListeners() {

		actualizar_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateSala();
				
			}
		});
		salas_cmbx.addItemListener(salasListener);

	}

	private ItemListener salasListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			displaySala();

		}
	};
	private ItemListener peliculasListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			final Pelicula p = (Pelicula) peliculas_cmbx.getSelectedItem();

		}
	};

	private void updateSala() {
		// CHECKING SALA
		final int index = salas_cmbx.getSelectedIndex();
		final Object item = salas_cmbx.getSelectedItem();
		final Sala itemSala = (Sala) item;
		final Sala itemByIndex = salas_cmbx.getItemAt(index);
//		Enumeration<AbstractButton> elements = bGroup.getElements();
//		AbstractButton btn;
//		while (elements.hasMoreElements() && !(btn = ((AbstractButton) elements.nextElement())).isSelected()) {
////			AbstractButton btn = (AbstractButton)elements.nextElement();
//		}

		if (itemSala == itemByIndex) {
			try {
				cine.establecerSala(itemSala, (Pelicula) peliculas_cmbx.getSelectedItem(), readButton());
				
				displaySala();
				
			} catch (SalaNotFoundE e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(frame, "ERROR AL MODIFICAR LA SALA\nINTENELO MAS TARDE", "",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private TipoSala readButton() {
		if (normal_rdBtn.isSelected()) {
			return TipoSala.NORMAL;
			
		} else if (d3_rdBtn.isSelected()) {
			return TipoSala.D3;
			
		} else if (dx4_rdBtn.isSelected()) {
			return TipoSala.DX4;
		
		} else if (superNova_rdBtn.isSelected()) {
			return TipoSala.SUPER_NOVA;
		
		} else if (cineArte_rdBtn.isSelected()) {
			return TipoSala.CINE_ARTE;
		
		} else if (starKids_rdBtn.isSelected()) {
			return TipoSala.STAR_KIDS;
		
		} else if (blackStar_rdBtn.isSelected()) {
			return TipoSala.BLACK_STAR;
		
		} else {
			return TipoSala.BLACK_STAR;
		}
	}

	private void displaySala() {
		final Sala item = (Sala) salas_cmbx.getSelectedItem();
		try {
			peliculas_cmbx.setSelectedItem(item.getPelicula());
			setSelectedRadioButton(item.getTipoSala());
		} catch (Exception exception) {

		}
		StringBuilder sb = new StringBuilder();
		if (item == cine.getSalas()[salas_cmbx.getSelectedIndex()]) {
			sb.append("<html>").append("ID: ").append(item.getId()).append("<br>").append("PELICULA: ")
					.append(item.getPelicula().getId()).append("<br>").append("TIPO: ")
					.append(item.getTipoSala().toString()).append("</html>");
			infoSala_actual_lbl.setText(sb.toString());
		}
	}
	
	public void refresh() {
		salas_cmbx.removeItemListener(salasListener);
		salas_cmbx.removeAllItems();
		for(Sala s : cine.getSalas()) {
			salas_cmbx.addItem(s);
		}
		peliculas_cmbx.removeItemListener(peliculasListener);
		peliculas_cmbx.removeAllItems();
		for(Pelicula p : cine.getPeliculas()) {
			peliculas_cmbx.addItem(p);
		}
		startListeners();
	}
	
	public void setRegresarListener(ActionListener action) {
		regresar_btn.addActionListener(action);
	}
	
}
