package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cine.Cine;

public class MenuGUI extends JPanel {

	private final JFrame frame;
	private final Cine cine;

	public final int HEIGHT, WIDTH;

	private final JButton btnPeliculas;
	private final JButton btnAgregarPelicula;
	private final JButton btnEstablecerSala;
	private final JButton btnAgregarSala;
	private final JButton btnAgregarEmpleado;
	private final JButton btnEliminarEmpleado;

	/**
	 * Create the panel.
	 */
	public MenuGUI(JFrame frame, Cine cine) {
		this.frame = frame;
		this.cine = cine;

//		Toolkit t = Toolkit.getDefaultToolkit();
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(screenSize.width * 15 / 100, screenSize.height * 15 / 100, 869,
//				359);
		setBounds(0, 0, (int) screenSize.getWidth() * 6 / 10, screenSize.height * 5 / 10);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		setLayout(null);
		setBackground(new Color(100, 100, 100));
		setOpaque(true);

		HEIGHT = getHeight();
		WIDTH = getWidth();

		/*
		 * COLUMNA
		 */
		btnPeliculas = new JButton("Pel\u00EDculas");
		btnPeliculas.setHorizontalAlignment(SwingConstants.LEFT);
		btnPeliculas.setForeground(Color.WHITE);
		btnPeliculas.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnPeliculas.setBounds(getWidth() * 4 / 100, getHeight() * 5 / 100, 322, 50);
		btnPeliculas.setOpaque(false);
		btnPeliculas.setBorder(null);
		btnPeliculas.setBackground(new Color(0, 0, 0, 0));
//		contentPane.add(btnNewButton);
		add(btnPeliculas);

		btnAgregarPelicula = new JButton("Agregar Pel\u00EDculas");
		btnAgregarPelicula.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarPelicula.setForeground(Color.WHITE);
		btnAgregarPelicula.setOpaque(false);
		btnAgregarPelicula.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnAgregarPelicula.setBorder(null);
		btnAgregarPelicula.setBackground(new Color(0, 0, 0, 0));
		btnAgregarPelicula.setBounds(43, 86, 430, 50);
//		contentPane.add(btnAgregarPelculas);
		add(btnAgregarPelicula);

		btnEstablecerSala = new JButton("Establecer Sala");
		btnEstablecerSala.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstablecerSala.setForeground(Color.WHITE);
		btnEstablecerSala.setOpaque(false);
		btnEstablecerSala.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnEstablecerSala.setBorder(null);
		btnEstablecerSala.setBackground(new Color(0, 0, 0, 0));
		btnEstablecerSala.setBounds(43, 151, 322, 50);
//		contentPane.add(btnEstablecerSala);
		add(btnEstablecerSala);

		/*
		 * COLUMNA
		 */
		btnAgregarSala = new JButton("Agregar Sala");
		btnAgregarSala.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarSala.setForeground(Color.WHITE);
		btnAgregarSala.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnAgregarSala.setOpaque(false);
		btnAgregarSala.setBorder(null);
		btnAgregarSala.setBackground(new Color(0, 0, 0, 0));
		btnAgregarSala.setBounds(466, 21, 322, 50);
//		contentPane.add(btnAgregarSala);
		add(btnAgregarSala);

		btnAgregarEmpleado = new JButton("Agregar Empleados");
		btnAgregarEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarEmpleado.setForeground(Color.WHITE);
		btnAgregarEmpleado.setOpaque(false);
		btnAgregarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnAgregarEmpleado.setBorder(null);
		btnAgregarEmpleado.setBackground(new Color(0, 0, 0, 0));
		btnAgregarEmpleado.setBounds(466, 86, 430, 50);
//		contentPane.add(btnEliminarEmpleado);
		add(btnAgregarEmpleado);

		btnEliminarEmpleado = new JButton("Eliminar Empleado");
		btnEliminarEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarEmpleado.setForeground(Color.WHITE);
		btnEliminarEmpleado.setOpaque(false);
		btnEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnEliminarEmpleado.setBorder(null);
		btnEliminarEmpleado.setBackground(new Color(0, 0, 0, 0));
		btnEliminarEmpleado.setBounds(466, 151, 430, 50);
//		contentPane.add(btnAgregarEmpleados);
		add(btnEliminarEmpleado);

	}

	public void setOptionsListeners(ActionListener peliculasAction, ActionListener agregarPeliculaAction,
			ActionListener establecerSalaAction, ActionListener agregarSalaAction, ActionListener agregarEmpleadoAction,
			ActionListener eliminarEmpleadoAction) {

		btnPeliculas.addActionListener(peliculasAction);
		btnAgregarPelicula.addActionListener(agregarPeliculaAction);
		btnEstablecerSala.addActionListener(establecerSalaAction);
		btnAgregarSala.addActionListener(agregarSalaAction);
		btnAgregarEmpleado.addActionListener(agregarEmpleadoAction);
		btnEliminarEmpleado.addActionListener(eliminarEmpleadoAction);

	}

}