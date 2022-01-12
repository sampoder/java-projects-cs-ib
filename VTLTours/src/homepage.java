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

		String JdbcURL = "jdbc:mysql://localhost:8889/VTLTours?useSSL=false";
		String Username = "root";
		String password = "root";

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

		String[] availableTimesArray = new String[availableTimesList.size() + 1];
		availableTimesArray[0] = "Select An Option";
		for (int i = 1; i < availableTimesList.size() + 1; i++) {
			availableTimesArray[i] = availableTimesList.get(i - 1);
		}

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
					buttons[counter].setEnabled(false);
					int counterHere = counter;
					buttons[counter].addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								seats.add(counterHere);
								if(enterName.getText() != "") {
									btnBook.setEnabled(true);
								}
								btnBook.setText("Book Tickets (for $" + (seats.size() * 2) + ")");
							} else if (e.getStateChange() == ItemEvent.DESELECTED) {
								for (int i = 0; i < seats.size(); i++) {
									if (seats.get(i) == counterHere) {
										seats.remove(i);
									}
								}
								btnBook.setText("Book Tickets (for $" + (seats.size() * 2) + ")");
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
		
		JComboBox selectDate = new JComboBox();
		selectDate.setModel(new DefaultComboBoxModel(availableTimesArray));
		selectDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedItem = (String) e.getItem();
					if(selectedItem == "Select An Option") {
						for(int q = 0; q < buttons.length; q++) {
							buttons[q].setEnabled(false);
						}
						btnBook.setEnabled(false);
					}
					else {
						for(int q = 0; q < buttons.length; q++) {
							buttons[q].setEnabled(true);
						}
						Connection con = null;

						try {
							con = DriverManager.getConnection(JdbcURL, Username, password);
							try (Statement stmt = con.createStatement()) {
								String selectSql = "SELECT * FROM `Bookings` where Date ='" + selectedItem + "'";
								try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
									while(resultSet.next()) {
										buttons[resultSet.getInt("Seat")].setEnabled(false);
									}
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		selectDate.setBounds(14, 107, 239, 27);
		frame.getContentPane().add(selectDate);

		btnBook.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					if (btnBook.isEnabled()) {
						seats.sort(null);
						for (int i = 0; i < seats.size(); i++) {
							String sqlStatement = "INSERT INTO `Bookings` (`Date`, `Booker`, `Seat`) VALUES ('"
									+ String.valueOf(selectDate.getSelectedItem()) + "', '" + enterName.getText()
									+ "', '" + seats.get(i) + "');";
							System.out.println(sqlStatement);
							Connection con = DriverManager.getConnection(JdbcURL, Username, password);
							try (Statement stmt = con.createStatement()) {
								stmt.executeUpdate(sqlStatement);
							}
						}
						String message = "Thank you for booking ";
						for (int i = 0; i < seats.size(); i++) {
							String[] letters = { "A", "B", "C", "D", "E" };
							int seatNo = (seats.get(i) % 8) + 1;
							message += seatNo;
							message += letters[seats.get(i) / 8];
							if (i == (seats.size() - 1)) {
								message += " to take the bus";
								message += ".";
							} else if (i == (seats.size() - 2)) {
								message += " & ";
							} else {
								message += ", ";
							}
						}
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.PLAIN_MESSAGE);
						frame.dispose();
						homepage theHomepage = new homepage();
						theHomepage.main(new String[] {});
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
