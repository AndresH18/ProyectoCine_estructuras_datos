package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import cine.Cine;
import cine.sala.Sala;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSala extends JPanel {
	private JTextField textSala;
	private JTextField textPelicula;
	Cine cine;
	Sala sala;

	/**
	 * Create the panel.
	 */
	public ModificarSala() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Sala");
		lblTitulo.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblTitulo.setBounds(167, 10, 146, 22);
		add(lblTitulo);
		
		JLabel lblSala = new JLabel("ID Sala");
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSala.setBounds(10, 54, 97, 13);
		add(lblSala);
		
		textSala = new JTextField();
		textSala.setBounds(167, 53, 96, 19);
		add(textSala);
		textSala.setColumns(10);
		
		JLabel lblPelicula = new JLabel("ID Pelicula");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPelicula.setBounds(10, 121, 97, 13);
		add(lblPelicula);
		
		textPelicula = new JTextField();
		textPelicula.setBounds(167, 120, 96, 19);
		add(textPelicula);
		textPelicula.setColumns(10);
		
		JButton btnCambio = new JButton("Modificar");
		btnCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cine.buscarSala(Integer.parseInt(textSala.getText()))!=null) {
					cine.buscarSala(Integer.parseInt(textSala.getText())).setPelicula(cine.buscarPelicula(textPelicula.getText()));
				}
				
			}
		});
		btnCambio.setBounds(167, 250, 85, 21);
		add(btnCambio);

	}
}
