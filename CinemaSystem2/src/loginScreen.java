import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class loginScreen {

	private JFrame frame;
	private JTextField passwordInput;
	private JTextField usernameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginScreen window = new loginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginScreen() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {

		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Phantom Sans 0.7", Font.PLAIN, 13));
		usernameInput.setBounds(31, 57, 384, 46);
		frame.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);

		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Phantom Sans 0.7", Font.PLAIN, 13));
		passwordInput.setToolTipText("Password");
		passwordInput.setBounds(31, 125, 384, 46);
		frame.getContentPane().add(passwordInput);
		passwordInput.setColumns(10);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Phantom Sans 0.7", Font.BOLD, 13));
		passwordLabel.setBounds(37, 103, 103, 31);
		frame.getContentPane().add(passwordLabel);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Phantom Sans 0.7", Font.BOLD, 13));
		usernameLabel.setBounds(37, 34, 103, 31);
		frame.getContentPane().add(usernameLabel);

		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean correctLogin = false;
				String JdbcURL = "jdbc:mysql://localhost:8889/CinemaSystem?useSSL=false";
				String Username = "root";
				String password = "root";
				Connection con = null;

				try {
					con = DriverManager.getConnection(JdbcURL, Username, password);
					try (Statement stmt = con.createStatement()) {
						String selectSql = "SELECT * FROM userLogins where Username ='" + usernameInput.getText() 
							+ "'and  Passwords = '" + passwordInput.getText() + "'";
						try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
							if(resultSet.next()) {
								System.out.println("hi!");
								correctLogin = true;
							}
							else {
								System.out.println("hi!");
								correctLogin = false;
							}
						}
					}
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				if (correctLogin) {
					String message = "Welcome.";
					mainMenu mm = new mainMenu();
					mm.launch();
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();

				} else {
					String message = "You are not welcome.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		loginButton.setFont(new Font("Phantom Sans 0.7", Font.PLAIN, 13));
		loginButton.setBounds(31, 176, 384, 29);
		frame.getContentPane().add(loginButton);
	}
}
