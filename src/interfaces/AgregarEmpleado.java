package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class AgregarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane txtpnNombreCompleto;
	private JTextPane txtpnApellidos;
	private JTextField textField_1;
	private JTextPane txtpnNombreDocumento;
	private JTextField textField_2;
	private JTextPane txtpnIdEmpleado;
	private JRadioButton rdbtnMasculino;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEmpleado frame = new AgregarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setBounds(screenSize.width*4/10, screenSize.height*3/10, 560, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Femenino");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(271, 348, 123, 40);
		contentPane.add(rdbtnNewRadioButton);
		
		txtpnNombreCompleto = new JTextPane();
		txtpnNombreCompleto.setText("Nombre completo");
		txtpnNombreCompleto.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreCompleto.setBounds(23, 100, 251, 40);
		txtpnNombreCompleto.setOpaque(false);
		txtpnNombreCompleto.setBorder(null);
		txtpnNombreCompleto.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreCompleto.setForeground(Color.BLACK);
		contentPane.add(txtpnNombreCompleto);
		
		JTextPane txtpnIngreseLosDatos = new JTextPane();
		txtpnIngreseLosDatos.setOpaque(false);
		txtpnIngreseLosDatos.setBorder(null);
		txtpnIngreseLosDatos.setBackground(new Color(0, 0, 0, 0));
		txtpnIngreseLosDatos.setForeground(Color.BLACK);
		txtpnIngreseLosDatos.setText("Ingrese los datos del Empleado");
		txtpnIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnIngreseLosDatos.setBounds(28, 27, 514, 54);
		contentPane.add(txtpnIngreseLosDatos);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(273, 100, 260, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtpnApellidos = new JTextPane();
		txtpnApellidos.setText("Apellidos");
		txtpnApellidos.setOpaque(false);
		txtpnApellidos.setForeground(Color.BLACK);
		txtpnApellidos.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnApellidos.setBorder(null);
		txtpnApellidos.setBackground(new Color(0, 0, 0, 0));
		txtpnApellidos.setBounds(23, 160, 251, 40);
		contentPane.add(txtpnApellidos);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(273, 160, 260, 40);
		contentPane.add(textField_1);
		
		txtpnNombreDocumento = new JTextPane();
		txtpnNombreDocumento.setText("Documento ID");
		txtpnNombreDocumento.setOpaque(false);
		txtpnNombreDocumento.setForeground(Color.BLACK);
		txtpnNombreDocumento.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreDocumento.setBorder(null);
		txtpnNombreDocumento.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreDocumento.setBounds(23, 224, 251, 40);
		contentPane.add(txtpnNombreDocumento);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(273, 224, 260, 40);
		contentPane.add(textField_2);
		
		txtpnIdEmpleado = new JTextPane();
		txtpnIdEmpleado.setText("ID Empleado");
		txtpnIdEmpleado.setOpaque(false);
		txtpnIdEmpleado.setForeground(Color.BLACK);
		txtpnIdEmpleado.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnIdEmpleado.setBorder(null);
		txtpnIdEmpleado.setBackground(new Color(0, 0, 0, 0));
		txtpnIdEmpleado.setBounds(23, 288, 251, 40);
		contentPane.add(txtpnIdEmpleado);
		
		JTextPane txtpnSexo = new JTextPane();
		txtpnSexo.setText("Sexo");
		txtpnSexo.setOpaque(false);
		txtpnSexo.setForeground(Color.BLACK);
		txtpnSexo.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnSexo.setBorder(null);
		txtpnSexo.setBackground(new Color(0, 0, 0, 0));
		txtpnSexo.setBounds(23, 348, 251, 40);
		contentPane.add(txtpnSexo);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(156, 413, 238, 40);
		contentPane.add(btnNewButton);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setBounds(410, 348, 123, 40);
		contentPane.add(rdbtnMasculino);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(273, 288, 260, 40);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(lblNewLabel);
	}
}