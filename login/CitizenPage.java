package CrimeFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CitizenPage extends JFrame {

	private JPanel contentPane;
	private JTextArea subject, crimeReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitizenPage frame = new CitizenPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CitizenPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1,50,67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubject = new JLabel("Crime Report:");
		lblSubject.setBounds(45, 118, 144, 39);
		lblSubject.setForeground(new Color(255, 255, 255));
		lblSubject.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblSubject);
		
		subject = new JTextArea();
		subject.setForeground(new Color(0, 0, 0));
		subject.setBackground(new Color(204, 204, 204));
		subject.setBounds(194, 41, 230, 29);
		contentPane.add(subject);
		
		JLabel label = new JLabel("Subject:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label.setBounds(45, 41, 106, 39);
		contentPane.add(label);
		
		 crimeReport = new JTextArea();
		crimeReport.setBackground(new Color(204, 204, 204));
		crimeReport.setBounds(194, 133, 358, 223);
		contentPane.add(crimeReport);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RegisterData()) {
					JOptionPane.showMessageDialog(null, "Your report has been sent succesfully!");
				}
			}
			
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(457, 390, 97, 25);
		contentPane.add(btnNewButton);
	}
	
	//CITIZEN CAN ENTER ANY COMPLAINT
	public Boolean RegisterData() {

		String strSubject = subject.getText();
		String strReport = crimeReport.getText();
		
	

		if (strSubject.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null, "Please enter (subject)");
			subject.requestFocusInWindow();
			return false;
		}
		if (strReport.equals("")) // Surname
		{
			JOptionPane.showMessageDialog(null, "Please enter (your complaints)");
			crimeReport.requestFocusInWindow();
			return false;
		}

		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		//COMPLANTS THAT CITIZEN ENTERED IS, SAVING TO THE DATABASE
		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

			s = connect.createStatement();

			// SQL Insert
			String sql = "INSERT INTO complaints "
					+ "(subject,report) " + "VALUES ('"
					+ strSubject + "','" + strReport +  "')";
			s.execute(sql);

			// Reset Text Fields
			subject.setText("");
			crimeReport.setText("");
			
			status = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return status;
	}
}
