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

public class AgregarPelicula2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane txtpnNombreOriginal;
	private JTextPane txtpnNombreOriginal_1;
	private JTextField textField_1;
	private JTextPane txtpnNombreOriginal_2;
	private JTextField textField_2;
	private JTextPane txtpnNombreOriginal_3;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPelicula2 frame = new AgregarPelicula2();
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
	public AgregarPelicula2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setBounds(screenSize.width*4/10, screenSize.height*3/10, 560, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnNombreOriginal = new JTextPane();
		txtpnNombreOriginal.setText("Nombre original");
		txtpnNombreOriginal.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreOriginal.setBounds(23, 100, 238, 40);
		txtpnNombreOriginal.setOpaque(false);
		txtpnNombreOriginal.setBorder(null);
		txtpnNombreOriginal.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreOriginal.setForeground(Color.BLACK);
		contentPane.add(txtpnNombreOriginal);
		
		JTextPane txtpnIngreseLosDatos = new JTextPane();
		txtpnIngreseLosDatos.setOpaque(false);
		txtpnIngreseLosDatos.setBorder(null);
		txtpnIngreseLosDatos.setBackground(new Color(0, 0, 0, 0));
		txtpnIngreseLosDatos.setForeground(Color.BLACK);
		txtpnIngreseLosDatos.setText("Ingrese los datos de la pel\u00EDcula");
		txtpnIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnIngreseLosDatos.setBounds(28, 27, 514, 54);
		contentPane.add(txtpnIngreseLosDatos);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(260, 100, 260, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtpnNombreOriginal_1 = new JTextPane();
		txtpnNombreOriginal_1.setText("Nombre ");
		txtpnNombreOriginal_1.setOpaque(false);
		txtpnNombreOriginal_1.setForeground(Color.BLACK);
		txtpnNombreOriginal_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreOriginal_1.setBorder(null);
		txtpnNombreOriginal_1.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreOriginal_1.setBounds(23, 160, 238, 40);
		contentPane.add(txtpnNombreOriginal_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(260, 160, 260, 40);
		contentPane.add(textField_1);
		
		txtpnNombreOriginal_2 = new JTextPane();
		txtpnNombreOriginal_2.setText("C\u00F3digo ID");
		txtpnNombreOriginal_2.setOpaque(false);
		txtpnNombreOriginal_2.setForeground(Color.BLACK);
		txtpnNombreOriginal_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreOriginal_2.setBorder(null);
		txtpnNombreOriginal_2.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreOriginal_2.setBounds(23, 224, 238, 40);
		contentPane.add(txtpnNombreOriginal_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(260, 224, 260, 40);
		contentPane.add(textField_2);
		
		txtpnNombreOriginal_3 = new JTextPane();
		txtpnNombreOriginal_3.setText("G\u00E9nero");
		txtpnNombreOriginal_3.setOpaque(false);
		txtpnNombreOriginal_3.setForeground(Color.BLACK);
		txtpnNombreOriginal_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreOriginal_3.setBorder(null);
		txtpnNombreOriginal_3.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreOriginal_3.setBounds(23, 303, 238, 40);
		contentPane.add(txtpnNombreOriginal_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Acci\u00F3n", "Comedia", "Terror", "Familiar"}));
		comboBox.setBounds(260, 303, 260, 40);
		contentPane.add(comboBox);
		
		JTextPane txtpnNombreOriginal_2_1 = new JTextPane();
		txtpnNombreOriginal_2_1.setText("Espa\u00F1ol");
		txtpnNombreOriginal_2_1.setOpaque(false);
		txtpnNombreOriginal_2_1.setForeground(Color.BLACK);
		txtpnNombreOriginal_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtpnNombreOriginal_2_1.setBorder(null);
		txtpnNombreOriginal_2_1.setBackground(new Color(0, 0, 0, 0));
		txtpnNombreOriginal_2_1.setBounds(23, 363, 238, 40);
		contentPane.add(txtpnNombreOriginal_2_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(269, 363, 250, 40);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(156, 428, 238, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(lblNewLabel);
	}
}