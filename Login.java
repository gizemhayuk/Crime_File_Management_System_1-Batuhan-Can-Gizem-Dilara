package CrimeFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField Password;
	private JTextField ID;
	private JLabel lblL;
	private JLabel lblCrmeRecordSystem;

	
	 // Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 //Create the frame.
	 
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 49, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Password = new JPasswordField();
		Password.setBackground(Color.GRAY);
		Password.setBounds(128, 142, 274, 22);
		contentPane.add(Password);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPassword.setBounds(34, 134, 120, 35);
		contentPane.add(lblPassword);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(96, 111, 56, 16);
		contentPane.add(lblId);

		ID = new JTextField();
		ID.setBackground(Color.GRAY);
		ID.setBounds(128, 109, 274, 22);
		contentPane.add(ID);
		ID.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ID.getText().length() == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else if (Password.getPassword().length == 0) // Checking for empty field
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else {
					String user = ID.getText(); // Collecting the input
					char[] pass = Password.getPassword(); // Collecting the input
					String pwd = String.copyValueOf(pass); // converting from array to string
					if (getConnection(user, pwd))
						JOptionPane.showMessageDialog(null, "Successful");
					else
						JOptionPane.showMessageDialog(null, "Try Again!");
				}

			}
		});
		btnNewButton.setBounds(128, 177, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(233, 177, 97, 25);
		contentPane.add(btnNewButton_1);
		
		lblL = new JLabel("GENERAL DIRECTORATE OF SECURITY");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblL.setForeground(new Color(255, 255, 255));
		lblL.setBounds(24, 13, 408, 47);
		contentPane.add(lblL);
		
		lblCrmeRecordSystem = new JLabel("CRIME RECORD SYSTEM");
		lblCrmeRecordSystem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCrmeRecordSystem.setForeground(new Color(255, 255, 255));
		lblCrmeRecordSystem.setBounds(139, 54, 176, 22);
		contentPane.add(lblCrmeRecordSystem);
	}

	private boolean getConnection(String username,String password) {
		   try{           
		       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
		       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/se318" + "user=root&password=123456");     
		       PreparedStatement pst = conn.prepareStatement("Select * from se318 where username=? and password=?");
		       pst.setString(1, username); 
		       pst.setString(2, password);
		       ResultSet rs = pst.executeQuery();                        
		       if(rs.next())            
		           return true;    
		       else
		           return false;            
		   }
		   catch(Exception e){
		       e.printStackTrace();
		       return false;
		   }       
		} 
}
