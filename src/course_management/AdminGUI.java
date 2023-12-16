package course_management;

import java.awt.EventQueue;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable CourseTable;
	private JTable StudentTable;
	private JTable TutorTable;
	private int TotalCourse=0,TotalTeacher=0,TotalStudent=0,a,sem;
	private ArrayList<Integer> mar = new ArrayList<>();
	private String id,n,sid,name;
	Connection con = Connectors();
	private JTable ReportTable;
	private JTextField ID;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminGUI(String id){
		this.id = id;
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 153, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(177, 10, 565, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(192, 192, 192));
		Dashboard.setBounds(0, 0, 360, 284);
		panel_1.add(Dashboard);
		Dashboard.setLayout(null);
		
		JPanel Courses = new JPanel();
		Courses.setBackground(new Color(192, 192, 192));
		panel_1.add(Courses, "name_27449030029700");
		Courses.setLayout(null);
//		Course table
		DefaultTableModel tableModel = new DefaultTableModel();
		CourseTable = new JTable(tableModel);
		CourseTable.setBackground(new Color(192, 192, 192));
		CourseTable.setBounds(10, 91, 340, 183);
		Courses.add(CourseTable);
		tableModel.addColumn("Course Id");
		tableModel.addColumn("Course Name");
		tableModel.addColumn("Years to complete");
//		getting no of student,teacher and courses
		try {
			Statement st = con.createStatement();
			String data1="SELECT course_id,course_name,years FROM course";
			String detail="Select name FROM user where id='"+id+"'";
			String detai2="Select instructor_name FROM instructor";
			String detai3="Select student_name FROM student";
	    	ResultSet rs2=st.executeQuery(detail);
	    	while (rs2.next()) {
	    		n=rs2.getString("name");
	        }
	    	ResultSet rs1=st.executeQuery(data1);
	    	while (rs1.next()) {
	            TotalCourse++;
	        }
	    	ResultSet rs3=st.executeQuery(detai2);
	    	while(rs3.next()) {
	    		TotalTeacher++;
	    	}
	    	ResultSet rs4=st.executeQuery(detai3);
	    	while(rs4.next()) {
	    		TotalStudent++;
	    	}
		} 
		catch (SQLException e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		JLabel Total_1 = new JLabel("Total Courses:"+TotalCourse);
		Total_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Total_1.setBounds(10, 96, 193, 129);
		Dashboard.add(Total_1);
		
		JLabel Total_1_1 = new JLabel("Total Instructor:"+TotalTeacher);
		Total_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Total_1_1.setBounds(282, 96, 216, 129);
		Dashboard.add(Total_1_1);
		
		JLabel lblTotalStudents = new JLabel("Total Students: "+TotalStudent);
		lblTotalStudents.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTotalStudents.setBounds(10, 235, 216, 129);
		Dashboard.add(lblTotalStudents);
		
		JLabel Total_1_2 = new JLabel("Welcome "+ n);
		Total_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Total_1_2.setBounds(10, 10, 193, 87);
		Dashboard.add(Total_1_2);
		
		JPanel Report = new JPanel();
		Report.setBackground(new Color(192, 192, 192));
		Report.setBounds(0, 0, 565, 418);
		panel_1.add(Report);
		Report.setLayout(null);
		
//		Student report table
		DefaultTableModel tableModel4 = new DefaultTableModel();
		ReportTable = new JTable(tableModel4);
		ReportTable.setBackground(new Color(255, 255, 255));
		ReportTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ReportTable.setBounds(10, 108, 545, 300);
		Report.add(ReportTable);
		tableModel4.addColumn("Student Id");
		tableModel4.addColumn("Student Name");
		tableModel4.addColumn("Semester");		
		tableModel4.addColumn("Report");
		ReportTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		ReportTable.getColumnModel().getColumn(1).setPreferredWidth(215);
		ReportTable.getColumnModel().getColumn(2).setPreferredWidth(110);
		ReportTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		JScrollPane scrollPane4 = new JScrollPane(ReportTable);
        scrollPane4.setBounds(10, 135, 545, 273);
        Report.add(scrollPane4);
        Report.remove(ReportTable);
        
        JLabel lblNewLabel_1_2 = new JLabel("Id");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(10, 79, 44, 26);
        Report.add(lblNewLabel_1_2);
        
        ID = new JTextField();
        ID.setColumns(10);
        ID.setBounds(50, 82, 93, 25);
        Report.add(ID);
        
//      To make report
        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sid=ID.getText();
        		try {
					Statement st = con.createStatement();
					String data="SELECT marks,student_name FROM marks where student_id='"+sid+"'";
					String dat="SELECT semester FROM student where student_id='"+sid+"'";
					ResultSet rs1=st.executeQuery(dat);
					while(rs1.next()) {
						sem=rs1.getInt("semester");
					}
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel4.setRowCount(0);
			    	if(rs.next()) {
			    		String dat2="SELECT student_name,marks FROM marks where student_id='"+sid+"'";
						ResultSet rs2=st.executeQuery(dat2);
			    		while (rs2.next()) {
							name=rs2.getString("student_name");
							mar.add(rs2.getInt("marks"));
							a++;
				        }
						if(a==4) {
							if(mar.get(0)>=40&&mar.get(1)>=40&&mar.get(2)>=40&&mar.get(3)>=40) {
								String query1= "INSERT INTO report VALUES ('" + sid + "','" + name + "','"+sem+"','You have Passed')";
								st.executeUpdate(query1);
								JOptionPane.showMessageDialog(null,"Successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								String query1= "INSERT INTO report VALUES ('" + sid + "','" + name + "','"+sem+"','You have Failed')";
								st.executeUpdate(query1);
								JOptionPane.showMessageDialog(null,"Successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "All the marks are not posted", "Error", JOptionPane.ERROR_MESSAGE);
						}
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "No marks added or incorrect Id", "Error", JOptionPane.ERROR_MESSAGE);
			    	}
				} 
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
        	}
        });
        btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnEnter.setBackground(Color.WHITE);
        btnEnter.setBounds(157, 79, 81, 26);
        Report.add(btnEnter);
        
        JLabel lblGenerateReport = new JLabel("Generate Report");
        lblGenerateReport.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblGenerateReport.setBackground(new Color(128, 128, 192));
        lblGenerateReport.setBounds(198, 21, 173, 38);
        Report.add(lblGenerateReport);
		
		JPanel Student = new JPanel();
		Student.setBackground(new Color(192, 192, 192));
		Student.setBounds(0, 0, 360, 284);
		panel_1.add(Student);
		Student.setLayout(null);
		
		JPanel Instructor = new JPanel();
		Instructor.setBackground(new Color(192, 192, 192));
		panel_1.add(Instructor, "name_4962504736000");
		Instructor.setLayout(null);
		
//		Open DeleteCourse frame
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse f2= new DeleteCourse();
				f2.show();
			}
		});
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 9));
		btnNewButton_1.setBounds(487, 56, 68, 25);
		Courses.add(btnNewButton_1);
		
        CourseTable.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(CourseTable);
        scrollPane.setBounds(10, 91, 545, 317);
        Courses.add(scrollPane);
        Courses.remove(CourseTable);
		
