package interfaces.login;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.InvalidArgumentE;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LogIn extends JPanel implements FilenameFilter {

	private Usuario[] usuarios;

	private final File ROOT;
	private final JFrame frame;
	public final int HEIGHT, WIDTH;

	private ActionListener login;

	private JPanel Principal;
	private JPasswordField password;
	private JTextField Userid;
	private JButton btnCrearUsuario;
	private JButton btnIngresar;

	/**
	 * Create the frame.
	 */

	public LogIn(JFrame frame, File ROOT) {
		this.frame = frame;
		this.ROOT = ROOT;
		this.usuarios = new Usuario[0];

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.DARK_GRAY);
		setBounds(screenSize.width * 3 / 10, screenSize.height * 3 / 10, screenSize.width * 4 / 10,
				screenSize.height * 4 / 10);
		Principal = this;
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setBackground(Color.DARK_GRAY);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(null);

		WIDTH = getWidth();
		HEIGHT = getHeight();

		JTextPane txtpnBienvenido = new JTextPane();
		txtpnBienvenido.setEditable(false);
		txtpnBienvenido.setBackground(new Color(0, 0, 0, 0));
		txtpnBienvenido.setForeground(Color.WHITE);
		txtpnBienvenido.setOpaque(false);
		txtpnBienvenido.setBorder(null);
		txtpnBienvenido.setFont(new Font("Tahoma", Font.BOLD, 33));
		txtpnBienvenido.setText("    Bienvenido \r\n     ingrese\r\n    sus datos");
		txtpnBienvenido.setBounds(0, getHeight() * 1 / 10, getWidth() * 4 / 10, getHeight() * 50 / 100);
		Principal.add(txtpnBienvenido);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(getWidth() * 50 / 100, getHeight() * 45 / 100, getWidth() * 40 / 100, getHeight() * 7 / 100);
		Principal.add(password);

		Userid = new JTextField();
		Userid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Userid.setBounds(getWidth() * 50 / 100, getHeight() * 20 / 100, getWidth() * 40 / 100, getHeight() * 7 / 100);
		Principal.add(Userid);
		Userid.setColumns(10);

		JTextPane txtpnIngreseLaContrasea = new JTextPane();
		txtpnIngreseLaContrasea.setOpaque(false);
		txtpnIngreseLaContrasea.setBorder(null);
		txtpnIngreseLaContrasea.setBackground(new Color(0, 0, 0, 0));
		txtpnIngreseLaContrasea.setForeground(Color.WHITE);
		txtpnIngreseLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIngreseLaContrasea.setText("Ingrese la contrase\u00F1a");
		txtpnIngreseLaContrasea.setEditable(false);
		txtpnIngreseLaContrasea.setBounds(getWidth() * 50 / 100, getHeight() * 37 / 100, getWidth() * 40 / 100,
				getHeight() * 1 / 10);
		Principal.add(txtpnIngreseLaContrasea);

		JTextPane txtpnIngreseElUsuario = new JTextPane();
		txtpnIngreseElUsuario.setText("Ingrese el usuario");
		txtpnIngreseElUsuario.setForeground(Color.WHITE);
		txtpnIngreseElUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIngreseElUsuario.setOpaque(false);
		txtpnIngreseElUsuario.setBorder(null);
		txtpnIngreseElUsuario.setEditable(false);
		txtpnIngreseElUsuario.setBackground(new Color(0, 0, 0, 0));
		txtpnIngreseElUsuario.setBounds(getWidth() * 50 / 100, getHeight() * 12 / 100, getWidth() * 40 / 100,
				getHeight() * 1 / 10);
		Principal.add(txtpnIngreseElUsuario);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String us = Userid.getText();
				final String pass = String.valueOf(password.getPassword());
				if (isUser(us, pass)) {
					if (login != null) {
						limpiar();
						login.actionPerformed(null);
					}
				} else {
					Toolkit.getDefaultToolkit().beep();
				}

			}
		});
		btnIngresar.setOpaque(false);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(new Color(0, 0, 0, 0));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIngresar.setBounds(getWidth() * 50 / 100, getHeight() * 60 / 100, getWidth() * 40 / 100,
				getHeight() * 7 / 100);
		Principal.add(btnIngresar);

		btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String us = Userid.getText();
				final String pass = String.valueOf(password.getPassword());
				if (us.isBlank()) {
					// USET
					JOptionPane.showMessageDialog(frame, "POR FAVOR LLENE TODOS LOS CAMPOS");

				} else if (password.getPassword().length < 3) {
					// NO VALID
					JOptionPane.showMessageDialog(frame, "CONTRASE" + (int) 209 + "A NO VALIDA", "",
							JOptionPane.ERROR_MESSAGE);

				} else if (isUser(us)) {
					JOptionPane.showMessageDialog(frame, "EL USUARIO YA EXISTE", "", JOptionPane.ERROR_MESSAGE);
				} else {
					if (JOptionPane.showConfirmDialog(frame, "CONFIRMAR", "",
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						final Usuario u = new Usuario(us, pass);
						writeUsuario(u);
						limpiar();
					}
				}
			}
		});
		btnCrearUsuario.setForeground(Color.WHITE);
		btnCrearUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCrearUsuario.setOpaque(false);
		btnCrearUsuario.setBorder(null);
		btnCrearUsuario.setBackground(new Color(0, 0, 0, 0));
		btnCrearUsuario.setBounds(getWidth() * 50 / 100, getHeight() * 70 / 100, getWidth() * 40 / 100,
				getHeight() * 7 / 100);
		Principal.add(btnCrearUsuario);

		readUsers();
	}

	private boolean isUser(String id, String ps) {
		int n = -1;
		while (++n < usuarios.length && !(usuarios[n].getUsuario().equals(id) && usuarios[n].getPassword().equals(ps)))
			;
		return n < usuarios.length;
	}

	private boolean isUser(String id) {
		int n = -1;
		while (++n < usuarios.length && !usuarios[n].getUsuario().equals(id))
			;
		return n < usuarios.length;
	}

	private void readUsers() {
		usuarios = new Usuario[0];
		for (File f : ROOT.listFiles(this)) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
				final Usuario us = (Usuario) in.readObject();
				if (us != null) {
					usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
					usuarios[usuarios.length - 1] = us;
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void writeUsuario(Usuario u) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(new File(ROOT, usuarios.length + "U.cu")))) {
			out.writeObject(u);
			readUsers();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addLoginListener(ActionListener login) {
		this.login = login;
	}

	private void limpiar() {
		Userid.setText("");
		password.setText("");
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".cu");
	}

}