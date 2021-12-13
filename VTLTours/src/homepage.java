import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;

public class homepage {

	private JFrame frame;
	private JTextField enterName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
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
	public homepage() {
		initialize();
	}

	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
		return java.sql.Date.valueOf(dateToConvert);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 262, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("VTL Tours (SG to JB)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("SF Pro Rounded", Font.BOLD, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(16, 16, 229, 27);
		frame.getContentPane().add(lblNewLabel);

		enterName = new JTextField();
		enterName.setFont(new Font("SF Pro Rounded", Font.PLAIN, 13));
		enterName.setBounds(14, 61, 229, 26);
		frame.getContentPane().add(enterName);
		enterName.setColumns(10);

		JLabel lblName = new JLabel("Passenger Name");
		lblName.setFont(new Font("SF Pro Rounded", Font.PLAIN, 13));
		lblName.setBounds(16, 47, 149, 16);
		frame.getContentPane().add(lblName);

		int[] times = new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24 };

		ArrayList<String> availableTimesList = new ArrayList<String>();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String todayString = df.format(new Date());

		for (int x = 0; x < times.length; x++) {
			if (new Date().getHours() < times[x]) {
				availableTimesList.add(todayString + " " + times[x] + ":00");
			}
		}

		LocalDate today = LocalDate.now();

		String tomorrowString = df.format(convertToDateViaSqlDate(today.plusDays(1)));

		for (int x = 0; x < times.length; x++) {
			availableTimesList.add(tomorrowString + " " + times[x] + ":00");

		}

		String tomorrowTomorrowString = df.format(convertToDateViaSqlDate(today.plusDays(2)));

		for (int x = 0; x < times.length; x++) {
			availableTimesList.add(tomorrowTomorrowString + " " + times[x] + ":00");

		}

		String[] availableTimesArray = new String[availableTimesList.size()];

		for (int i = 0; i < availableTimesList.size(); i++) {
			availableTimesArray[i] = availableTimesList.get(i);
		}

		JComboBox selectDate = new JComboBox();
		selectDate.setModel(new DefaultComboBoxModel(availableTimesArray));
		selectDate.setBounds(14, 107, 239, 27);
		frame.getContentPane().add(selectDate);

		JLabel lblDate = new JLabel("Date & Time");
		lblDate.setFont(new Font("SF Pro Rounded", Font.PLAIN, 13));
		lblDate.setBounds(16, 89, 149, 16);
		frame.getContentPane().add(lblDate);

		JLabel lblSelect = new JLabel("Select Seats");
		lblSelect.setFont(new Font("SF Pro Rounded", Font.PLAIN, 13));
		lblSelect.setBounds(16, 138, 149, 16);
		frame.getContentPane().add(lblSelect);

		JButton btnBook = new JButton("Book Tickets (for $0)");
		btnBook.setBounds(14, 253, 163, 27);
		btnBook.setEnabled(false);
		frame.getContentPane().add(btnBook);

		JRadioButton[] buttons = new JRadioButton[32];

		int counter = 0;

		ArrayList<Integer> seats = new ArrayList<Integer>();

		for (int y = 0; y < (buttons.length / 8); y++) {
			for (int x = 0; x < (buttons.length / 4); x++) {
				if (counter < 32) {
					buttons[counter] = new JRadioButton("");
					int addedY = 0;
					if (counter > 15) {
						addedY = 10;
					}
					buttons[counter].setBounds(12 + (28 * x), 157 + (18 * y) + addedY, 28, 23);
					int counterHere = counter;
					buttons[counter].addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								seats.add(counterHere);
								btnBook.setEnabled(true);
								btnBook.setText("Book Tickets (for $" + (seats.size() * 2) + ")");
							} else if (e.getStateChange() == ItemEvent.DESELECTED) {
								for (int i = 0; i < seats.size(); i++) {
									if (seats.get(i) == counterHere) {
										seats.remove(i);
									}
								}
								if (seats.size() == 0) {
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
	}
}
