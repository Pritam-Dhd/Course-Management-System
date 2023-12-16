package course_management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditInstructor extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField Email;
	private JLabel lblSem_2_2;
	private JLabel lblSem_2_3;
	private JTextField Id;
	private JTextField M3N;
	private JTextField M4N;
	private JTextField M1N;
	private JTextField M2N;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public EditInstructor() {
		Connection con = Connectors();
		frame=this;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 65, 53, 24);
		contentPane.add(lblNewLabel);
		
		Id = new JTextField();
		Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Id.setColumns(10);
		Id.setBounds(23, 99, 96, 19);
		contentPane.add(Id);
		
		JLabel lblSem = new JLabel("Email:");
		lblSem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem.setBounds(23, 136, 53, 24);
		contentPane.add(lblSem);
		
		Email = new JTextField();
		Email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Email.setColumns(10);
		Email.setBounds(23, 169, 96, 19);
		contentPane.add(Email);
		
		JLabel lblAddCourse = new JLabel("Edit Instructor");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddCourse.setBounds(126, 26, 147, 34);
		contentPane.add(lblAddCourse);
		
		lblSem_2_2 = new JLabel("Module 1 Name:");
		lblSem_2_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_2.setBounds(23, 209, 109, 24);
		contentPane.add(lblSem_2_2);
		
		lblSem_2_3 = new JLabel("Module 2 Name:");
		lblSem_2_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3.setBounds(23, 284, 109, 24);
		contentPane.add(lblSem_2_3);
		
		JLabel lblId = new JLabel("Name:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblId.setBounds(255, 70, 53, 14);
		contentPane.add(lblId);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Name.setColumns(10);
		Name.setBounds(255, 99, 96, 19);
		contentPane.add(Name);
		
		JLabel lblSem_2_3_1 = new JLabel("Module 3 Name:");
		lblSem_2_3_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3_1.setBounds(255, 142, 109, 24);
		contentPane.add(lblSem_2_3_1);
		
		JLabel lblSem_2_3_1_1 = new JLabel("Module 4 Name:");
		lblSem_2_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3_1_1.setBounds(255, 215, 109, 24);
		contentPane.add(lblSem_2_3_1_1);
		
		M3N = new JTextField();
		M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		M3N.setColumns(10);
		M3N.setBounds(255, 169, 96, 19);
		contentPane.add(M3N);
		
		M4N = new JTextField();
		M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		M4N.setColumns(10);
		M4N.setBounds(255, 243, 96, 19);
		contentPane.add(M4N);
		
		M1N = new JTextField();
		M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		M1N.setColumns(10);
		M1N.setBounds(23, 243, 96, 19);
		contentPane.add(M1N);
		
		M2N = new JTextField();
		M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		M2N.setColumns(10);
		M2N.setBounds(23, 318, 96, 19);
		contentPane.add(M2N);
		
//		Edit Instructor
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var id=Id.getText(); var name=Name.getText();var m1n=M1N.getText();var m2n=M2N.getText();
				var m3n=M3N.getText();var m4n=M4N.getText();var email=Email.getText();
				int count=0;
				try {
					if(id!=null&&name!=null&&m1n!=null&&m2n!=null&&m3n!=null&&m4n!=null&&email!=null){
						Statement st= con.createStatement();
						String data="SELECT instructor_id FROM instructor WHERE instructor_id = '" + id + "'";
			        	ResultSet rs=st.executeQuery(data);
			        	if(rs.next()) {
							String que1="SELECT module_name from module where module_name='"+m1n+"' OR "
			        				+ "module_name='"+m2n+"' OR module_name='"+m3n+"' OR module_name='"+m4n+"'";
			        		ResultSet r1=st.executeQuery(que1);
			        		while(r1.next()) {
			        			count++;
			        		}
			        		if(count==4) {
								String query1= "Update instructor set Instructor_name='"+ name +"',"
										+ "email='"+ email + "',module1='" + m1n + "',module2='" + m2n + "',"
										+ "module3='" + m3n + "',module4='" + m4n + "' WHERE instructor_id='"+id+"'";
								st.executeUpdate(query1);
								JOptionPane.showMessageDialog(null, "Successfully edited", "Success", JOptionPane.INFORMATION_MESSAGE);
								frame.dispose();
			        		}
			        		else {
			        			JOptionPane.showMessageDialog(null, "There is wrong module", "Error", JOptionPane.ERROR_MESSAGE);
			        		}
			        	}
			        	else {
			        		JOptionPane.showMessageDialog(null, "Course doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			        	}
					}
					else {
						JOptionPane.showMessageDialog(null, "Something is missing", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setBounds(264, 375, 123, 25);
		contentPane.add(btnSave);
		
//		Close the frame
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 128, 128));
		btnNewButton.setBounds(283, 21, 102, 26);
		contentPane.add(btnNewButton);
		
	}
//	Connecting database
	private Connection Connectors() {
		Connect c1 = new Connect();
		Connection x = c1.Connector();
		return x;
	}

}
