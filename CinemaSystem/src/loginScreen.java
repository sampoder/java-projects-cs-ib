import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		passwordLabel.setBounds(37, 103, 61, 31);
		frame.getContentPane().add(passwordLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Phantom Sans 0.7", Font.BOLD, 13));
		usernameLabel.setBounds(37, 34, 103, 31);
		frame.getContentPane().add(usernameLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(usernameInput.getText().equals("sam") && passwordInput.getText().equals("poder")){
					String message = "Welcome.";
					mainMenu mm = new mainMenu();
					mm.mainMenu();
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					
				}
				else {
					String message = "You are not welcome.";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		loginButton.setFont(new Font("Phantom Sans 0.7", Font.PLAIN, 13));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(31, 176, 384, 29);
		frame.getContentPane().add(loginButton);
	}
}
