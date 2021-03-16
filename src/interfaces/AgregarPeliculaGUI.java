package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cine.Cine;
import cine.pelicula.Genero;
import cine.pelicula.Pelicula;

public class AgregarPeliculaGUI extends JPanel {

	public final int HEIGHT, WIDTH;

	private final JFrame frame;
	private final Cine cine;

//	private JPanel contentPane;
	private final JLabel titulo_lbl;
	private final JTextField nombreOriginal_txtFld;
	private final JLabel nombreOriginal_lbl;
	private final JLabel nombre_lbl;
	private final JTextField nombre_txtFld;
	private final JLabel id_lbl;
	private final JTextField id_txtFld;
	private final JLabel genero_lbl;
	private final JComboBox<Genero> genero_cmbx;
	private final JCheckBox spanish_cBox;
	private final JButton agregar_btn;
	private final JButton regresar_btn;

	/**
	 * Create the panel.
	 */
	public AgregarPeliculaGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 553, 540);
		setLayout(null);

		HEIGHT = getHeight();
		WIDTH = getWidth();

		titulo_lbl = new JLabel("Ingrese los Datos de la Pel\u00EDcula");
		titulo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_lbl.setBounds(23, 27, 497, 54);
		titulo_lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		titulo_lbl.setBackground(Color.BLACK);
		titulo_lbl.setForeground(Color.BLACK);
		add(titulo_lbl);

		nombreOriginal_lbl = new JLabel("Nombre Original");
		nombreOriginal_lbl.setBounds(23, 160, 197, 25);
		nombreOriginal_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		nombreOriginal_lbl.setBackground(Color.BLACK);
		nombreOriginal_lbl.setForeground(Color.BLACK);
		add(nombreOriginal_lbl);

		nombre_lbl = new JLabel("Nombre");
		nombre_lbl.setBounds(109, 220, 111, 25);
		nombre_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		nombre_lbl.setBackground(Color.BLACK);
		nombre_lbl.setForeground(Color.BLACK);
		add(nombre_lbl);

		id_lbl = new JLabel("C\u00F3digo ID");
		id_lbl.setForeground(Color.BLACK);
		id_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		id_lbl.setBackground(new Color(0, 0, 0, 0));
		id_lbl.setBounds(99, 100, 121, 25);
		add(id_lbl);

		genero_lbl = new JLabel("G\u00E9nero");
		genero_lbl.setBounds(119, 280, 101, 25);
		genero_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		genero_lbl.setBackground(Color.BLACK);
		genero_lbl.setForeground(Color.BLACK);
		add(genero_lbl);

		nombreOriginal_txtFld = new JTextField();
		nombreOriginal_txtFld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreOriginal_txtFld.setBounds(260, 160, 260, 25);
//		nombreOriginal_txtFld.setColumns(10);
		add(nombreOriginal_txtFld);

		nombre_txtFld = new JTextField();
		nombre_txtFld.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		nombre_txtFld.setColumns(10);
		nombre_txtFld.setBounds(260, 220, 260, 25);
		add(nombre_txtFld);

		id_txtFld = new JTextField();
		id_txtFld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txtFld.setBounds(260, 100, 260, 25);
		add(id_txtFld);

		genero_cmbx = new JComboBox<>();
		genero_cmbx.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genero_cmbx.setBounds(300, 280, 166, 25);
		add(genero_cmbx);

		spanish_cBox = new JCheckBox("Doblada");
		spanish_cBox.setFont(new Font("Tahoma", Font.BOLD, 22));
		spanish_cBox.setHorizontalAlignment(SwingConstants.CENTER);
		spanish_cBox.setBounds(315, 338, 147, 25);
		add(spanish_cBox);

		agregar_btn = new JButton("Agregar");
		agregar_btn.setFont(new Font("Tahoma", Font.BOLD, 22));
		agregar_btn.setBounds(337, 411, 183, 30);
		add(agregar_btn);

		regresar_btn = new JButton("Regresar");
		regresar_btn.setFont(new Font("Tahoma", Font.BOLD, 22));
		regresar_btn.setBounds(23, 411, 183, 30);
		add(regresar_btn);

		initialize();
	}

	private void initialize() {
		for (Genero g : Genero.values()) {
			genero_cmbx.addItem(g);
		}

		startListeners();
	}

	private void startListeners() {
		agregar_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (id_txtFld.getText().length() == 0 || nombre_txtFld.getText().length() == 0
						|| nombreOriginal_txtFld.getText().length() == 0) {
					JOptionPane.showMessageDialog(frame, "LLENAR TODOS LOS DATOS", "", JOptionPane.WARNING_MESSAGE);

				} else if (cine.buscarPelicula(id_txtFld.getText()) == null) {
					final Pelicula p = new Pelicula(id_txtFld.getText(), nombre_txtFld.getText(),
							nombreOriginal_txtFld.getText(), (Genero) genero_cmbx.getSelectedItem(),
							spanish_cBox.isSelected());
					if (JOptionPane.showConfirmDialog(frame, "CONFIRMAR", "",
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						cine.agregarPelicula(p);
						JOptionPane.showMessageDialog(frame, "SE AGREGO LA PELICULA", "",
								JOptionPane.INFORMATION_MESSAGE);
						cleanFields();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "LA PELICULA YA EXISTE", "", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}

	private void cleanFields() {
		id_txtFld.setText("");
		nombre_txtFld.setText("");
		nombreOriginal_txtFld.setText("");
		genero_cmbx.setSelectedIndex(0);
	}

	public void setRegresarListener(ActionListener regresar) {
		regresar_btn.addActionListener(regresar);
	}
	
}