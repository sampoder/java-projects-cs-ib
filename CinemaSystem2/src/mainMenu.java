import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
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
	public mainMenu() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 225, 225 };
		gridBagLayout.rowHeights = new int[] { 75, 75, 75 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblShangChi = new JLabel("Shang Chi");
		lblShangChi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Shang Chi";
				bz.launch();
				frame.dispose();
			}
		});
		lblShangChi.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-34.png"));
		lblShangChi.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblShangChi = new GridBagConstraints();
		gbc_lblShangChi.fill = GridBagConstraints.BOTH;
		gbc_lblShangChi.insets = new Insets(0, 0, 5, 5);
		gbc_lblShangChi.gridx = 0;
		gbc_lblShangChi.gridy = 0;
		frame.getContentPane().add(lblShangChi, gbc_lblShangChi);

		JLabel lblEncanto = new JLabel("Encanto");
		lblEncanto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Encanto";
				bz.launch();
				frame.dispose();
			}
		});
		lblEncanto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncanto.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-30.png"));
		GridBagConstraints gbc_lblEncanto = new GridBagConstraints();
		gbc_lblEncanto.fill = GridBagConstraints.BOTH;
		gbc_lblEncanto.insets = new Insets(0, 0, 5, 0);
		gbc_lblEncanto.gridx = 1;
		gbc_lblEncanto.gridy = 0;
		frame.getContentPane().add(lblEncanto, gbc_lblEncanto);

		JLabel lblEternals = new JLabel("Eternals");
		lblEternals.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Eternals";
				bz.launch();
				frame.dispose();
			}
		});
		lblEternals.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-33.png"));
		lblEternals.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEternals = new GridBagConstraints();
		gbc_lblEternals.fill = GridBagConstraints.BOTH;
		gbc_lblEternals.insets = new Insets(0, 0, 5, 5);
		gbc_lblEternals.gridx = 0;
		gbc_lblEternals.gridy = 1;
		frame.getContentPane().add(lblEternals, gbc_lblEternals);

		JLabel lblSpiderman = new JLabel("Spiderman 3");
		lblSpiderman.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Spiderman 3";
				bz.launch();
				frame.dispose();
			}
		});
		lblSpiderman.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpiderman.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-29.png"));
		GridBagConstraints gbc_lblSpiderman = new GridBagConstraints();
		gbc_lblSpiderman.fill = GridBagConstraints.BOTH;
		gbc_lblSpiderman.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpiderman.gridx = 1;
		gbc_lblSpiderman.gridy = 1;
		frame.getContentPane().add(lblSpiderman, gbc_lblSpiderman);

		JLabel lblClifford = new JLabel("Clifford");
		lblClifford.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Clifford";
				bz.launch();
				frame.dispose();
			}
		});
		lblClifford.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-31.png"));
		lblClifford.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblClifford = new GridBagConstraints();
		gbc_lblClifford.fill = GridBagConstraints.BOTH;
		gbc_lblClifford.insets = new Insets(0, 0, 5, 5);
		gbc_lblClifford.gridx = 0;
		gbc_lblClifford.gridy = 2;
		frame.getContentPane().add(lblClifford, gbc_lblClifford);

		JLabel lblDune = new JLabel("Dune");
		lblDune.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookingZone bz = new bookingZone();
				bz.movieName = "Dune";
				bz.launch();
				frame.dispose();
			}
		});
		lblDune.setIcon(new ImageIcon("/Users/sam/Downloads/Untitled drawing-32.png"));
		lblDune.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDune = new GridBagConstraints();
		gbc_lblDune.insets = new Insets(0, 0, 5, 0);
		gbc_lblDune.fill = GridBagConstraints.BOTH;
		gbc_lblDune.gridx = 1;
		gbc_lblDune.gridy = 2;
		frame.getContentPane().add(lblDune, gbc_lblDune);
	}
}
