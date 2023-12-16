package course_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;

public class Login extends JFrame {
	
	private JFrame frame;
	private JTextField UserName;
	private JPasswordField Password;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	private Connection Connectors() {
	Connect c1 = new Connect();
	Connection x = c1.Connector();
	return x;
}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		Connection con = Connectors();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setLayout(null);
		
		frame=this;
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(259, 10, 74, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1.setBounds(150, 82, 98, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(150, 132, 98, 32);
		getContentPane().add(lblNewLabel_1_1);
		
		UserName = new JTextField();
		UserName.setBounds(293, 81, 166, 33);
		getContentPane().add(UserName);
		UserName.setColumns(10);
		
		Password = new JPasswordField();
		Password.setEchoChar('*');
		Password.setBounds(293, 135, 166, 33);
		getContentPane().add(Password);
		
		JLabel Error = new JLabel("");
		Error.setForeground(new Color(0, 0, 0));
		Error.setFont(new Font("Times New Roman", Font.BOLD, 19));
		Error.setBounds(171, 231, 308, 25);
		getContentPane().add(Error);
		
		JComboBox User = new JComboBox();
		User.setModel(new DefaultComboBoxModel(new String[] {"Select User", "Admin", "Teacher", "Student"}));
		User.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		User.setBounds(211, 185, 137, 25);
		getContentPane().add(User);
		
//		Login in the system
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var email = UserName.getText();
				var pass = new String(Password.getPassword());
				var user = (String)User.getSelectedItem();
				try {
					Statement st= con.createStatement();
					String get="SELECT Id,Email, Password, User FROM user WHERE Email ='"+email+"' AND Password ='"+pass+"' AND User ='"+user+"'";
					ResultSet rs=st.executeQuery(get);
					if(rs.next()) {
						String ID = rs.getString(1);
						if(user.equals("Admin")) {
							AdminGUI f1= new AdminGUI(ID);
							f1.show();		
							frame.dispose();
						}
						else if(user.equals("Teacher")) {
							TeacherGUI f2= new TeacherGUI(ID);
							f2.show();
							frame.dispose();
						}
						else if(user.equals("Student")) {
			                StudentGUI f3= new StudentGUI(ID);
			                f3.show();
			                frame.dispose();
			            }
					}
					else {
						throw new Incorrect();
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(225, 266, 123, 25);
		contentPane.add(btnNewButton);
		
//		Open SignUp frame
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp f4=new SignUp();
				f4.show();
				frame.dispose();
			}
		});
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignUp.setBackground(Color.GRAY);
		btnSignUp.setBounds(395, 30, 123, 25);
		contentPane.add(btnSignUp);
	
	}
}
