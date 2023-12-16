package course_management;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField Address;
	private JTextField Email;
	private JPasswordField Password;
	private JTextField Id;

	public SignUp() {
		Connection con = Connectors();
		frame=this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 155, 148));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(241, 21, 70, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 84, 87, 25);
		contentPane.add(lblNewLabel_1);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Name.setBounds(38, 119, 96, 19);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address::");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(241, 84, 87, 25);
		contentPane.add(lblNewLabel_1_1);
		
		Address = new JTextField();
		Address.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Address.setColumns(10);
		Address.setBounds(241, 119, 96, 19);
		contentPane.add(Address);
//		Selecting user
		JComboBox User = new JComboBox();
		User.setModel(new DefaultComboBoxModel(new String[] {"Select User", "Admin", "Teacher", "Student"}));
		User.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		User.setBounds(38, 243, 137, 25);
		contentPane.add(User);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(38, 161, 87, 25);
		contentPane.add(lblNewLabel_1_2);
		
		Email = new JTextField();
		Email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Email.setColumns(10);
		Email.setBounds(38, 196, 96, 19);
		contentPane.add(Email);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(241, 161, 87, 25);
		contentPane.add(lblNewLabel_1_2_1);
//		Create a user
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var id=Id.getText();
				var name = Name.getText();
				var pass = new String(Password.getPassword());
				var user = (String)User.getSelectedItem();
				var email= Email.getText();
				var add= Address.getText();
				String pattern = "^np.{0,20}@heraldcollege.edu.np$";
				try {
					Pattern p = Pattern.compile(pattern);
			        Matcher m = p.matcher(email);
			        if(m.matches()) {
			        	Statement st= con.createStatement();
			        	String data="SELECT email FROM user WHERE email = '" + email + "'";
			        	ResultSet rs=st.executeQuery(data);
			        	if(rs.next()) {
			                //Email already exists
			                JOptionPane.showMessageDialog(null, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
			        	}
			        	else{
			        		if(id!=null&&name!=null&&pass!=null&&user!=null||add=="Admin"||add=="Teacher"||add=="Student") {
			        	
								String query="INSERT INTO user VALUES ('" + id + "','" + name + "', '" + add + "', '" + email + "', '" + pass + "', '" + user + "')";
								st.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Successfully Created", "Success", JOptionPane.INFORMATION_MESSAGE);
								Login f1= new Login();
								f1.show();
								frame.dispose();
				        	}
			        		else {
			        			JOptionPane.showMessageDialog(null, "Something is missing", "Error", JOptionPane.ERROR_MESSAGE);
			        		}
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
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCreate.setBackground(Color.GRAY);
		btnCreate.setBounds(236, 279, 123, 25);
		contentPane.add(btnCreate);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Password.setEchoChar('*');
		Password.setBounds(241, 196, 103, 19);
		contentPane.add(Password);
		
		JLabel lblNewLabel_1_3 = new JLabel("Id:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(429, 84, 87, 25);
		contentPane.add(lblNewLabel_1_3);
		
		Id = new JTextField();
		Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Id.setColumns(10);
		Id.setBounds(429, 119, 96, 19);
		contentPane.add(Id);
		
	}
//	Connecting database
	private Connection Connectors() {
	Connect c1 = new Connect();
	Connection x = c1.Connector();
	return x;
	}
}

