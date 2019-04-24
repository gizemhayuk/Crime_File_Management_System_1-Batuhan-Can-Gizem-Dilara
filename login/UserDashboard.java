package CrimeFile;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class UserDashboard extends JFrame {

	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CriminalRecord frame = new CriminalRecord();
				frame.setTitle("Crime Record System");
				frame.setVisible(true);
			}
		});
	}

	// Create the frame.

	public UserDashboard() {
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(1, 50, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 323);
		getContentPane().setLayout(null);

		JLabel newRecord = new JLabel("CRIMINAL RECORD SYSTEM\r\n");
		newRecord.setBounds(168, 50, 289, 20);
		newRecord.setForeground(new Color(255, 255, 255));
		newRecord.setFont(new Font("Century Gothic", Font.BOLD, 20));
		newRecord.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(newRecord);

		// Save Button
		JButton btnEnterCriminalRecord = new JButton("Enter Criminal Record");
		btnEnterCriminalRecord.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnterCriminalRecord.setBounds(205, 104, 226, 34);
		btnEnterCriminalRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					CriminalRecord cr = new CriminalRecord();
					cr.setVisible(true);
				
			}
		});
		getContentPane().add(btnEnterCriminalRecord);
		
		JButton btnEditCriminalRecord = new JButton("Edit Criminal Record");
		btnEditCriminalRecord.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditCriminalRecord.setBounds(205, 161, 226, 34);
		btnEditCriminalRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					//class henüz yok
				
			}
		});
		getContentPane().add(btnEditCriminalRecord);


	}


	
}