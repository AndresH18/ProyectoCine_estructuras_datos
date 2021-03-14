package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cine.Cine;
import cine.pelicula.Pelicula;
import cine.sala.Sala;
import cine.sala.TipoSala;
import exceptions.PeliculaE;

public class AgregarSalaGUI extends JPanel {
	
	private final JFrame frame;
	private final Cine cine;
	
	public final int HEIGHT, WIDTH;

	private String holder;

	private final JTextField numeroFilas_txFld;
	private final JTextField numeroColumnas_txFld;
	private final JTextField idPelicula_txFld;

	private final JLabel agregaSala_lbl;
	private final JLabel tipoSala_lbl;
	private final JLabel idPelicula_lbl;
	private final JLabel fila_lbl;
	private final JLabel columna_lbl;

	private JComboBox<TipoSala> comboBox_TipoSala;

	private final JButton btnAgregarSala;
	private final JButton buscarPelicula_btn;
	private JButton regresar_btn;

	/**
	 * Create the frame.
	 */
	public AgregarSalaGUI(JFrame frame, Cine cine) {

		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 450, 326);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		HEIGHT = getHeight();
		WIDTH = getWidth();

		agregaSala_lbl = new JLabel("Agregar Sala");
		agregaSala_lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		agregaSala_lbl.setBounds(164, 10, 145, 29);
		add(agregaSala_lbl);

		tipoSala_lbl = new JLabel("Tipo de Sala");
		tipoSala_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		tipoSala_lbl.setBounds(24, 55, 107, 14);
		add(tipoSala_lbl);

		idPelicula_lbl = new JLabel("ID Pelicula");
		idPelicula_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		idPelicula_lbl.setBounds(24, 100, 107, 14);
		add(idPelicula_lbl);

		fila_lbl = new JLabel("# Filas");
		fila_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		fila_lbl.setBounds(24, 145, 107, 14);
		add(fila_lbl);

		columna_lbl = new JLabel("# Columnas");
		columna_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		columna_lbl.setBounds(24, 185, 107, 14);
		add(columna_lbl);

		comboBox_TipoSala = new JComboBox<>();
//		comboBox_TipoSala.setModel(new DefaultComboBoxModel<TipoSala>(TipoSala.values()));
		comboBox_TipoSala.setBounds(216, 49, 120, 21);
		add(comboBox_TipoSala);

		numeroFilas_txFld = new JTextField();
		numeroFilas_txFld.setBounds(216, 140, 60, 19);
		add(numeroFilas_txFld);
		numeroFilas_txFld.setColumns(10);

		numeroColumnas_txFld = new JTextField();
		numeroColumnas_txFld.setColumns(10);
		numeroColumnas_txFld.setBounds(216, 180, 60, 19);
		add(numeroColumnas_txFld);

		btnAgregarSala = new JButton("Agregar");
		btnAgregarSala.setEnabled(false);
		btnAgregarSala.setBounds(216, 239, 85, 21);
		add(btnAgregarSala);

		idPelicula_txFld = new JTextField();
		idPelicula_txFld.setBounds(216, 95, 85, 19);
		add(idPelicula_txFld);
		idPelicula_txFld.setColumns(10);

		buscarPelicula_btn = new JButton("<html>Buscar<html>");

		buscarPelicula_btn.setBounds(332, 93, 77, 21);
		add(buscarPelicula_btn);
		
		regresar_btn = new JButton("Regresar");
		regresar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		regresar_btn.setBounds(10, 239, 97, 21);
		add(regresar_btn);

		initialize();

	}

	private void initialize() {
		for (TipoSala t : TipoSala.values()) {
			comboBox_TipoSala.addItem(t);
		}

		setActionListeners();
	}

	private void setActionListeners() {
		btnAgregarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((numeroFilas_txFld.getText().length() == 0 || !numeroFilas_txFld.getText().matches("[0-9]+"))
						&& (numeroColumnas_txFld.getText().length() == 0 || !numeroColumnas_txFld.getText().matches("[0-9]+"))) {
					// Todo mal
					JOptionPane.showMessageDialog(frame, "LOS CAMPOS ENTRADOS NO SON VALIDOS", "",
							JOptionPane.ERROR_MESSAGE);

				} else if (numeroFilas_txFld.getText().length() == 0 || !numeroFilas_txFld.getText().matches("[0-9]+")) {
					// filas mal
					JOptionPane.showMessageDialog(frame, "EL NUMERO DE FILAS NO ES VALIDO", "",
							JOptionPane.ERROR_MESSAGE);

				} else if (numeroColumnas_txFld.getText().length() == 0 || !numeroColumnas_txFld.getText().matches("[0-9]+")) {
					// Columnas mal
					JOptionPane.showMessageDialog(frame, "EL NUMEROS DE COLUMNAS NO ES VALIDO", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// VALIDO. Continuar

					try {
						final int filas = Integer.valueOf(numeroFilas_txFld.getText());
						final int colum = Integer.valueOf(numeroColumnas_txFld.getText());

						if (filas < 0 || colum < 0) {
							throw new NumberFormatException("ERROR\nCONTACTE A UN ADIMINSTRADOR");
						} else {
							Pelicula p;
							if ((p = cine.buscarPelicula(idPelicula_txFld.getText())) != null) {
								if (JOptionPane.showConfirmDialog(frame, "CONFIRMAR", "CONFIRMAR",
										JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
									cine.agregarSala(
											new Sala(p, (TipoSala) comboBox_TipoSala.getSelectedItem(), filas, colum));
									limpiar();
								}
							} else {
								throw new PeliculaE(
										"ERROR\nPELICULA NO ENCONTRADA\nSI CONTINUA VIENDO ESTE ERROR, CONTACTE A UN ADMINISTRADOR");
							}
						}
					} catch (NumberFormatException | PeliculaE exc) {
						JOptionPane.showMessageDialog(frame, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

					}

				}
			}

		});
		idPelicula_txFld.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
		});

		buscarPelicula_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idPelicula_txFld.getText().length() == 0) {

					JOptionPane.showMessageDialog(frame, "INGRESE UN ID VALIDO", "", JOptionPane.ERROR_MESSAGE);

				} else if (cine.buscarPelicula(idPelicula_txFld.getText()) != null) {
					holder = idPelicula_txFld.getText();
					btnAgregarSala.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(frame, "PELICULA NO ENCONTRADA", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void changed() {
		if (!idPelicula_txFld.getText().equalsIgnoreCase(holder)) {
			btnAgregarSala.setEnabled(false);
		}
	}

	private void limpiar() {
		idPelicula_txFld.setText("");
		numeroFilas_txFld.setText("");
		numeroColumnas_txFld.setText("");
	}
	
	public void setRegresarListener(ActionListener action) {
		regresar_btn.addActionListener(action);
	}
}
