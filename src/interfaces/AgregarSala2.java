package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cine.Cine;
import cine.sala.Sala;
import cine.sala.TipoSala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarSala2 extends JFrame {

	private JPanel contentPane;
	private JTextField NumeroFilas;
	private JTextField NumeroColumnas;
	Sala sala;
	Cine cine;
	private JTextField IdPelicula;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarSala2 frame = new AgregarSala2();
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
	public AgregarSala2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Sala");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(164, 10, 145, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Sala");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 55, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID Pelicula");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 100, 107, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("# Filas");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 145, 107, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("# Columnas");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(10, 197, 107, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox<TipoSala> comboBox_TipoSala = new JComboBox<TipoSala>();
		comboBox_TipoSala.setModel(new DefaultComboBoxModel<TipoSala>(TipoSala.values()));
		comboBox_TipoSala.setBounds(238, 54, 120, 21);
		contentPane.add(comboBox_TipoSala);
		
		NumeroFilas = new JTextField();
		NumeroFilas.setBounds(238, 145, 60, 19);
		contentPane.add(NumeroFilas);
		NumeroFilas.setColumns(10);
		
		NumeroColumnas = new JTextField();
		NumeroColumnas.setColumns(10);
		NumeroColumnas.setBounds(238, 197, 60, 19);
		contentPane.add(NumeroColumnas);
		
		JButton btnAgregarSala = new JButton("Agregar");
		btnAgregarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int NumFilas=Integer.parseInt(NumeroFilas.getText());
				int NumColumnas=Integer.parseInt(NumeroColumnas.getText());
				String idPelicula=IdPelicula.getText();

				if(cine.buscarPelicula(idPelicula)==null) {
					textField.setText("id no registrado");
				}
				
				sala=new Sala(cine.buscarPelicula(idPelicula),(TipoSala) comboBox_TipoSala.getSelectedItem(),NumFilas,NumColumnas); //siempre te da el mismo tipo de sala
				//sala=new Sala(comboBox_TipoSala.getItemAt(0),NumFilas,NumColumnas); // Investigar bien el .getItemAt(0) que entrega un Tiposala pero no se que poner en parametro
				//textField.setText(NumFilas+" "+NumColumnas+" "+idPelicula+" "+comboBox_TipoSala.getItemAt(0).toString()); //comboBox_TipoSala.getItemAt(0) esta pasando siempre el primer tipo de asieto por su parametro "0"
			}
			
		});
		btnAgregarSala.setBounds(238, 258, 85, 21);
		contentPane.add(btnAgregarSala);
		
		IdPelicula = new JTextField();
		IdPelicula.setBounds(238, 100, 60, 19);
		contentPane.add(IdPelicula);
		IdPelicula.setColumns(10);
		
		JButton btnCambiarSala = new JButton("Modificar Sala"); ///  		Estoy cargando un nuevo panel para modificar una salo existente
		btnCambiarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarSala M=new ModificarSala();
				nuevoPanel(M);
				
			}
		});
		btnCambiarSala.setBounds(341, 258, 85, 21);
		contentPane.add(btnCambiarSala);
		
//		textField = new JTextField();										//Para pruebas
//		textField.setBounds(10, 259, 203, 19);
//		contentPane.add(textField);
//		textField.setColumns(10);



	}
	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
