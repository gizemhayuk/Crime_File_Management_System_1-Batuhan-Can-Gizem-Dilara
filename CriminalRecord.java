package CrimeFile;

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

public class CriminalRecord extends JFrame {

	private JTextField Name, Surname, CitizenshipNumber,DOB, BirthPlace, textField;
	JTextArea CrimeRecord;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CriminalRecord frame = new CriminalRecord();
				frame.setVisible(true);
			}
		});
	}

	// Create the frame.

	public CriminalRecord() {
		getContentPane().setBackground(new Color(1, 50, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 343);
		getContentPane().setLayout(null);

		JLabel newRecord = new JLabel("CRIMINAL RECORD SYSTEM\r\n");
		newRecord.setForeground(new Color(255, 255, 255));
		newRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		newRecord.setHorizontalAlignment(SwingConstants.CENTER);
		newRecord.setBounds(78, 13, 276, 20);
		getContentPane().add(newRecord);

		JLabel newName = new JLabel("Name:");
		newName.setForeground(new Color(255, 255, 255));
		newName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newName.setBounds(78, 52, 89, 14);
		getContentPane().add(newName);

		JLabel newSurname = new JLabel("Surname:");
		newSurname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newSurname.setForeground(new Color(255, 255, 255));
		newSurname.setBounds(78, 79, 89, 21);
		getContentPane().add(newSurname);

		JLabel newCitizenshipNumber = new JLabel("Citizenship Number:\r\n");
		newCitizenshipNumber.setForeground(new Color(255, 255, 255));
		newCitizenshipNumber.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newCitizenshipNumber.setBounds(77, 113, 130, 14);
		getContentPane().add(newCitizenshipNumber);

		JLabel newDOB = new JLabel("Date Of Birth:\r\n");
		newDOB.setForeground(new Color(255, 255, 255));
		newDOB.setBounds(78, 140, 89, 23);
		getContentPane().add(newDOB);

		JLabel newBirthPlace = new JLabel("Birth Place:");
		newBirthPlace.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		newBirthPlace.setForeground(new Color(255, 255, 255));
		newBirthPlace.setBounds(80, 176, 89, 14);
		getContentPane().add(newBirthPlace);

		JLabel newCrimeRecord = new JLabel("Crime Record:\r\n\r\n");
		newCrimeRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newCrimeRecord.setForeground(new Color(255, 255, 255));
		newCrimeRecord.setBounds(78, 217, 104, 31);
		getContentPane().add(newCrimeRecord);

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (RegisterData()) {
					JOptionPane.showMessageDialog(null, "Register Data Successfully");
				}
			}
		});
		btnSave.setBounds(170, 268, 89, 23);
		getContentPane().add(btnSave);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(217, 46, 137, 22);
		getContentPane().add(Name);

		Surname = new JTextField();
		Surname.setBounds(217, 76, 137, 22);
		getContentPane().add(Surname);
		Surname.setColumns(10);

		CitizenshipNumber = new JTextField();
		CitizenshipNumber.setBounds(217, 109, 137, 22);
		getContentPane().add(CitizenshipNumber);
		CitizenshipNumber.setColumns(10);

		DOB = new JTextField();
		DOB.setBounds(217, 140, 137, 22);
		getContentPane().add(DOB);
		DOB.setColumns(10);

		BirthPlace = new JTextField();
		BirthPlace.setColumns(10);
		BirthPlace.setBounds(217, 172, 137, 22);
		getContentPane().add(BirthPlace);

		CrimeRecord = new JTextArea();
		CrimeRecord.setBounds(217, 207, 194, 48);
		getContentPane().add(CrimeRecord);
		CrimeRecord.setColumns(10);


	}

	private Boolean RegisterData() {

		String strName = Name.getText();
		String strSurname = new String(Surname.getText());
		String strCitizenshipNumber = new String(CitizenshipNumber.getText());
		String strDOB = DOB.getText();
		String strBirthPlace = BirthPlace.getText();
		String strCrimeRecord = CrimeRecord.getText();

		if (strName.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null, "Please Input (Username)");
			Name.requestFocusInWindow();
			return false;
		}
		if (strSurname.equals("")) // Surname
		{
			JOptionPane.showMessageDialog(null, "Please Input (Password)");
			Surname.requestFocusInWindow();
			return false;
		}

		if (strCitizenshipNumber.equals("")) // Citizenship No
		{
			JOptionPane.showMessageDialog(null, "Please Input (Citizenship Number)");
			CitizenshipNumber.requestFocusInWindow();
			return false;
		}

		if (strDOB.equals("")) // Date of Birth
		{
			JOptionPane.showMessageDialog(null, "Please Input (Date of Birth)");
			DOB.requestFocusInWindow();
			return false;
		}

		if (strBirthPlace.equals("")) // Birth Place
		{
			JOptionPane.showMessageDialog(null, "Please Input (Birth Place)");
			BirthPlace.requestFocusInWindow();
			return false;
		}

		if (strCrimeRecord.equals("")) // Crime Record
		{
			JOptionPane.showMessageDialog(null, "Please Input (Crime Record)");
			CrimeRecord.requestFocusInWindow();
			return false;
		}

		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		try {
			//Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

			s = connect.createStatement();

			// SQL Insert
			String sql = "INSERT INTO crime_record "
					+ "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace, CrimeRecord) " + "VALUES ('"
					+ strName + "','" + strSurname + "','" + strCitizenshipNumber + "'" + ",'" + strDOB + "','"
					+ strBirthPlace + "', '" + strCrimeRecord + "')";
			s.execute(sql);

			// Reset Text Fields
			Name.setText("");
			Surname.setText("");
			CitizenshipNumber.setText("");
			DOB.setText("");
			BirthPlace.setText("");
			CrimeRecord.setText("");

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
