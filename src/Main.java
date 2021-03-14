import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cine.Cine;
import interfaces.AgregarPeliculaGUI;
import interfaces.AgregarSalaGUI;
import interfaces.EliminarEmpleadoGUI;
import interfaces.EstablecerSalaGUI;
import interfaces.MenuGUI;

public class Main extends JFrame {

	private static final File ROOT = new File(System.getProperty("user.dir").concat("\\Data"));
	private static final File CINE_DATA = new File(ROOT, "cine.cn");

	private final Cine cine;

	private final MenuGUI menu;
	// private final PeliculaGUI peliculas;
	private final AgregarPeliculaGUI agregarPelicula;
	private final AgregarSalaGUI agregarSala;
	private final EstablecerSalaGUI establecerSala;
	// private final EliminarEmpleadoGUI eliminarEmpleado;
	private final EliminarEmpleadoGUI eliminarEmpleado;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cine = initFile();

		menu = new MenuGUI(this, cine);
		menu.setOptionsListeners(peliculasAction, agregarPeliculasAction, establecerSalaAction, agregarSalaAction,
				agregarEmpleadoAction, eliminarEmpleadoAction);

		agregarPelicula = new AgregarPeliculaGUI(this, cine);
		agregarPelicula.setRegresarListener(regresar);

		establecerSala = new EstablecerSalaGUI(this, cine);
		establecerSala.setRegresarListener(regresar);

		eliminarEmpleado = new EliminarEmpleadoGUI(this, cine);

		agregarSala = new AgregarSalaGUI(this, cine);
		agregarSala.setRegresarListener(regresar);

//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				cine.update();
//			}
//		});
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);

//		setPanel(menu, "Menu Principal");
		setPanel(0);

	}

	private Cine initFile() {
		if (!(ROOT.exists() && ROOT.isDirectory())) {
			ROOT.mkdirs();
			return new Cine(CINE_DATA);
		} else if (!CINE_DATA.exists()) {
			return new Cine(CINE_DATA);
		} else {
			// READ
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CINE_DATA))) {
				final Object c = in.readObject();
				return (Cine) c;
			} catch (IOException | ClassNotFoundException e) {
				System.err.println("EXCEPTION: " + e.getMessage() + " CAUGHT");
				e.printStackTrace();
				System.err.println("CREATING DEFAULT FILE");
				JOptionPane.showMessageDialog(this,
						"ARCHIVO NO ENCONTRADO\nCREANDO ARCHIVO AUXILIAR\nCONTACTE A UN ADMINISTRADOR", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return new Cine(CINE_DATA);
			}
		}
	}

	/**
	 * @deprecated
	 * @param panel
	 * @param title
	 */
	private void setPanel(JPanel panel, String title) {
		setVisible(false);
		setResizable(true);
		setBounds(200, 100, 100, 100);
//		setVisible(false);
		setContentPane(panel);
		setTitle(title);
//		if (panel instanceof Menu) {
		setBounds(200, 100, panel.getWidth(), panel.getHeight());
//		} else {
//			setBounds(200, 200, panel.getWidth(), panel.getHeight());
//		}
		setVisible(true);
		setResizable(false);
	}

	/**
	 * 0 = MENU<br>
	 * 1 = PELICULAS<br>
	 * 2 = AGREGAR_PELICULAS<br>
	 * 3 = AGREGAR_SALA,<br>
	 * 4 = ESTABLECER_SALA<br>
	 * 5 = AGREGAR_EMPLEADO<br>
	 * 6 = ELIMINAR_EMPLEADO<br>
	 * 
	 * @param n
	 */
	private void setPanel(int n) {
//		setVisible(false);
		setResizable(true);
		if (n == 0) {
			// MENU
			System.out.println("MENU");
			setBounds(200, 100, menu.WIDTH, menu.HEIGHT);
			setTitle("Menu Principal");
			setContentPane(menu);

		} else if (n == 1) {
			// PELICULAS
			System.out.println("PELICULAS");
			
		} else if (n == 2) {
			// AGREGAR PELICULA
			System.out.println("AGREGAR PELICULA");
			setBounds(200, 150, agregarPelicula.WIDTH, agregarPelicula.HEIGHT);
			setContentPane(agregarPelicula);
			setTitle("Agregar Pelicula");
		} else if (n == 3) {
			// AGREGAR SALA
			System.out.println("AGREGAR SALA");
			setBounds(200, 150, agregarSala.WIDTH, agregarSala.HEIGHT);
			setContentPane(agregarSala);
			setTitle("Agregar Sala");

		} else if (n == 4) {
			// ESTABLECER SALA
			System.out.println("ESTABLECER SALA");
			establecerSala.refresh();
			setBounds(200, 150, establecerSala.WIDTH, establecerSala.HEIGH);
			setContentPane(establecerSala);
			setTitle("Establecer Sala");

		} else if (n == 5) {
			// AGREGAR EMPLEADO
			System.out.println("AGREGAR EMPLEAD");

		} else if (n == 6) {
			// ELIMINAR EMPLEADO
			System.out.println("ELIMINAR EMPLEADO");
			setBounds(200, 150, eliminarEmpleado.WIDTH, eliminarEmpleado.HEIGHT);
			setContentPane(eliminarEmpleado);
			setTitle("Eliminar Empleado");

		}
		setResizable(false);
//		setVisible(true);
	}

	private ActionListener regresar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("REGRESAR / MENU PRINCIPAL");

//			setPanel(menu, "Menu Principal");
			setPanel(0);
		}

	};
	private ActionListener peliculasAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("PELICULAS");
			// FIXME: DESCOMENTAR
			// setPanel(peliculas, "Peliculas");
			setPanel(1);
		}
	};
	private ActionListener agregarPeliculasAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("AGREGAR PELICULAS");
			// FIXME: DESCOMENTAR
			// setPanel(agregarPelicula, "Agregar Pelicula");
			setPanel(2);
		}
	};
	private ActionListener agregarSalaAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("AGREGAR SALA");

//			setPanel(agregarSala, "Agregar Sala");
			setPanel(3);
		}
	};
	private ActionListener establecerSalaAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("ESTABLECER SALA");

//			setPanel(establecerSala, "Establecer Sala");
			setPanel(4);
		}
	};

	private ActionListener agregarEmpleadoAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("AGREAGAR EMPLEADO");
			// FIXME: DESCOMENTAR
			// setPanel(agregarEmpleado, "AgregarEmpleado");
			setPanel(5);
		}
	};
	private ActionListener eliminarEmpleadoAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("ELIMINAR EMPLEADO");

//			setPanel(eliminarEmpleado, "Eliminar Empleado");
			setPanel(6);
		}
	};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main main = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
