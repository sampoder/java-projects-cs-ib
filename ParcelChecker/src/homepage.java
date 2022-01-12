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
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepage {

	private JFrame frame;
	private JTextField enterName;
	private JTextField txtWeightkg;
	private JTextField txtHeightcm;
	private JTextField txtLenghtcm;
	private JTextField txtBreadthcm;
	private int acceptedPackages = 0;
	private int acceptedWeight = 0;
	private float acceptedPrice = 0;
	private int rejectedPackages = 0;

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

		JLabel lblNewLabel = new JLabel("Log Parcels");
		lblNewLabel.setFont(new Font("Phantom Sans 0.7", Font.BOLD, 18));
		lblNewLabel.setBounds(16, 16, 195, 26);
		frame.getContentPane().add(lblNewLabel);

		txtWeightkg = new JTextField();
		txtWeightkg.setToolTipText("Weight (KG)");
		txtWeightkg.setBounds(12, 49, 209, 26);
		frame.getContentPane().add(txtWeightkg);
		txtWeightkg.setColumns(10);

		txtHeightcm = new JTextField();
		txtHeightcm.setToolTipText("Height (CM)");
		txtHeightcm.setColumns(10);
		txtHeightcm.setBounds(12, 79, 209, 26);
		frame.getContentPane().add(txtHeightcm);

		txtLenghtcm = new JTextField();
		txtLenghtcm.setToolTipText("Length (CM)");
		txtLenghtcm.setColumns(10);
		txtLenghtcm.setBounds(12, 106, 209, 26);
		frame.getContentPane().add(txtLenghtcm);

		txtBreadthcm = new JTextField();
		txtBreadthcm.setToolTipText("Breadth (CM)");
		txtBreadthcm.setColumns(10);
		txtBreadthcm.setBounds(12, 132, 209, 26);
		frame.getContentPane().add(txtBreadthcm);

		JButton btnEnter = new JButton("Enter Parcel");
		btnEnter.setBounds(6, 164, 117, 29);
		frame.getContentPane().add(btnEnter);

		JLabel acceptedLabel = new JLabel("0 Parcels Accepted (0kg, $0)");
		acceptedLabel.setBounds(16, 197, 240, 16);
		frame.getContentPane().add(acceptedLabel);

		JLabel rejectedLabel = new JLabel("0 Parcels Rejected");
		rejectedLabel.setBounds(16, 219, 240, 16);
		frame.getContentPane().add(rejectedLabel);

		btnEnter.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				boolean accepted = true;
				String regectionReasons = "";
				if (Integer.parseInt(txtHeightcm.getText()) > 80) {
					accepted = false;
				}
				if (Integer.parseInt(txtLenghtcm.getText()) > 80) {
					accepted = false;
				}
				if (Integer.parseInt(txtBreadthcm.getText()) > 80) {
					accepted = false;
				}
				if (accepted == false) {
					regectionReasons = "each dimension must be no more than 80 cm";
				}
				if ((Integer.parseInt(txtBreadthcm.getText()) + Integer.parseInt(txtHeightcm.getText())
						+ Integer.parseInt(txtLenghtcm.getText())) > 200) {
					accepted = false;
					if (regectionReasons != "") {
						regectionReasons += " + ";
					}
					regectionReasons += "the sum of the three dimensions must be no more than 200 cm";
				}
				if (Float.parseFloat(txtWeightkg.getText()) > 10) {
					accepted = false;
					if (regectionReasons != "") {
						regectionReasons += " + ";
					}
					regectionReasons += "the weight of the parcel must be between one and ten kilograms inclusive";
				}
				if (Float.parseFloat(txtWeightkg.getText()) < 1) {
					accepted = false;
					if (regectionReasons != "") {
						regectionReasons += " + ";
					}
					regectionReasons += "the weight of the parcel must be between one and ten kilograms inclusive";
				}
				if (accepted == true) {
					
					acceptedPackages += 1;
					float price = 10;
					acceptedWeight += Float.parseFloat(txtWeightkg.getText());
					if (Float.parseFloat(txtWeightkg.getText()) <= 5) {
						acceptedPrice += 10;
					} else {
						acceptedPrice += 10;
						float overweight = Float.parseFloat(txtWeightkg.getText()) - 5;
						acceptedPrice += overweight;
						price += overweight;
					}
					JOptionPane.showMessageDialog(new JFrame(), "Accepted will cost $" + String.valueOf(price), "Dialog",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					rejectedPackages += 1;
					JOptionPane.showMessageDialog(new JFrame(), "Rejected as " + regectionReasons, "Dialog",
							JOptionPane.PLAIN_MESSAGE);
				}
				acceptedLabel.setText(String.valueOf(acceptedPackages) + " Parcels Accepted ("
						+ String.valueOf(acceptedWeight) + "kg, $" + String.valueOf(acceptedPrice) + ")");
				rejectedLabel.setText(String.valueOf(rejectedPackages) + " Parcels Rejected");
			}

		});

		JButton btnConfirm = new JButton("Finish Order");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirm.setBounds(6, 247, 117, 29);
		frame.getContentPane().add(btnConfirm);
	}
}
