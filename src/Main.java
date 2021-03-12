import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cine.Cine;
import interfaces.EstablecerSala;

public class Main extends JFrame {

	private static final File ROOT = new File(System.getProperty("user.dir").concat("\\Data"));
	private static final File CINE_DATA = new File(ROOT, "cine.cn");
	private final Cine cine;
	private final EstablecerSala establecerSala;
	//OTROS PANELES

	public Main() {

		cine = initFile();

		establecerSala = new EstablecerSala(this, cine);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
//		setLocationRelativeTo(null);
//		setLayout(new GridLayout());
		setContentPane(establecerSala);
		setBounds(100, 100, establecerSala.getWidth(), establecerSala.getHeight());
		setVisible(true);
	}

	private Cine initFile() {
		if (!(ROOT.exists() && ROOT.isDirectory())) {
			ROOT.mkdirs();
			return new Cine(CINE_DATA);
		} else if (CINE_DATA.exists()) {
			return new Cine(CINE_DATA);
		} else {
			//READ
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CINE_DATA))){
				final Object c = in.readObject();
				return (Cine) c;
			} catch (IOException | ClassNotFoundException  e) {
				e.printStackTrace();
				System.err.println("CREATING DEFAULT FILE");
				JOptionPane.showMessageDialog(this,"ARCHIVO NO ENCONTRADO","ERROR",JOptionPane.ERROR_MESSAGE);
				return new Cine(CINE_DATA);
			}
		}
	}

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
		Main m = new Main();
//		File file = new File(ROOT, "ja");
//		File file2 = new File(file, "\\f1\\f2\\f3\\MMMMMM.cncnc");
//		System.out.println(file2.getAbsolutePath());
//		System.out.println(file2.mkdirs());
	}

}
