package CrimeFile;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

//Login class is for admin and users. 

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField Password;
	private JTextField ID;
	private JLabel lblL;
	private JLabel lblCrmeRecordSystem;
	private String adminname = "admin";
	private String adminPassword = "admin";
	Connection conn = null; // connect to MySQL

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setTitle("Crime Record System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	// Create the frame.

	public Login() {
		try {
			getConnection(); // for connecting to the database
		} catch (SQLException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1, 50, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Password = new JPasswordField();
		Password.setToolTipText("");
		Password.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Password.setForeground(Color.WHITE);
		Password.setBounds(450, 286, 310, 38);
		Password.setBackground((new Color(1, 50, 67)));
		contentPane.add(Password);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(450, 238, 120, 35);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblPassword);

		JLabel lblId = new JLabel("Personal Identification Number ");
		lblId.setBounds(450, 129, 279, 16);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblId);

		ID = new JTextField();
		ID.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		ID.setForeground(Color.WHITE);
		ID.setBounds(449, 174, 311, 38);
		ID.setBackground((new Color(1, 50, 67)));
		contentPane.add(ID);
		ID.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(501, 361, 209, 38);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ID.getText().length() == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else if (Password.getPassword().length == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else {
					String user = ID.getText(); // Collecting the id input
					char[] pass = Password.getPassword(); // Collecting the password input
					String pwd = String.copyValueOf(pass); // converting from array to string

					// FOR USER LOGIN
					if (getLogin(user, pwd)) {
						dispose();
						UserDashboard UserDash = new UserDashboard();
						UserDash.setVisible(true);
					}
					// FOR ADMIN LOGIN
					else if (getLogin(adminname, adminPassword)) {
						AdminPage adminpage = new AdminPage();
						adminpage.setVisible(true);

					}

					else
						JOptionPane.showMessageDialog(null, "Try Again!");

				}

			}
		});
		contentPane.add(btnNewButton);

		lblL = new JLabel("GENERAL DIRECTORATE OF SECURITY");
		lblL.setBackground(new Color(128, 128, 128));
		lblL.setBounds(392, 24, 419, 47);
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblL.setForeground(new Color(255, 255, 255));
		contentPane.add(lblL);

		lblCrmeRecordSystem = new JLabel("CRIME RECORD SYSTEM");
		lblCrmeRecordSystem.setBounds(501, 73, 209, 22);
		lblCrmeRecordSystem.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCrmeRecordSystem.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCrmeRecordSystem);

		JSeparator separator = new JSeparator();
		separator.setBounds(761, 198, -316, -1);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(228, 241, 254));
		panel.setBounds(0, 0, 383, 494);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(169, 169, 169));
		lblNewLabel.setBounds(-67, 33, 473, 400);
		// for image icon
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\batuh\\Desktop\\Klasörler\\workspace\\SE 318 - Crime File\\src\\images\\badge-drawing-police-officer-9.png"));

		panel.add(lblNewLabel);
	}

	// CONNECT TO DATABASE
	public Connection getConnection() throws SQLException {

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;
	}

	// this method performs to get user informations from database in order to login
	// to the system.
	boolean getLogin(String username, String password) {
		try {
			conn = this.getConnection();
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}
		try {
			// get login information
			PreparedStatement pst = conn.prepareStatement("Select * from users where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);

			// We write a query to get the data from the table.
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}