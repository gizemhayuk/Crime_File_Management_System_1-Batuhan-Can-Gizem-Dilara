package CrimeFile;

import java.awt.*;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//this class is for users. User can add new crime record to the system.

public class CriminalRecord extends JFrame {

	
	private JTextField Name, Surname, CitizenshipNumber, DOB, BirthPlace, subject,crimeReport;


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
		newRecord.setBounds(153, 25, 289, 20);
		newRecord.setForeground(new Color(255, 255, 255));
		newRecord.setFont(new Font("Century Gothic", Font.BOLD, 20));
		newRecord.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(newRecord);

		JLabel newName = new JLabel("Name:");
		newName.setBounds(62, 72, 289, 14);
		newName.setForeground(new Color(255, 255, 255));
		newName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().add(newName);

		JLabel newSurname = new JLabel("Surname:");
		newSurname.setBounds(62, 105, 289, 21);
		newSurname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newSurname.setForeground(new Color(255, 255, 255));
		getContentPane().add(newSurname);

		JLabel newCitizenshipNumber = new JLabel("Citizenship Number:\r\n");
		newCitizenshipNumber.setBounds(61, 148, 290, 20);
		newCitizenshipNumber.setForeground(new Color(255, 255, 255));
		newCitizenshipNumber.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		getContentPane().add(newCitizenshipNumber);

		JLabel newDOB = new JLabel("Date Of Birth:\r\n");
		newDOB.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newDOB.setBounds(62, 190, 289, 23);
		newDOB.setForeground(new Color(255, 255, 255));
		getContentPane().add(newDOB);

		JLabel newBirthPlace = new JLabel("Birth Place:");
		newBirthPlace.setBounds(62, 242, 114, 22);
		newBirthPlace.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		newBirthPlace.setForeground(new Color(255, 255, 255));
		getContentPane().add(newBirthPlace);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblSubject.setBounds(62, 289, 114, 22);
		getContentPane().add(lblSubject);
		
		
		JLabel lblCrimeReport = new JLabel("Crime Report:");
		lblCrimeReport.setForeground(Color.WHITE);
		lblCrimeReport.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCrimeReport.setBounds(62, 350, 114, 22);
		getContentPane().add(lblCrimeReport);
		

		Name = new JTextField();
		Name.setBounds(238, 70, 223, 22);
		Name.setColumns(10);
		getContentPane().add(Name);

		Surname = new JTextField();
		Surname.setBounds(238, 106, 223, 22);
		getContentPane().add(Surname);
		Surname.setColumns(10);

		CitizenshipNumber = new JTextField();
		CitizenshipNumber.setBounds(238, 149, 223, 22);
		getContentPane().add(CitizenshipNumber);
		CitizenshipNumber.setColumns(10);

		DOB = new JTextField();
		DOB.setBounds(238, 192, 223, 22);
		getContentPane().add(DOB);
		DOB.setColumns(10);

		BirthPlace = new JTextField();
		BirthPlace.setBounds(237, 244, 224, 22);
		BirthPlace.setColumns(10);
		getContentPane().add(BirthPlace);
		
	
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(237, 291, 224, 22);
		getContentPane().add(subject);
		
	
		crimeReport = new JTextField();
		crimeReport.setColumns(10);
		crimeReport.setBounds(234, 350, 354, 183);
		getContentPane().add(crimeReport);

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(488, 546, 100, 34);
		
		//if save button is clicked, then people are registered into the system & database.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (RegisterData(Name.getText(), Surname.getText(), CitizenshipNumber.getText(), DOB.getText(), 
						BirthPlace.getText(), subject.getText(),crimeReport.getText())) {
					UserDashboard user = new UserDashboard();
					user.setVisible(true);
				
				}
			}
		});
		getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				UserDashboard UserDash = new UserDashboard();
				UserDash.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(36, 546, 100, 34);
		getContentPane().add(btnBack);


	}

	// REGISTERING TO THE SYSTEM
	public Boolean RegisterData(String strName, String strSurname, String strCitizenshipNumber, String strDOB,
			String strBirthPlace, String strSubject, String strReport) {

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
		if (strSubject.equals("")) // Subject
		{
			JOptionPane.showMessageDialog(null, "Please Input (Subject)");
			subject.requestFocusInWindow();
			return false;
		}
		if (strReport.equals("")) // Crime Report
		{
			JOptionPane.showMessageDialog(null, "Please Input (Crime Report)");
			crimeReport.requestFocusInWindow();
			return false;
		}
		
		
		

		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		try {
			//database connection
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");

			s = connect.createStatement();

			// SQL Insert
			String sql = "INSERT INTO registration " + "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace, subject, crimeReport) "
					+ "VALUES ('" + strName + "','" + strSurname + "','" + strCitizenshipNumber + "'" + ",'" + strDOB
					+ "','" + strBirthPlace + "','" + strSubject + "','" + strReport +  "')";
			s.execute(sql);

			// Reset Text Fields
			Name.setText("");
			Surname.setText("");
			CitizenshipNumber.setText("");
			DOB.setText("");
			BirthPlace.setText("");
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