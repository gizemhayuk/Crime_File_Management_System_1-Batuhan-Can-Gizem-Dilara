package CrimeFile;

// this class for admin.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	boolean status = false;

	private JTextField textField_Name; // name textfield
	private JTextField textField_Surname; // surname textfield
	private JTextField textField_CN; // citizenshipNo textfield
	private JTextField textField_DOB; // date of birth textfield
	private JTextField textField_BP; // birth place textfield
	private JTextField textField_Subject; // subject textfield
	private JTextField textField_Report; // crime report textfield
	private JTextField textField_ReportID; // report id textfield

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
					frame.showTableData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONNECT TO DATABASE
	public Connection getConnection() throws SQLException {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "root");

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return con;
	}

	// shows the table
	public boolean showTableData() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "root");
			String sql = "SELECT * FROM registration";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			System.out.println(ex);

		}
		return true;

	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setTitle("Admin Page");

		showTableData();
		try {
			getConnection(); // for connecting to the database
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1, 50, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// creates Jtable.
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(291, 60, 455, 312);
		contentPane.add(table);
		textField_Name = new JTextField(); // name
		textField_Name.setBounds(120, 60, 116, 22);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Surname = new JTextField(); // surname
		textField_Surname.setColumns(10);
		textField_Surname.setBounds(120, 95, 116, 22);
		contentPane.add(textField_Surname);

		textField_CN = new JTextField(); // citizenship number
		textField_CN.setColumns(10);
		textField_CN.setBounds(120, 130, 116, 22);
		contentPane.add(textField_CN);

		textField_DOB = new JTextField(); // date of birth
		textField_DOB.setColumns(10);
		textField_DOB.setBounds(120, 165, 116, 22);
		contentPane.add(textField_DOB);

		textField_BP = new JTextField(); // birthplace
		textField_BP.setColumns(10);
		textField_BP.setBounds(120, 200, 116, 22);
		contentPane.add(textField_BP);

		textField_Subject = new JTextField(); // subject
		textField_Subject.setColumns(10);
		textField_Subject.setBounds(120, 235, 116, 22);
		contentPane.add(textField_Subject);

		JLabel lblNewLabel = new JLabel("Name:"); // name label
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(27, 60, 56, 16);
		contentPane.add(lblNewLabel);

		JLabel lblSurname = new JLabel("Surname:"); // surname label
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSurname.setBounds(27, 95, 71, 16);
		contentPane.add(lblSurname);

		JLabel lblCitizenNo = new JLabel("Citizen No:"); // citizenship number label
		lblCitizenNo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCitizenNo.setForeground(Color.WHITE);
		lblCitizenNo.setBounds(27, 130, 71, 16);
		contentPane.add(lblCitizenNo);

		JLabel lblDateOfBirth = new JLabel("Date of Birth:"); // date of birth label
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(27, 165, 84, 16);
		contentPane.add(lblDateOfBirth);

		JLabel lblBirthPlace = new JLabel("Birth Place:"); // birthplace label
		lblBirthPlace.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblBirthPlace.setForeground(Color.WHITE);
		lblBirthPlace.setBounds(27, 203, 71, 16);
		contentPane.add(lblBirthPlace);

		JLabel lblSubject = new JLabel("Subject:"); // subject label
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSubject.setBounds(27, 235, 56, 16);
		contentPane.add(lblSubject);

		JLabel lblCrimeRecord = new JLabel("Criminal Record:"); // criminal record label
		lblCrimeRecord.setForeground(Color.WHITE);
		lblCrimeRecord.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCrimeRecord.setBounds(12, 259, 116, 38);
		contentPane.add(lblCrimeRecord);

		JLabel lblNewLabel_1 = new JLabel("Report ID: "); // report id label
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(27, 302, 84, 20);
		contentPane.add(lblNewLabel_1);

		JButton button = new JButton("Insert"); // INSERTING PEOPLE TO THE DATABASE
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InsertCrimeReport(textField_Name.getText(), textField_Surname.getText(), textField_CN.getText(),
						textField_DOB.getText(), textField_BP.getText(), textField_Subject.getText(),
						textField_Report.getText(), textField_ReportID.getText())) {
					showTableData();
				}

			}

		});
		button.setBounds(12, 373, 97, 25);
		contentPane.add(button);

		JButton btnDelete = new JButton("Delete"); // delete button
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DeleteCrimeReport(textField_ReportID.getText())) {
					showTableData();
				}
				showTableData(); // shows table data
				textField_Name.setVisible(true);
				textField_Surname.setVisible(true);
				textField_CN.setVisible(true);
				textField_DOB.setVisible(true);
				textField_BP.setVisible(true);
				textField_Subject.setVisible(true);
				textField_Report.setVisible(true);
			}
		});
		btnDelete.setBounds(127, 373, 97, 25);
		contentPane.add(btnDelete);
		btnDelete.setVisible(false);

		textField_Report = new JTextField();
		textField_Report.setColumns(10);
		textField_Report.setBounds(120, 270, 116, 22);
		contentPane.add(textField_Report);

		textField_ReportID = new JTextField();
		textField_ReportID.setBounds(120, 300, 116, 22);
		contentPane.add(textField_ReportID);
		textField_ReportID.setColumns(10);

		JButton btnDeletion = new JButton("Deletion"); // during deletion, admin just enters report id of crime file.
		btnDeletion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeletion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_Name.setVisible(false);
				textField_Surname.setVisible(false);
				textField_CN.setVisible(false);
				textField_DOB.setVisible(false);
				textField_BP.setVisible(false);
				textField_Subject.setVisible(false);
				textField_Report.setVisible(false);
				btnDelete.setVisible(true);
			}
		});
		btnDeletion.setBounds(14, 417, 97, 25);
		contentPane.add(btnDeletion);

		JButton btnNewButton = new JButton("Back"); // back to the previous page
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// User can back to login page with "Back" button
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(674, 464, 97, 25);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("ADMIN PAGE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 28));
		lblNewLabel_2.setBounds(100, 9, 594, 38);
		contentPane.add(lblNewLabel_2);

	}

	// INSERT CRIME REPORT
	public Boolean InsertCrimeReport(String strName, String strSurname, String strCitizenshipNumber, String strDOB,
			String strBirthPlace, String strSubject, String strReport, String strReportID) {

		// checks if user enters nothing
		if (strName.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null, "Please Input (Username)");
			textField_Name.requestFocusInWindow();
			return false;
		}
		if (strSurname.equals("")) // Surname
		{
			JOptionPane.showMessageDialog(null, "Please Input (Surname)");
			textField_Surname.requestFocusInWindow();
			return false;
		}

		if (strCitizenshipNumber.equals("")) // Citizenship No
		{
			JOptionPane.showMessageDialog(null, "Please Input (Citizenship Number)");
			textField_CN.requestFocusInWindow();
			return false;
		}

		if (strDOB.equals("")) // Date of Birth
		{
			JOptionPane.showMessageDialog(null, "Please Input (Date of Birth)");
			textField_DOB.requestFocusInWindow();
			return false;
		}

		if (strBirthPlace.equals("")) // Birth Place
		{
			JOptionPane.showMessageDialog(null, "Please Input (Birth Place)");
			textField_BP.requestFocusInWindow();
			return false;
		}
		if (strSubject.equals("")) // Subject
		{
			JOptionPane.showMessageDialog(null, "Please Input (Subject)");
			textField_Subject.requestFocusInWindow();
			return false;
		}
		if (strReport.equals("")) // Crime Report
		{
			JOptionPane.showMessageDialog(null, "Please Input (Crime Report)");
			textField_Report.requestFocusInWindow();
			return false;
		}
		if (strReportID.equals("")) // Crime Report
		{
			JOptionPane.showMessageDialog(null, "Please Input (Crime Report ID)");
			textField_ReportID.requestFocusInWindow();
			return false;
		}
		try {

			// query for inserting data to the database
			String sql = "INSERT INTO registration "
					+ "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace, Subject, CrimeReport,ReportID) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "root");

			pst = con.prepareStatement(sql);
			// get variables and insert them into the database
			pst.setString(1, textField_Name.getText());
			pst.setString(2, textField_Surname.getText());
			pst.setString(3, textField_CN.getText());
			pst.setString(4, textField_DOB.getText());
			pst.setString(5, textField_BP.getText());
			pst.setString(6, textField_Subject.getText());
			pst.setString(7, textField_Report.getText());
			pst.setString(8, textField_ReportID.getText());

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "inserted successfully");

		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		status = true;
		return true;
	}

	// DELETE CRIME REPORT
	public Boolean DeleteCrimeReport(String strReportID) {

		if (strReportID.equals("")) // Crime Report
		{
			JOptionPane.showMessageDialog(null, "Please Input (Crime Report ID)");
			textField_ReportID.requestFocusInWindow();
			return false;
		} else {
			try {
				// query for deletion
				String sql = "DELETE FROM registration WHERE ReportID =?";
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
						"root", "root");
				pst = con.prepareStatement(sql);
				pst.setString(1, textField_ReportID.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "delete successfully");

			} catch (SQLException | HeadlessException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}

		status = true;
		return true;
	}

}
