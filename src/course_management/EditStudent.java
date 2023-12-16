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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class EditStudent extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField Email;
	private JTextField Id;
	private int sem;
	private ArrayList<String> courses = new ArrayList<>();
	private ArrayList<Integer> semester = new ArrayList<>();
	private ArrayList<String> module = new ArrayList<String>();
	private String cou,m2,m3,m4,m5;
	private JComboBox Semester5,Semester5_1;
	private Object mo1,mo2;
	/**
	 * Create the frame.
	 */
	public EditStudent() {
		Connection con = Connectors();
//		Gettind courses
		frame=this;
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
		setBounds(100, 100, 411, 390);
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
		
		JLabel lblAddCourse = new JLabel("Edit Student");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddCourse.setBounds(126, 26, 147, 34);
		contentPane.add(lblAddCourse);
		
		JLabel lblId = new JLabel("Name:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblId.setBounds(255, 70, 53, 14);
		contentPane.add(lblId);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Name.setColumns(10);
		Name.setBounds(255, 99, 96, 19);
		contentPane.add(Name);
		
		JLabel lblSem_2_3_1_1 = new JLabel("Semester:");
		lblSem_2_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3_1_1.setBounds(255, 136, 109, 24);
		contentPane.add(lblSem_2_3_1_1);
		
//		Choices of course
		JComboBox Course = new JComboBox();
		HashSet<String> courseSet = new HashSet<>(courses);
		String[] courseArray = courseSet.toArray(new String[0]);
		Arrays.sort(courseArray);
		String[] options = new String[courseArray.length + 1];
		options[0] = "Select course";
		System.arraycopy(courseArray, 0, options, 1, courseArray.length);
		Course.setModel(new DefaultComboBoxModel(options));
		Course.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Course.setBounds(23, 235, 96, 24);
		contentPane.add(Course);
		
//		Choices of Semester
		JComboBox Semester = new JComboBox();
		Semester.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Semester.setBounds(255, 168, 96, 19);
		contentPane.add(Semester);
//		Semesters related to Courses
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
			    } 
			    catch (SQLException e2) {
			    	JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
			  }
		});
//		Semester according to the choice
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
					    }						  }
					catch(SQLException e1) {
						  JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(sem==5) {					
					Semester5 = new JComboBox();
					Semester5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					Semester5.setBounds(255, 221, 96, 19);
					contentPane.add(Semester5);
					Semester5_1 = new JComboBox();
					Semester5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					Semester5_1.setBounds(255, 250, 96, 19);
					contentPane.add(Semester5_1);
					try {
						Statement st = con.createStatement();
						String detail1="Select module_name FROM module where course_name='"+cou+"'AND semester='"+sem+"'";
					    ResultSet rs3=st.executeQuery(detail1);
					    module.clear();
					    while (rs3.next()) {
					    	module.add(rs3.getString("module_name"));
					    }
					    m2=module.get(0);
					    m3=module.get(1);
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
					Semester5.setBounds(255, 221, 96, 19);
					contentPane.add(Semester5);
					Semester5_1 = new JComboBox();
					Semester5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					Semester5_1.setBounds(255, 250, 96, 19);
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
					    m3=module.get(5);
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
			
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var id=Id.getText(); var name=Name.getText();cou = (String)Course.getSelectedItem();
				var sem= (int)Semester.getSelectedItem();var email=Email.getText();
				int count=0;
				try {
					Statement st = con.createStatement();
					String data="SELECT student_name FROM student where student_id='"+id+"'";
			    	ResultSet rs=st.executeQuery(data);
			    	if(rs.next()) {
				    	if(sem!=5&&sem!=6) {
				    		String query1= "UPDATE student SET Student_name='" + name + "', email='"+ email +
				    				"', course_name='" + cou + "', module1_name='" + module.get(0) +
				    				"', module2_name='" + module.get(1)+ "', module3_name='"+ module.get(2) +
				    				"', module4_name='" + module.get(3) + "', semester='" + sem + "'where student_id='"+id+"'";
							st.executeUpdate(query1);
							JOptionPane.showMessageDialog(null,"Succesfully changed", "Success", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
				    	}
				    	else {
				    		mo1=(String)Semester5.getSelectedItem();
				    		mo2=(String)Semester5_1.getSelectedItem();
				    		String query1= "UPDATE student SET Student_name='" + name + "', email='"+ email +
				    				"', course_name='" + cou + "', module1_name='" + module.get(0) +
				    				"', module2_name='" + mo1+ "', module3_name='"+ module.get(2) +
				    				"', module4_name='" + mo2 + "', semester='" + sem + "'where student_id='"+id+"'";
							st.executeUpdate(query1);
							JOptionPane.showMessageDialog(null,"Succesfully changed", "Success", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
				    	}
			    		
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "Student Not Found", "Error", JOptionPane.ERROR_MESSAGE);
			    	}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setBounds(264, 318, 123, 25);
		contentPane.add(btnSave);
		
		JLabel lblSem_2_3_1_1_1 = new JLabel("Course:");
		lblSem_2_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3_1_1_1.setBounds(23, 205, 109, 24);
		contentPane.add(lblSem_2_3_1_1_1);
		
//		Close the frame
		JButton btnNewButton = new JButton("Close");
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
