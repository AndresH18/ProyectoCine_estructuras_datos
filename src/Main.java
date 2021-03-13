import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cine.Cine;
import interfaces.AgregarSala;
import interfaces.EliminarEmpleado;
import interfaces.EstablecerSala;
import interfaces.EstablecerSala2;

public class Main extends JFrame {

	private static final File ROOT = new File(System.getProperty("user.dir").concat("\\Data"));
	private static final File CINE_DATA = new File(ROOT, "cine.cn");
	
	private final Cine cine;
	
	private final EstablecerSala establecerSala;
	private final EliminarEmpleado eliminarEmpleado;
	private final AgregarSala agregarSala;
	// OTROS PANELES

	public Main() {
		cine = initFile();

		establecerSala = new EstablecerSala(this, cine);
		establecerSala.setRegresarListener(regresar);
		
		eliminarEmpleado = new EliminarEmpleado(this, cine);
		
		agregarSala = new AgregarSala(this, cine);
		agregarSala.setRegresarListener(regresar);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		
		

		
		setPanel(establecerSala, "HOLASS");

		
//		setLocationRelativeTo(null);
//		setLayout(new GridLayout());
//		setVisible(false);
//		setContentPane(establecerSala);
//		setBounds(200, 200, establecerSala.getWidth(), establecerSala.getHeight());
//		setVisible(true);
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

	private void setPanel(JPanel panel, String title) {
//		setVisible(false);
		setContentPane(panel);
		setTitle(title);
		setBounds(200, 200, panel.getWidth(), panel.getHeight());
		setVisible(true);
	}
	
	private ActionListener regresar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//FIXME: Descomentar
//			setPanel(principal, "Menu Principal");
			System.err.println("ACTION!!!!");
			
		}
		
	};

//	/**
//	 * 
//	 * @param cineData
//	 * @return -1 if directory not found, 0 if Cine File not found, 1 if Cine File
//	 *         found
//	 */
//	private int initFile() {
//		if (!(ROOT.exists() && ROOT.isDirectory())) {
//			ROOT.mkdirs();
//			return -1;
//		} else if (CINE_DATA.exists()) {
//			return 1;
//		} else {
//			return 0;
//		}
//	}

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
