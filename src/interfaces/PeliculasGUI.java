package interfaces;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cine.Cine;
import cine.persona.Cliente;
import cine.sala.Sala;
import cine.sala.asiento.Asiento;
import cine.sala.asiento.EstadoAsiento;
import exceptions.AsientoE;
import exceptions.InvalidArgumentE;
import exceptions.SalaNotFoundE;
import interfaces.models.AsientoTableModel;
import interfaces.utilities.JTableUtilities;
import interfaces.utilities.renderers.JComboBoxPeliculaSalaRenderer;

import javax.swing.JButton;

public class PeliculasGUI extends JPanel implements ActionListener {

	public final int HEIGHT, WIDTH;

	private final JFrame frame;
	private final Cine cine;

	private static final Font HEADER_FONT = new Font("Tahoma", Font.BOLD, 22);
	private static final Font TEXT_FONT = new Font("Tahoma", Font.PLAIN, 18);
	private static final Font BOX_TEXT_FONT = new Font("Tahoma", Font.BOLD, 20);

	private final JComboBoxPeliculaSalaRenderer peliculaRenderer = new JComboBoxPeliculaSalaRenderer();

	private final JLabel id_lbl;
	private final JTextField id_txtF;

	private final JLabel sala_lbl;
	private final JComboBox<Sala> peliculaSala_cmbx;

	private final JRadioButton liberar_rdB;
	private final JRadioButton reservar_rdB;
	private final JRadioButton comprar_rdB;

	private final JLabel infoPelicula_txtP;

	private final JButton action_btn;
	private final JButton regresar_btn;

	private AsientoTableModel asientoModel = new AsientoTableModel();

	private JTable table;

	/**
	 * Create the panel.
	 */
	public PeliculasGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 800, 600);
		setLayout(null);

		HEIGHT = getHeight();
		WIDTH = getWidth();

		id_lbl = new JLabel("ID");
		id_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		id_lbl.setBounds(60, 70, 71, 25);
		id_lbl.setFont(HEADER_FONT);
		add(id_lbl);

		id_txtF = new JTextField();
		id_txtF.setBounds(160, 70, 132, 25);
		id_txtF.setFont(TEXT_FONT);
		add(id_txtF);
		id_txtF.setColumns(10);

		sala_lbl = new JLabel("Sala");
		sala_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		sala_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		sala_lbl.setBounds(60, 120, 71, 25);
		add(sala_lbl);

		peliculaSala_cmbx = new JComboBox<>();
		peliculaSala_cmbx.setBounds(160, 120, 132, 25);
		add(peliculaSala_cmbx);

		final ButtonGroup bG = new ButtonGroup();

		liberar_rdB = new JRadioButton("Liberar");
		liberar_rdB.setBounds(60, 182, 132, 25);
		liberar_rdB.setFont(BOX_TEXT_FONT);
		add(liberar_rdB);
		bG.add(liberar_rdB);

		reservar_rdB = new JRadioButton("Reservar");
		reservar_rdB.setBounds(60, 227, 132, 25);
		reservar_rdB.setFont(BOX_TEXT_FONT);
		add(reservar_rdB);
		bG.add(reservar_rdB);

		comprar_rdB = new JRadioButton("Comprar");
		comprar_rdB.setBounds(60, 272, 132, 25);
		comprar_rdB.setFont(BOX_TEXT_FONT);
		comprar_rdB.setSelected(true);
		add(comprar_rdB);
		bG.add(comprar_rdB);

		infoPelicula_txtP = new JLabel();
		infoPelicula_txtP.setBounds(60, 320, 232, 167);
//		infoPelicula_txtP.setOpaque(false);
		add(infoPelicula_txtP);

		action_btn = new JButton("Comprar");
		action_btn.setBounds(204, 495, 140, 25);
		action_btn.setFont(BOX_TEXT_FONT);
		add(action_btn);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(354, 0, 1, getHeight());
		add(separator);

		table = new JTable();
		table.setLayout(new FlowLayout());
		table.setBounds(399, 70, 353, 353);
		table.setRowSelectionAllowed(false);
		add(table);

		regresar_btn = new JButton("Regresar");
		regresar_btn.setFont(new Font("Tahoma", Font.BOLD, 20));
		regresar_btn.setBounds(30, 497, 140, 25);
		add(regresar_btn);

		initialize();
	}

//	XXX asientoModel.fireTableDataChanged();
	private void initialize() {
		// FIXME Descomentar

		peliculaSala_cmbx.setRenderer(peliculaRenderer);
		for (Sala s : cine.getSalas()) {
			peliculaSala_cmbx.addItem(s);
		}
		asientoModel.setAsientos(peliculaSala_cmbx.getItemAt(0).getAsientos());
		table.setModel(asientoModel);
		JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);

		startListeners();
		peliculaSala_cmbx.setSelectedIndex(0);
	}

	private void startListeners() {
		action_btn.addActionListener(this);
		liberar_rdB.addActionListener(radioButtonListener);
		reservar_rdB.addActionListener(radioButtonListener);
		comprar_rdB.addActionListener(radioButtonListener);
		peliculaSala_cmbx.addActionListener(comboBoxListener);

	}

	private ActionListener radioButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (liberar_rdB.isSelected()) {
				action_btn.setText("Liberar");
			} else if (reservar_rdB.isSelected()) {
				action_btn.setText("Reservar");
			} else if (comprar_rdB.isSelected()) {
				action_btn.setText("Comprar");
			} else {
				// DEFAULT IF ERROR
				action_btn.setText("Comprar");

			}
		}
	};
	private ActionListener comboBoxListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			final Sala item = (Sala) peliculaSala_cmbx.getSelectedItem();

			asientoModel.setAsientos(item.getAsientos());
