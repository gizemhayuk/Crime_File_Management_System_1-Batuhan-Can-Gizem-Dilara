package CrimeFile;

import java.awt.BorderLayout;
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

public class EditingRecord extends JFrame {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	String strName, strSurname, strCitizenshipNumber, strDOB, strBirthPlace, strSubject, strReport;
	private JTextField textField_6;
	private JTextField textField_7;

	public void showTableData() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","root");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(397, 36, 496, 312);
		contentPane.add(table);

		textField = new JTextField();
		textField.setBounds(108, 72, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 107, 116, 22);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 142, 116, 22);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 177, 116, 22);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(108, 212, 116, 22);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(108, 247, 116, 22);
		contentPane.add(textField_5);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(27, 75, 56, 16);
		contentPane.add(lblNewLabel);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(12, 110, 71, 16);
		contentPane.add(lblSurname);

		JLabel lblCitizenNo = new JLabel("Citizen No:");
		lblCitizenNo.setBounds(12, 145, 71, 16);
		contentPane.add(lblCitizenNo);

		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(12, 180, 84, 16);
		contentPane.add(lblDateOfBirth);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(25, 215, 71, 16);
		contentPane.add(lblBirthPlace);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(27, 250, 56, 16);
		contentPane.add(lblSubject);

		JLabel lblCrimeRecord = new JLabel("Criminal Record:");
		lblCrimeRecord.setBounds(0, 294, 116, 16);
		contentPane.add(lblCrimeRecord);
		
		JLabel lblNewLabel_1 = new JLabel("ReportID: ");
		lblNewLabel_1.setBounds(12, 332, 56, 16);
		contentPane.add(lblNewLabel_1);

		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO registration "
							+ "(Name,Surname,CitizenshipNumber,DateofBirth,BirthPlace, Subject, CrimeReport,ReportID) "
							+ "VALUES (?,?,?,?,?,?,?,?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "root");
					pst = con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					
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
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "UPDATE registration SET Name=?,Surname=?,CitizenshipNumber=?,DateofBirth=?,BirthPlace=?, Subject=?, CrimeReport=?, ReportID=? WHERE ReportID=?";
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/new_record?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","root");
					pst = con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					pst.setString(9, textField_7.getText());
					pst.executeUpdate();
					showTableData();
					JOptionPane.showMessageDialog(null, "updated successfully");

				} catch (SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		btnUpdate.setBounds(145, 413, 97, 25);
		contentPane.add(btnUpdate);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(108, 291, 197, 22);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(108, 326, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		
	}
}