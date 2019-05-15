package CrimeFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EditingRecord extends JFrame {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_Name;
	private JTextField textField_Surname;
	private JTextField textField_CN;
	private JTextField textField_DOB;
	private JTextField textField_BP;
	private JTextField textField_Subject;
	private JTextField textField_Report;
	private JTextField textField_ReportID;

	String strName, strSurname, strCitizenshipNumber, strDOB, strBirthPlace, strSubject, strReport, strReportID;

	public void showTableData() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "");
			String sql = "SELECT * FROM registration";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditingRecord frame = new EditingRecord();
					frame.setTitle("Crime Record System");
					frame.setVisible(true);
					frame.setVisible(true);
					frame.showTableData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditingRecord() {

		showTableData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 533);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(1,50,67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(369, 60, 524, 341);
		contentPane.add(table);

		textField_Name = new JTextField();
		textField_Name.setBounds(145, 70, 130, 22);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Surname = new JTextField();
		textField_Surname.setColumns(10);
		textField_Surname.setBounds(145, 105, 130, 22);
		contentPane.add(textField_Surname);

		textField_CN = new JTextField();
		textField_CN.setColumns(10);
		textField_CN.setBounds(145, 140, 130, 22);
		contentPane.add(textField_CN);

		textField_DOB = new JTextField();
		textField_DOB.setColumns(10);
		textField_DOB.setBounds(145, 175, 130, 22);
		contentPane.add(textField_DOB);

		textField_BP = new JTextField();
		textField_BP.setColumns(10);
		textField_BP.setBounds(145, 210, 130, 22);
		contentPane.add(textField_BP);

		textField_Subject = new JTextField();
		textField_Subject.setColumns(10);
		textField_Subject.setBounds(145, 245, 130, 22);
		contentPane.add(textField_Subject);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(49, 72, 56, 16);
		contentPane.add(lblNewLabel);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(49, 107, 71, 16);
		contentPane.add(lblSurname);

		JLabel lblCitizenNo = new JLabel("Citizen No:");
		lblCitizenNo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCitizenNo.setForeground(Color.WHITE);
		lblCitizenNo.setBounds(49, 142, 71, 16);
		contentPane.add(lblCitizenNo);

		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setBounds(49, 177, 84, 16);
		contentPane.add(lblDateOfBirth);

		JLabel lblBirthPlace = new JLabel("Birth Place:");
		lblBirthPlace.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblBirthPlace.setForeground(Color.WHITE);
		lblBirthPlace.setBounds(49, 212, 71, 16);
		contentPane.add(lblBirthPlace);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setBounds(49, 247, 56, 16);
		contentPane.add(lblSubject);

		JLabel lblCrimeRecord = new JLabel("Criminal Record:");
		lblCrimeRecord.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCrimeRecord.setForeground(Color.WHITE);
		lblCrimeRecord.setBounds(31, 282, 116, 16);
		contentPane.add(lblCrimeRecord);

		JLabel lblNewLabel_1 = new JLabel("Report ID: ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(49, 317, 71, 16);
		contentPane.add(lblNewLabel_1);

		JButton button = new JButton("Insert");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO registration "
							+ "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace, Subject, CrimeReport,ReportID) "
							+ "VALUES (?,?,?,?,?,?,?,?)";
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
							"root", "");
					pst = con.prepareStatement(sql);
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
				showTableData();
			}

		});
		button.setBounds(12, 413, 97, 25);
		contentPane.add(button);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "UPDATE registration SET Name=?,Surname=?,CitizenshipNumber=?,DateofBirth=?,BirthPlace=?, Subject=?, CrimeReport=?, ReportID=? WHERE ReportID=?";
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
							"root", "");
					pst = con.prepareStatement(sql);
					pst.setString(1, textField_Name.getText());
					pst.setString(2, textField_Surname.getText());
					pst.setString(3, textField_CN.getText());
					pst.setString(4, textField_DOB.getText());
					pst.setString(5, textField_BP.getText());
					pst.setString(6, textField_Subject.getText());
					pst.setString(7, textField_Report.getText());
					pst.setString(8, textField_ReportID.getText());
					pst.executeUpdate();
					showTableData();
					JOptionPane.showMessageDialog(null, "Data has updated successfully");

				} catch (SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnUpdate.setBounds(145, 413, 97, 25);
		contentPane.add(btnUpdate);

		textField_Report = new JTextField();
		textField_Report.setColumns(10);
		textField_Report.setBounds(145, 280, 130, 22);
		contentPane.add(textField_Report);

		textField_ReportID = new JTextField();
		textField_ReportID.setBounds(145, 315, 130, 22);
		contentPane.add(textField_ReportID);
		textField_ReportID.setColumns(10);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//User can go back to User Dashboard page when he/she clicks on "Back" button 
				dispose();
				UserDashboard UserDash = new UserDashboard();
				UserDash.setVisible(true);
			}
		});
		btnNewButton.setBounds(855, 448, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("EDITING RECORD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblNewLabel_2.setBounds(213, 13, 524, 34);
		contentPane.add(lblNewLabel_2);

	}
}
