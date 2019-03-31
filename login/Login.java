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
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.JTextPane;

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
		setBounds(100, 100, 815, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(1,50,67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Password = new JPasswordField();
		Password.setToolTipText("");
		Password.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Password.setForeground(Color.WHITE);
		Password.setBounds(449, 259, 310, 38);
		Password.setBackground((new Color(1,50,67)));
		contentPane.add(Password);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(449, 210, 120, 35);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblPassword);

		JLabel lblId = new JLabel("Personal Identification Number ");
		lblId.setBounds(449, 121, 279, 16);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(lblId);

		ID = new JTextField();
		ID.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		ID.setForeground(Color.WHITE);
		ID.setBounds(449, 159, 311, 38);
		ID.setBackground((new Color(1,50,67)));
		contentPane.add(ID);
		ID.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(1,50,67));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(449, 340, 134, 38);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
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
					if (getConnection(user, pwd)) {
						JOptionPane.showMessageDialog(null, "Successful");
					}else 
						JOptionPane.showMessageDialog(null, "Try Again!");

				}

			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(1,50,67));
		btnNewButton_1.setBounds(625, 340, 134, 38);
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contentPane.add(btnNewButton_1);
		
		lblL = new JLabel("GENERAL DIRECTORATE OF SECURITY");
		lblL.setBackground(new Color(128, 128, 128));
		lblL.setBounds(392, 24, 419, 47);
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		lblL.setForeground(new Color(255, 255, 255));
		contentPane.add(lblL);
		
		lblCrmeRecordSystem = new JLabel("CRIME RECORD SYSTEM");
		lblCrmeRecordSystem.setBounds(501, 73, 209, 22);
		lblCrmeRecordSystem.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCrmeRecordSystem.setForeground(new Color(255, 255, 255));
		contentPane.add(lblCrmeRecordSystem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(761, 198, -316, -1);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(228,241,254));
		panel.setBounds(0, 0, 383, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(169, 169, 169));
		lblNewLabel.setBounds(-67, 33, 473, 400);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\batuh\\Desktop\\Klas\u00F6rler\\workspace\\SE318-Crime File\\src\\images\\badge-drawing-police-officer-9.png"));
		panel.add(lblNewLabel);
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
