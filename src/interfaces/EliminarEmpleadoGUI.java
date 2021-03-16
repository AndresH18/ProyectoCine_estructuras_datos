package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cine.Cine;
import cine.persona.Empleado;

public class EliminarEmpleadoGUI extends JPanel {

	private final Cine cine;
	private final JFrame frame;

	public final int HEIGHT, WIDTH;

	private final JTextField tf_id;
	private final JLabel lbl_ID;
	private final JButton btnBuscarEmpleado;
	private final JTextPane tp_infoEmpleado;
	private final JLabel lblEliminarEmpleado;
	private final JButton btnEliminar;
	private final JButton regresar_btn;

	private String holder;

	/**
	 * create the panel.
	 * 
	 * @param frame
	 * @param cine
	 */
	public EliminarEmpleadoGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		HEIGHT = getHeight();
		WIDTH = getWidth();

		lbl_ID = new JLabel("N\u00FAmero de \r\n\r\n\r\nidentificaci\u00F3n");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_ID.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ID.setBounds(21, 54, 146, 43);
		add(lbl_ID);

		tf_id = new JTextField();
		tf_id.setBounds(170, 66, 139, 20);
		add(tf_id);
		tf_id.setColumns(10);

		lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setVisible(false);
		lblEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminarEmpleado.setBounds(161, 11, 129, 33);
		add(lblEliminarEmpleado);

		btnBuscarEmpleado = new JButton("Buscar");
		btnBuscarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarEmpleado.setBounds(319, 63, 85, 23);
		add(btnBuscarEmpleado);

		tp_infoEmpleado = new JTextPane();
		tp_infoEmpleado.setEditable(false);
		tp_infoEmpleado.setBounds(41, 115, 344, 92);
		add(tp_infoEmpleado);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(284, 228, 89, 23);
		add(btnEliminar);

		regresar_btn = new JButton("Regresar");
		regresar_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		regresar_btn.setBounds(41, 231, 89, 23);
		add(regresar_btn);

		startListeners();
	}

	private void startListeners() {
		tf_id.getDocument().addDocumentListener(new DocumentListener() {

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
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Empleado empleado = cine.buscarEmpleado(tf_id.getText());
				if (empleado != null) {
					// Eliminar comentario cuando se cree el metodo de eliminar empleado
					cine.eliminarEmpleado(empleado);
					JOptionPane.showMessageDialog(frame, "El Empleado ha sido eliminado satisfactoriamente", "",
							JOptionPane.INFORMATION_MESSAGE);
					limpiar();

				} else {

					// Excepcion de persona o empleado encontrado

					JOptionPane.showMessageDialog(null, "El Empleado no se ha podido eliminar correctamente");

				}

			}
		});
		btnBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				holder = tf_id.getText();

//				Me pone error en esta linea porque al buscar empleado, retorna nulo
//				existe empleado
//				cine.buscarEmpleado(tf_id.getText());

//				if (cine.existeEmpleado(tf_id.getText())) {
				if (cine.buscarEmpleado(tf_id.getText()) != null) {
					tp_infoEmpleado.setText("Nombre: " + cine.buscarEmpleado(tf_id.getText()).getNombre() + "\n"
							+ "Numero de identificacion: " + cine.buscarEmpleado(tf_id.getText()).getID() + "\n"
//							+ "Telefono: " + cine.buscarEmpleado(tf_id.getText()).getTelefono() + "\n" 
//							+ "Dirección: " + cine.buscarEmpleado(tf_id.getText()).getDireccion() + "\n" 
							+ "Sexo: " + cine.buscarEmpleado(tf_id.getText()).getSexo());
					btnEliminar.setEnabled(true);
				} else {
//					Excepcion de persona o empleado encontrado
//					tp_infoEmpleado.setText("El empleado no fue encontrado");
					JOptionPane.showMessageDialog(frame, "NO SE ENCONTRO AL EMPLEADO", "ERROR",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
	}

	private void changed() {
		if (!tf_id.getText().equalsIgnoreCase(holder)) {
//			System.err.println("YYYY");
			btnEliminar.setEnabled(false);
		}
	}
	
	private void limpiar() {
		tp_infoEmpleado.setText("");
		tf_id.setText("");
		changed();
	}

	public void addRegresarListener(ActionListener regresar) {
		regresar_btn.addActionListener(regresar);
	}

}
