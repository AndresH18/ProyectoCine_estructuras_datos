import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import cine.Cine;
import interfaces.EstablecerSala;

public class Main extends JFrame {

	public Main() {
		final EstablecerSala establecerSala = new EstablecerSala(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
//		setLocationRelativeTo(null);
//		setLayout(new GridLayout());
		setContentPane(establecerSala);
		setBounds(100, 100, establecerSala.getWidth(), establecerSala.getHeight());
		setVisible(true);
	}

	public static void main(String[] args) {
		Main m = new Main();
	}

}
