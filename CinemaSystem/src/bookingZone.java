import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;


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
		
		JButton btnBook = new JButton("Confirm Tickets");
		btnBook.setBounds(116, 218, 217, 29);
		frame.getContentPane().add(btnBook);
		btnBook.setEnabled(false);
		JRadioButton[] buttons = new JRadioButton[50];
		
		int counter = 0;
		
		ArrayList<Integer> seats = new ArrayList<Integer>();
		
		for(int y = 0; y<(buttons.length / 10); y++) {
			for(int x = 0; x<(buttons.length / 5); x++) {
				if(counter < 50) {
					buttons[counter] = new JRadioButton("");
					buttons[counter].setBounds(85+(28 * x), 60+(23 * y), 28, 23);
					int counterHere = counter;
					buttons[counter].addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
						    if (e.getStateChange() == ItemEvent.SELECTED) {
						    	seats.add(counterHere);
						    	btnBook.setEnabled(true);
						    }
						    else if (e.getStateChange() == ItemEvent.DESELECTED) {
						    	for (int i = 0; i < seats.size(); i++) {
					    	      if(seats.get(i) == counterHere){
					    	    	  seats.remove(i);
					    	      }
					    	    }
						    	if(seats.size() == 0) {
						    		btnBook.setEnabled(false);
						    	}
						    }
						}
					});
					frame.getContentPane().add(buttons[counter]);
					counter++;
				}
				
			}
		}
		
		btnBook.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(btnBook.isEnabled()) {
					seats.sort(null);
					String message = "Thank you for booking ";
					for (int i = 0; i < seats.size(); i++) {
					  String[] letters = {"A", "B", "C", "D", "E"};
					  message += letters[seats.get(i) / 10];
					  int seatNo = (seats.get(i) % 10) + 1;
					  message += seatNo;
		    	      if(i == (seats.size() - 1)) {
		    	    	  message += " to watch "; 
		    	    	  message += movieName;
		    	    	  message += ".";
		    	      }
		    	      else if(i == (seats.size() - 2)) {
		    	    	  message += " & ";
		    	      }
		    	      else {
		    	    	  message += ", ";
		    	      }
		    	    }
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.PLAIN_MESSAGE);
					mainMenu mm = new mainMenu();
					mm.mainMenu();
					frame.dispose();
				}
			}
		});
		
	}
}
