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

	private JTextField Name, Surname, CitizenshipNumber, DOB, BirthPlace, textField;

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

	public CriminalRecord() {
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().setBackground(new Color(1, 50, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 659);
		getContentPane().setLayout(null);

		JLabel newRecord = new JLabel("CRIMINAL RECORD SYSTEM\r\n");
		newRecord.setBounds(151, 48, 289, 20);
		newRecord.setForeground(new Color(255, 255, 255));
		newRecord.setFont(new Font("Century Gothic", Font.BOLD, 20));
		newRecord.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(newRecord);

		JLabel newName = new JLabel("Name:");
		newName.setBounds(62, 117, 289, 14);
		newName.setForeground(new Color(255, 255, 255));
		newName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().add(newName);

		JLabel newSurname = new JLabel("Surname:");
		newSurname.setBounds(62, 158, 289, 21);
		newSurname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newSurname.setForeground(new Color(255, 255, 255));
		getContentPane().add(newSurname);

		JLabel newCitizenshipNumber = new JLabel("Citizenship Number:\r\n");
		newCitizenshipNumber.setBounds(62, 203, 290, 20);
		newCitizenshipNumber.setForeground(new Color(255, 255, 255));
		newCitizenshipNumber.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().add(newCitizenshipNumber);

		JLabel newDOB = new JLabel("Date Of Birth:\r\n");
		newDOB.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newDOB.setBounds(62, 255, 289, 23);
		newDOB.setForeground(new Color(255, 255, 255));
		getContentPane().add(newDOB);

		JLabel newBirthPlace = new JLabel("Birth Place:");
		newBirthPlace.setBounds(62, 307, 114, 22);
		newBirthPlace.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newBirthPlace.setForeground(new Color(255, 255, 255));
		getContentPane().add(newBirthPlace);

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(238, 361, 100, 34);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (RegisterData(Name.getText(), Surname.getText(), CitizenshipNumber.getText(), DOB.getText(),
						BirthPlace.getText())) {
					Login l = new Login();
					l.setVisible(true);
				}
			}
		});
		getContentPane().add(btnSave);

		Name = new JTextField();
		Name.setBounds(238, 115, 223, 22);
		Name.setColumns(10);
		getContentPane().add(Name);

		Surname = new JTextField();
		Surname.setBounds(238, 159, 223, 22);
		getContentPane().add(Surname);
		Surname.setColumns(10);

		CitizenshipNumber = new JTextField();
		CitizenshipNumber.setBounds(238, 204, 223, 22);
		getContentPane().add(CitizenshipNumber);
		CitizenshipNumber.setColumns(10);

		DOB = new JTextField();
		DOB.setBounds(238, 257, 223, 22);
		getContentPane().add(DOB);
		DOB.setColumns(10);

		BirthPlace = new JTextField();
		BirthPlace.setBounds(237, 309, 224, 22);
		BirthPlace.setColumns(10);
		getContentPane().add(BirthPlace);

	}

	// REGISTER TO THE SYSTEM
	public Boolean RegisterData(String strName, String strSurname, String strCitizenshipNumber, String strDOB,
			String strBirthPlace) {

		// checks if user enters nothing
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

		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		try {

			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

			s = connect.createStatement();

			// SQL Insert
			String sql = "INSERT INTO registration " + "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace) "
					+ "VALUES ('" + strName + "','" + strSurname + "','" + strCitizenshipNumber + "'" + ",'" + strDOB
					+ "','" + strBirthPlace + "')";
			s.execute(sql);

			// Reset Text Fields
			Name.setText("");
			Surname.setText("");
			CitizenshipNumber.setText("");
			DOB.setText("");
			BirthPlace.setText("");

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