import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bookingZone {

	private JFrame frame;
	public static String movieName;

	/**
	 * Launch the application.
	 */
	public static void bookingZone() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookingZone window = new bookingZone();
					window.movieName = movieName;
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
	public bookingZone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book tickets for " + movieName);
		lblNewLabel.setFont(new Font("Phantom Sans 0.7", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 450, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirm Tickets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(116, 218, 217, 29);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton[] buttons = new JRadioButton[50];
		
		int counter = 0;
		
		for(int y = 0; y<(buttons.length / 10); y++) {
			for(int x = 0; x<(buttons.length / 5); x++) {
				if(counter < 50) {
					System.out.println(counter);
					buttons[counter] = new JRadioButton("");
					buttons[counter].setBounds(85+(28 * x), 60+(23 * y), 28, 23);
					if(counter % 2 != 0) {
						buttons[counter].setEnabled(false);
					}
					frame.getContentPane().add(buttons[counter]);
					counter++;
				}
				
			}
		}
		
	}
}