//			table.setModel(new AsientoTableModel(item.getAsientos()));
			asientoModel.fireTableDataChanged();

			StringBuilder sb = new StringBuilder();
			sb.append("<html>").append("SALA #: ").append(item.getId()).append("<br>").append("TIPO SALA: ")
					.append(item.getTipoSala().toString()).append("<br>").append("PELICULA: ").append("<br>")
					.append(item.getPelicula().toString()).append("</html>");
			infoPelicula_txtP.setText(sb.toString());
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		if (id_txtF.getText().length() != 0) {
			final int col = table.getSelectedColumn();
			final int row = table.getSelectedRow();
			System.out.println("ROW " + row);
			System.out.println("COLUMN " + col);

			if (!(col == -1 || row == -1)) {
				try {
					final Sala sala = (Sala) peliculaSala_cmbx.getSelectedItem();
					final Asiento asiento = sala.getAsiento(row, col);
					if (comprar_rdB.isSelected()) {
						comprar(sala, asiento, row, col);

					} else if (reservar_rdB.isSelected()) {
						reservar(sala, asiento, row, col);

					} else if (liberar_rdB.isSelected()) {
						liberar(sala, asiento, row, col);

					} else {
						// UNEXPECTED ERROR
					}
				} catch (InvalidArgumentE exc) {
					exc.printStackTrace();
				}
			} else {
				// SELECCIONE UNA POSICION
				JOptionPane.showMessageDialog(frame, "SELECCIONE UN ASIENTO VALIDO", "" , JOptionPane.WARNING_MESSAGE);

			}
		} else {
			// NO ID
			JOptionPane.showMessageDialog(frame, "INGRESAR UN ID VALIDO", "" , JOptionPane.WARNING_MESSAGE);

		}
	}

	private void comprar(final Sala sala, final Asiento asiento, final int row, final int col) {
		if (asiento != null) {
			if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
				// comprar
				if (JOptionPane.showConfirmDialog(frame, "DESEA COMPRAR EL ASIENTO?", "",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					final Cliente cliente = new Cliente(id_txtF.getText());
					try {
						cine.comparBoleta(cliente, sala, row, col);
						refresh();
					} catch (AsientoE | SalaNotFoundE e) {
						e.printStackTrace();
					}
				}

			} else if (asiento.getEstadoAsiento() == EstadoAsiento.RESERVADO
					&& asiento.getCliente().getID().equalsIgnoreCase(id_txtF.getText())) {
				// comprar
				if (JOptionPane.showConfirmDialog(frame, "DESEA COMPRAR EL ASIENTO?", "",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					try {
						cine.comparBoleta(asiento.getCliente(), sala, row, col);
						refresh();
					} catch (AsientoE | SalaNotFoundE e) {
						e.printStackTrace();
					}
				}
			} else {
				// NO SE PUEDE COMPRAR
				// OCUPADO || ID !=
				JOptionPane.showMessageDialog(frame, "NO SE PUEDE COMPRAR EL ASIENTO");
			}
		}
	}

	private void reservar(final Sala sala, final Asiento asiento, final int row, final int col) {
		if (asiento != null) {
			if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE && asiento.getCliente() == null) {

				if (JOptionPane.showConfirmDialog(frame, "DESEA RESERVAR EL ASIENTO?", "",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					try {
						cine.reservar(new Cliente(id_txtF.getText()), sala, row, col);
						refresh();
					} catch (AsientoE | SalaNotFoundE e) {
						e.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(frame, "EL ASIENTO NO SE PUEDE RESERVAR", "" , JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void liberar(final Sala sala, final Asiento asiento, final int row, final int col) {
		if (asiento != null) {
			if (asiento.getEstadoAsiento() != EstadoAsiento.DISPONIBLE
					&& asiento.getCliente().getID().equalsIgnoreCase(id_txtF.getText())) {

				if (JOptionPane.showConfirmDialog(frame, "DESEA LIBERAR EL ASIENTO?", "",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					try {
						sala.liberarAsiento(row, col);
						refresh();
					} catch (InvalidArgumentE e) {
						e.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(frame, "EL ASIENTO NO ESTA VINCULADO NO ESTE CLIENTE", "" , JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void refresh() {
		final int index = peliculaSala_cmbx.getSelectedIndex();
		peliculaSala_cmbx.removeActionListener(comboBoxListener);
		peliculaSala_cmbx.removeAll();
		for(Sala s: cine.getSalas()) {
			peliculaSala_cmbx.addItem(s);
		}
		peliculaSala_cmbx.addActionListener(comboBoxListener);
		peliculaSala_cmbx.setSelectedIndex(index);
		
		id_txtF.setText("");

	}

	public void setRegresarListener(ActionListener regresar) {
		regresar_btn.addActionListener(regresar);
	}

}