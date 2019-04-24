package CrimeFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	boolean getComplaints(String subject, String report) {
		try {
			conn = this.getConnection();
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}
		try {
			PreparedStatement pst = conn.prepareStatement("Select * from complaints where subject=? and report=?");
			pst.setString(1, subject);
			pst.setString(2, report);

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

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		try {
			getConnection(); // for connecting to the database
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1, 50, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnComplaints = new JButton("Complaints");
		btnComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnComplaints.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnComplaints.setBounds(35, 48, 145, 35);
		contentPane.add(btnComplaints);
	}
}
