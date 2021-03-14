package interfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cine.Cine;
import cine.persona.Empleado;
import cine.persona.Sexo;

public class AgregarEmpleadoGUI extends JPanel {

	public final int HEIGHT, WIDTH;

	private final JFrame frame;
	private final Cine cine;

	private final JLabel tittle_lbl;
	private final JLabel nombre_lbl;
	private final JTextField nombre_txtF;
	private final JLabel apellido_lbl;
	private final JTextField apellido_txtF;
	private final JLabel id_lbl;
	private final JTextField id_txtF;
	private final JRadioButton fem_rBtn;
	private final JRadioButton m_rBtn;
	private final JButton agregar_btn;
	private final JButton regresar_btn;

	/**
	 * Create the frame.
	 */
	public AgregarEmpleadoGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

		setBounds(0, 0, 560, 520);
		setLayout(null);

		HEIGHT = getHeight();
		WIDTH = getWidth();

		tittle_lbl = new JLabel("Ingrese los datos del Empleado");
		tittle_lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		tittle_lbl.setBounds(28, 27, 514, 54);
		add(tittle_lbl);

		nombre_lbl = new JLabel("Nombre");
		nombre_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nombre_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		nombre_lbl.setBounds(38, 100, 135, 25);
		add(nombre_lbl);

		nombre_txtF = new JTextField();
		nombre_txtF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombre_txtF.setBounds(237, 100, 260, 25);
		add(nombre_txtF);

		apellido_lbl = new JLabel("Apellido");
		apellido_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		apellido_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		apellido_lbl.setBounds(38, 160, 135, 25);
		add(apellido_lbl);

		apellido_txtF = new JTextField();
		apellido_txtF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		apellido_txtF.setBounds(237, 160, 260, 25);
		add(apellido_txtF);

		id_lbl = new JLabel("ID");
		id_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		id_lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		id_lbl.setBounds(38, 224, 135, 25);
		add(id_lbl);

		id_txtF = new JTextField();
		id_txtF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id_txtF.setBounds(237, 224, 260, 25);
		add(id_txtF);

		agregar_btn = new JButton("Agregar");
		agregar_btn.setFont(new Font("Tahoma", Font.BOLD, 22));
		agregar_btn.setBounds(327, 411, 170, 30);
		add(agregar_btn);

		regresar_btn = new JButton("Regresar");
		regresar_btn.setFont(new Font("Tahoma", Font.BOLD, 22));
		regresar_btn.setBounds(40, 411, 170, 30);
		add(regresar_btn);

		m_rBtn = new JRadioButton("Masculino");
		m_rBtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		m_rBtn.setBounds(374, 298, 123, 25);
		add(m_rBtn);

		fem_rBtn = new JRadioButton("Femenino");
		fem_rBtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fem_rBtn.setBounds(217, 298, 123, 25);
		add(fem_rBtn);

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(m_rBtn);
		bGroup.add(fem_rBtn);

		addListeners();
	}

	private void addListeners() {
		agregar_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (nombre_txtF.getText().isBlank() || apellido_txtF.getText().isBlank() || id_txtF.getText().isBlank()
						|| !(m_rBtn.isSelected() || fem_rBtn.isSelected())) {
					JOptionPane.showMessageDialog(frame, "POR FAVOR SELECCIONE LLENE TODOS LOS CAMPOS", "",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Empleado empleado;
					if ((empleado = cine.buscarEmpleado(id_txtF.getText())) == null) {
						if (JOptionPane.showConfirmDialog(frame, "CONFIRMAR", "CONFIRMAR",
								JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
							empleado = new Empleado(id_txtF.getText(),
									nombre_txtF.getText().concat(" ").concat(apellido_txtF.getText()), getSexo());
							cine.agregarEmpleado(empleado);
							limpiar();
						}
					} else {
						JOptionPane.showMessageDialog(frame, "EL EMPLEADO YA EXISTE", "", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
	}

	private Sexo getSexo() {
		if (fem_rBtn.isSelected()) {
			return Sexo.FEMENINO;
		} else if (m_rBtn.isSelected()) {
			return Sexo.MASCULINO;
		} else {
			return Sexo.INDEFINIDO;
		}
	}

	private void limpiar() {
		nombre_txtF.setText("");
		apellido_txtF.setText("");
		id_txtF.setText("");
	}

	public void addRegresarListener(ActionListener regresar) {
		regresar_btn.addActionListener(regresar);
	}
	
}