//      Student Table
        DefaultTableModel tableModel1 = new DefaultTableModel();
		StudentTable = new JTable(tableModel1);
		StudentTable.setBackground(new Color(192, 192, 192));
		StudentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		StudentTable.setBounds(10, 94, 340, 180);
		Student.add(StudentTable);
		tableModel1.addColumn("Student Id");
		tableModel1.addColumn("Student Name");
		tableModel1.addColumn("Email");
		tableModel1.addColumn("Course");
		tableModel1.addColumn("Module 1");
		tableModel1.addColumn("Module 2");
		tableModel1.addColumn("Module 3");
		tableModel1.addColumn("Module 4");
		tableModel1.addColumn("Semester");
		StudentTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		StudentTable.getColumnModel().getColumn(1).setPreferredWidth(250);
		StudentTable.getColumnModel().getColumn(2).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(3).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(4).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(5).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(6).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(7).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(8).setPreferredWidth(90);
		
		StudentTable.setModel(tableModel1);
		JScrollPane scrollPane1 = new JScrollPane(StudentTable);
        scrollPane1.setBounds(10, 91, 545, 317);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Student.add(scrollPane1);
        Student.remove(StudentTable);
        
//      Instuctor table
        DefaultTableModel tableModel2 = new DefaultTableModel();
        TutorTable = new JTable(tableModel2);
		TutorTable.setBackground(new Color(192, 192, 192));
		TutorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TutorTable.setBounds(10, 93, 340, 181);
		Instructor.add(TutorTable);
		tableModel2.addColumn("Id");
		tableModel2.addColumn("Name");
		tableModel2.addColumn("Email");
		tableModel2.addColumn("Module1");
		tableModel2.addColumn("Module2");
		tableModel2.addColumn("Module3");
		tableModel2.addColumn("Module4");
		TutorTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		TutorTable.getColumnModel().getColumn(1).setPreferredWidth(300);
		TutorTable.getColumnModel().getColumn(2).setPreferredWidth(400);
		TutorTable.getColumnModel().getColumn(3).setPreferredWidth(400);
		TutorTable.getColumnModel().getColumn(4).setPreferredWidth(400);
		TutorTable.getColumnModel().getColumn(5).setPreferredWidth(400);
		TutorTable.getColumnModel().getColumn(6).setPreferredWidth(400);
		TutorTable.setModel(tableModel2);
		JScrollPane scrollPane2 = new JScrollPane(TutorTable);
		TutorTable.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		scrollPane2.setBounds(8, 91, 547, 317);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Instructor.add(scrollPane2);
		Instructor.remove(TutorTable);
        
//		Open AddInstructor frame
        JButton btnNewButton_1_1_2_1 = new JButton("Add ");
        btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddInstructor f2= new AddInstructor();
				f2.show();
        	}
        });
        btnNewButton_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
        btnNewButton_1_1_2_1.setBounds(338, 56, 61, 25);
        Instructor.add(btnNewButton_1_1_2_1);
        
