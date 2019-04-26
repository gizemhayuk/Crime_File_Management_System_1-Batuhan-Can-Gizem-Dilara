package CrimeFile;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Registration extends JFrame {
	private JTable table;
	Connection conn = null;
	Statement s = null;
	Boolean status = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Registration frame = new Registration();
				frame.setTitle("Crime Record System");
				frame.setVisible(true);
			}
		});
	}

	// Create the frame.

	public Connection getConnection() throws SQLException {

		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

			s = conn.createStatement();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return conn;
	}

	public Registration() {
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(1, 50, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 514);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 53, 761, 401);
		getContentPane().setBackground(new Color(1, 50, 67));
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setBackground(new Color(1, 50, 67));
		table.setColumnSelectionAllowed(true);

		JButton btnNewButton = new JButton("Load Citizens");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from registration";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(845, 15, 113, 25);
		getContentPane().add(btnNewButton);

	}

}