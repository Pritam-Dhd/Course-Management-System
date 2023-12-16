package course_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class EnrollCourse extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private ArrayList<String> courses = new ArrayList<>();
	private ArrayList<Integer> semester = new ArrayList<>();
	private ArrayList<String> module = new ArrayList<String>();
	private int i,sem;
	private String id;
	private String name,m2,m3,m4,m5;
	private Object mo1,mo2;
	private String cou;
	private String email;
	private JComboBox Semester5,Semester5_1;
	Connection con = Connectors();

	/**
	 * Create the frame.
	 */
	public EnrollCourse(String id) {
		frame=this;
		this.id=id;
//		Getting courses
		try {
			Statement st = con.createStatement();
			String data="SELECT course_name FROM course";
	    	ResultSet rs=st.executeQuery(data);
	    	while (rs.next()) {	 
	          courses.add(rs.getString("course_name"));          }
		}
		catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnroll = new JLabel("Enroll");
		lblEnroll.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblEnroll.setBounds(147, 33, 147, 34);
		contentPane.add(lblEnroll);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Course Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1.setBounds(39, 102, 219, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Semester:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(39, 217, 219, 42);
		contentPane.add(lblNewLabel_1_1);
		
//		choices of course
		JComboBox Course = new JComboBox();
		HashSet<String> courseSet = new HashSet<>(courses);
		String[] courseArray = courseSet.toArray(new String[0]);
		Arrays.sort(courseArray);
		String[] options = new String[courseArray.length + 1];
		options[0] = "Select course";
		System.arraycopy(courseArray, 0, options, 1, courseArray.length);
		Course.setModel(new DefaultComboBoxModel(options));
		Course.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Course.setBounds(39, 158, 267, 34);
		contentPane.add(Course);
//		choice of semester
		JComboBox Semester = new JComboBox();
		Semester.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Semester.setBounds(39, 268, 267, 34);
		contentPane.add(Semester);

		Course.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    cou = (String)Course.getSelectedItem();
		    try {
		      Statement st = con.createStatement();
		      String data="SELECT semester FROM module where course_name='"+cou+"'";
		      ResultSet rs=st.executeQuery(data);

		      DefaultComboBoxModel model = new DefaultComboBoxModel();
		      model.addElement("Select semester");
		      while (rs.next()) {
		    	  int semesterValue = rs.getInt("semester");
			      if (!semester.contains(semesterValue)) {
			          model.addElement(semesterValue);
			          semester.add(semesterValue);
			      }
		      }
		      Semester.setModel(model);
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		  }
		});
		Semester.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  sem = (int)Semester.getSelectedItem();
				  if(sem!=5&&sem!=6) {
					  try {
							Statement st = con.createStatement();
							String detail1="Select module_name FROM module where course_name='"+cou+"'AND semester='"+sem+"'";
						    ResultSet rs3=st.executeQuery(detail1);
						    module.clear();
						    while (rs3.next()) {
						    	module.add(rs3.getString("module_name"));
						    }
						  }
						  catch(SQLException e1) {
							  JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						  }
				  }
				  else if(sem==5) {
					  Semester5 = new JComboBox();
					  Semester5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					  Semester5.setBounds(39, 370, 115, 34);
					  contentPane.add(Semester5);
					  Semester5_1 = new JComboBox();
					  Semester5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					  Semester5_1.setBounds(192, 370, 115, 34);
					  contentPane.add(Semester5_1);
					  try {
							Statement st = con.createStatement();
							String detail1="Select module_name FROM module where course_name='"+cou+"'AND semester='"+sem+"'";
						    ResultSet rs3=st.executeQuery(detail1);
						    module.clear();
						    while (rs3.next()) {
						    	module.add(rs3.getString("module_name"));
						    }
						    m2=module.get(1);
						    m3=module.get(2);
						    m4=module.get(3);
						    m5=module.get(4);
						    Semester5.setModel(new DefaultComboBoxModel(new String[] {"Select module",m2,m3}));
						    Semester5_1.setModel(new DefaultComboBoxModel(new String[] {"Select module",m4,m5}));
						  }
						  catch(SQLException e1) {
							  JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						  }
				  }
				  else if(sem==6) {
					  Semester5 = new JComboBox();
					  Semester5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					  Semester5.setBounds(39, 370, 115, 34);
					  contentPane.add(Semester5);
					  Semester5_1 = new JComboBox();
					  Semester5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					  Semester5_1.setBounds(192, 370, 115, 34);
					  contentPane.add(Semester5_1);
					  try {
							Statement st = con.createStatement();
							String detail1="Select module_name FROM module where course_name='"+cou+"'AND semester='"+sem+"'";
						    ResultSet rs3=st.executeQuery(detail1);
						    module.clear();
						    while (rs3.next()) {
						    	module.add(rs3.getString("module_name"));
						    }
						    m2=module.get(1);
						    m3=module.get(2);
						    m4=module.get(3);
						    m5=module.get(4);
						    Semester5.setModel(new DefaultComboBoxModel(new String[] {"Select module",m2,m3}));
						    Semester5_1.setModel(new DefaultComboBoxModel(new String[] {"Select module",m4,m5}));
						  }
						  catch(SQLException e1) {
							  JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						  }
				  }
			  }
		});
//		Save the course
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cou = (String)Course.getSelectedItem();
				sem = (int)Semester.getSelectedItem();
				if(cou!=null&& cou!="Select semester") {
					try {
						Statement st = con.createStatement();
						String data="SELECT student_name FROM student where student_id='"+id+"'";
				    	ResultSet rs=st.executeQuery(data);
				    	if(rs.next()) {
				    		JOptionPane.showMessageDialog(null, "Alreagy enrolled (can only be enrolled in one course)", "Error", JOptionPane.ERROR_MESSAGE);
				    	}
				    	else {
				    		String detail="Select name,email FROM user where id='"+id+"'";
					    	ResultSet rs2=st.executeQuery(detail);
					    	while (rs2.next()) {
					    		name=rs2.getString("name");
					    		email=rs2.getString("email");
					        }
					    	if(sem!=5&&sem!=6) {
					    		String query1= "INSERT INTO student VALUES ('" + id + "','" + name + "','" 
										+ email + "','" + cou + "','" + module.get(0) + "','" + module.get(1)+ "','" 
					    				+ module.get(2) + "','" + module.get(3) + "','" + sem + "' )";
								st.executeUpdate(query1);
								JOptionPane.showMessageDialog(null,"Enrolled successfullt", "Success", JOptionPane.INFORMATION_MESSAGE);
								frame.dispose();
					    	}
					    	else {
					    		mo1=(String)Semester5.getSelectedItem();
					    		mo2=(String)Semester5_1.getSelectedItem();
					    		String query1= "INSERT INTO student VALUES ('" + id + "','" + name + "','" 
										+ email + "','" + cou + "','" + module.get(0) + "','" + mo1+ "','" 
					    				+ module.get(2) + "','" + mo2 + "','" + sem + "' )";
								st.executeUpdate(query1);
								JOptionPane.showMessageDialog(null,"Enrolled successfullt", "Success", JOptionPane.INFORMATION_MESSAGE);
								frame.dispose();
					    	}
				    	}
					}
					catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Select a course", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(230, 474, 123, 25);
		contentPane.add(btnNewButton);
		
//		Close the frame
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.setBounds(251, 23, 102, 26);
		contentPane.add(btnNewButton_1);

	}
//	Connecting database
	private Connection Connectors() {
		Connect c1 = new Connect();
		Connection x = c1.Connector();
		return x;
	}

}