//      Open DeleteInstructor Frame
        JButton btnNewButton_1_2_1 = new JButton("Delete ");
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DeleteInstructor f2= new DeleteInstructor();
				f2.show();
        	}
        });
        btnNewButton_1_2_1.setFont(new Font("Tw Cen MT", Font.BOLD, 9));
        btnNewButton_1_2_1.setBounds(480, 56, 75, 25);
        Instructor.add(btnNewButton_1_2_1);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("Edit ");
        btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditInstructor f2= new EditInstructor();
				f2.show();
        	}
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
        btnNewButton_1_1_1_1_1.setBounds(409, 56, 61, 25);
        Instructor.add(btnNewButton_1_1_1_1_1);
        
        JButton btnNewButton_1_1_2 = new JButton("Result");
        btnNewButton_1_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ShowResult f2= new ShowResult();
				f2.show();
        	}
        });
        btnNewButton_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 9));
        btnNewButton_1_1_2.setBounds(338, 56, 61, 25);
        Student.add(btnNewButton_1_1_2);
        
//        Open DeleteStudent Frame
        JButton btnNewButton_1_2 = new JButton("Delete ");
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DeleteStudent f2= new DeleteStudent();
				f2.show();
        	}
        });
        btnNewButton_1_2.setFont(new Font("Tw Cen MT", Font.BOLD, 9));
        btnNewButton_1_2.setBounds(480, 56, 75, 25);
        Student.add(btnNewButton_1_2);
        
//        Open EditStudent frame
        JButton btnNewButton_1_1_1_1 = new JButton("Edit ");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditStudent f2= new EditStudent();
				f2.show();
        	}
        });
        btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
        btnNewButton_1_1_1_1.setBounds(409, 56, 61, 25);
        Student.add(btnNewButton_1_1_1_1);
    	
//        Open AddCourse frame
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse f2= new AddCourse();
				f2.show();
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnNewButton_1_1.setBounds(351, 55, 58, 27);
		Courses.add(btnNewButton_1_1);
		
		JLabel Total = new JLabel("");
		Total.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Total.setBounds(10, 10, 237, 44);
		Courses.add(Total);
		
//		Open EditCourse Frame
		JButton btnNewButton_1_1_1 = new JButton("Edit");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourse f2= new EditCourse();
				f2.show();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
		btnNewButton_1_1_1.setBounds(419, 56, 58, 25);
		Courses.add(btnNewButton_1_1_1);
		
//		Open courses panel
		JButton btnNewButton = new JButton("Courses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Courses);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT course_id,course_name,years FROM course";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel.setRowCount(0);
					while (rs.next()) {
			            tableModel.addRow(new Object[]{rs.getString("course_id"), rs.getString("course_name"), rs.getString("years")});    
			        }
				} 
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(10, 89, 133, 35);
		panel.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login f2;
				try {
					f2 = new Login();
					f2.show();
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogOut.setBounds(10, 343, 133, 35);
		panel.add(btnLogOut);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Student);
				panel_1.repaint();
				panel_1.revalidate();	
				try {
					Statement st = con.createStatement();
					String data="SELECT student_id,student_name,email,course_name,module1_name,module2_name,module3_name,module4_name,semester FROM student";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel1.setRowCount(0);
					while (rs.next()) {
			            tableModel1.addRow(new Object[]{rs.getString("student_id"),rs.getString("student_name"),
			            		rs.getString("email"),rs.getString("course_name"),rs.getString("module1_name"),
			            		rs.getString("module2_name"),rs.getString("module3_name"),rs.getString("module4_name"),
			            		rs.getInt("semester")});    
			        }
				}
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStudent.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStudent.setBounds(10, 209, 133, 35);
		panel.add(btnStudent);
		
//		Open report panel
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Report);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT student_id,student_name,semester,result FROM report";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel4.setRowCount(0);
					while (rs.next()) {
			            tableModel4.addRow(new Object[]{rs.getString("student_id"),rs.getString("student_name"),
			            		rs.getInt("semester"),rs.getString("result")});   
			        }
				}
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnReport.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReport.setBounds(10, 276, 133, 35);
		panel.add(btnReport);
		
//		Open Dashboard panel
		JButton btnBack = new JButton("Dashboard");
		btnBack.setBounds(10, 28, 133, 35);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Dashboard);
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		Open instructor panel
		JButton btnT = new JButton("Instructor");
		btnT.setBounds(10, 150, 133, 35);
		panel.add(btnT);
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Instructor);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT instructor_id,instructor_name,email,module1,module2,module3,module4 FROM instructor";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel2.setRowCount(0);
					while (rs.next()) {
			            tableModel2.addRow(new Object[]{rs.getString("instructor_id"),rs.getString("instructor_name"),
			            		rs.getString("email"),rs.getString("module1"),rs.getString("module2"),
			            		rs.getString("module3"),rs.getString("module4")});    
			        }
				}
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnT.setFont(new Font("Times New Roman", Font.BOLD, 14));
	}
//	Connect Database
	private Connection Connectors() {
	Connect c1 = new Connect();
	Connection x = c1.Connector();
	return x;
	}
}
