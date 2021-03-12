package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cine.Cine;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarEmpleado extends JFrame {

	private JPanel contentPane;

	private Cine cine;
	private JTextField tf_id;
	private JLabel lbl_ID;
	private JButton btnBuscarEmpleado;
	private JTextPane tp_infoEmpleado;
	private JLabel lblEliminarEmpleado;
	private JButton btnEliminar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarEmpleado frame = new EliminarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cine 
	 */
	public EliminarEmpleado() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_ID = new JLabel("N\u00FAmero de \r\n\r\n\r\nidentificaci\u00F3n");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_ID.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ID.setBounds(21, 54, 146, 43);
		contentPane.add(lbl_ID);
		
		tf_id = new JTextField();
		tf_id.setBounds(170, 66, 139, 20);
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminarEmpleado.setBounds(161, 11, 129, 33);
		contentPane.add(lblEliminarEmpleado);
		
		btnBuscarEmpleado = new JButton("Buscar");
		btnBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
		
				
//				Me pone error en esta linea porque al buscar empleado, retorna nulo
//				existe empleado
//				cine.buscarEmpleado(tf_id.getText());

//				if(cine.existeEmpleado(tf_id.getText()){
//					tp_infoEmpleado.setText("Nombre: " + cine.buscarEmpleado(tf_id.getText()).getNombre() /n 
//							+ "Numero de identificacion: "	+ cine.buscarEmpleado(tf_id.getText()).getNombre() /n +
//							"Telefono: " + cine.buscarEmpleado(tf_id.getText()).getTelefono() /n + "Dirección: " 
//							+ cine.buscarEmpleado(tf_id.getText()).getDireccion()/n + "Sexo: " + cine.buscarEmpleado(tf_id.getText()).getSexo());
// 					btnEliminar.setEnabled(true);				
//				} else {
//					Excepcion de persona o empleado encontrado
//					tp_infoEmpleado.setText("El empleado no fue encontrado");
//					
//				}
					
	
					
			}
		});
		
		
		btnBuscarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarEmpleado.setBounds(319, 63, 85, 23);
		contentPane.add(btnBuscarEmpleado);
		
		tp_infoEmpleado = new JTextPane();
		tp_infoEmpleado.setBounds(41, 115, 344, 92);
		contentPane.add(tp_infoEmpleado);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
//				if(cine.existeEmpleado(tf_id.getText())){
//	Eliminar comentario cuando se cree el metodo de eliminar empleado					
//					cine.eliminarEmpleado();
//					JOptionPane.showMessageDialog(null, "El Empleado ha sido eliminado satisfactoriamente");
//					
//				} else {
//					
//					Excepcion de persona o empleado encontrado
//
//					JOptionPane.showMessageDialog(null, "El Empleado no se ha podido eliminar correctamente");
//					
//				}
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(177, 227, 89, 23);
		contentPane.add(btnEliminar);
	}
}
