package course_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.List;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class TeacherGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable ModuleTable;
	private JTable StudentTable;
	private JTextField StdId;
	private JTextField Marks;
	private JTable ResultTable;
	private ArrayList<String> Mod = new ArrayList<String>();
	Connection con = Connectors();
	private String id,c,n,m1,m2,m3,m4,sm1,sm2,sm3,sm4,sid,mod,grade,name,s1,s2,s3,s4;
	private int tn=0,ts=0,mark;

	/**
	 * Create the frame.
	 */
	public TeacherGUI(String id) {
		this.id=id;
		frame = this;
//		get no of modules and students
		try {
			Statement st = con.createStatement();
			String detail="Select name FROM user where id='"+id+"'";
	    	ResultSet rs2=st.executeQuery(detail);
	    	while (rs2.next()) {
	    		n=rs2.getString("name");
	        }
	    	String data2="SELECT module1,module2,module3,module4 FROM instructor where instructor_id='"+id+"'";
	    	ResultSet rs3=st.executeQuery(data2);
	    	while (rs3.next()) {
	    		m1=rs3.getString("module1");
	    		m2=rs3.getString("module2");
	    		m3=rs3.getString("module3");
	    		m4=rs3.getString("module4");
	            tn=4;
	        }
	    	String detai3="SELECT student_name FROM student WHERE module1_name='" + m1 + "' OR module1_name='" + m2 
	    			+ "' OR module1_name='" + m3 + "' OR module1_name='" + m4 + "' OR module2_name='" + m1 
	    			+ "' OR module2_name='" + m2 + "' OR module2_name='" + m3 + "' OR module2_name='" + m4 
	    			+ "' OR module3_name='" + m1 + "' OR module3_name='" + m2 + "' OR module3_name='" + m3 
	    			+ "' OR module3_name='" + m4 + "' OR module4_name='" + m1 + "' OR module4_name='" + m2 
	    			+ "' OR module4_name='" + m3 + "' OR module4_name='" + m4 + "';";
	    	ResultSet rs4=st.executeQuery(detai3);
	    	while(rs4.next()) {
	    		ts++;
	    	}
	    	String data="SELECT module1,module2,module3,module4 FROM instructor where instructor_id='"+id+"'";
	    	ResultSet rs=st.executeQuery(data);
	    	while (rs.next()) {	 
	          Mod.add(rs.getString("module1"));
	          Mod.add(rs.getString("module2"));
	          Mod.add(rs.getString("module3"));
	          Mod.add(rs.getString("module4"));
	    	}
		}
		catch (SQLException e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 142, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(162, 10, 582, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(192, 192, 192));
		panel_1.add(Dashboard, "name_162531318543900");
		Dashboard.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Modules: "+tn);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 127, 193, 140);
		Dashboard.add(lblNewLabel_2);
		
		JLabel lblTotalStudents = new JLabel("Total Students: "+ts);
		lblTotalStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalStudents.setBounds(10, 255, 193, 140);
		Dashboard.add(lblTotalStudents);
		
		JLabel Total_1_2 = new JLabel("Welcome "+n);
		Total_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Total_1_2.setBounds(10, 42, 371, 87);
		Dashboard.add(Total_1_2);
		
		JPanel modules = new JPanel();
		modules.setBackground(new Color(192, 192, 192));
		panel_1.add(modules, "name_162531386247600");
		modules.setLayout(null);
//		Module table
		DefaultTableModel tableModel = new DefaultTableModel();
		ModuleTable = new JTable(tableModel);
		ModuleTable.setBounds(10, 104, 562, 304);
		modules.add(ModuleTable);
		tableModel.addColumn("Module Id");
		tableModel.addColumn("Module Name");
        ModuleTable.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(ModuleTable);
        scrollPane.setBounds(10, 91, 545, 317);
        modules.add(scrollPane);
        modules.remove(ModuleTable);
        
        JLabel lblNewLabel_4 = new JLabel("Modules");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 21));
        lblNewLabel_4.setBounds(222, 23, 169, 47);
        modules.add(lblNewLabel_4);
		
		JPanel Student = new JPanel();
		Student.setBackground(new Color(192, 192, 192));
		Student.setBounds(0, 0, 347, 286);
		panel_1.add(Student);
		Student.setLayout(null);
//		Student table
		DefaultTableModel tableModel1 = new DefaultTableModel();
		StudentTable = new JTable(tableModel1);
		StudentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		StudentTable.setBounds(10, 98, 562, 310);
		Student.add(StudentTable);
		tableModel1.addColumn("Id");
		tableModel1.addColumn("Name");
		tableModel1.addColumn("Email");
		tableModel1.addColumn("Module");
		StudentTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		StudentTable.getColumnModel().getColumn(1).setPreferredWidth(250);
		StudentTable.getColumnModel().getColumn(2).setPreferredWidth(350);
		StudentTable.getColumnModel().getColumn(3).setPreferredWidth(350);
		JScrollPane scrollPane1 = new JScrollPane(StudentTable);
        scrollPane1.setBounds(10, 91, 545, 317);
        Student.add(scrollPane1);
        Student.remove(StudentTable);
        
        JLabel lblNewLabel = new JLabel("Student");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        lblNewLabel.setBounds(230, 20, 169, 47);
        Student.add(lblNewLabel);
		
//		open module panel
		JButton module = new JButton("Modules");
		module.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(modules);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT module1,module2,module3,module4 FROM instructor where instructor_id='"+id+"'";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel.setRowCount(0);
					while (rs.next()) {
						m1=rs.getString("module1");
				    	m2=rs.getString("module2");
				    	m3=rs.getString("module3");
				    	m4=rs.getString("module4");				    	
					}
					String data1="SELECT module_id,module_name FROM module where module_name='"+m1+"'OR module_name='"+m2+"'"
						+ "OR module_name='"+m3+"'OR module_name='"+m4+"' ";
						ResultSet rs1=st.executeQuery(data1);
						while(rs1.next()) {
							tableModel.addRow(new Object[]{rs1.getString("module_id"),rs1.getString("module_name") });
						}    
			    }
				
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		module.setFont(new Font("Times New Roman", Font.BOLD, 15));
		module.setBounds(10, 119, 122, 33);
		panel.add(module);
//		logout and open login frame
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login f2;
				try {
					f2 = new Login();
					f2.show();
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		logout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		logout.setBounds(10, 330, 122, 33);
		panel.add(logout);
		
		JPanel Result = new JPanel();
		Result.setBackground(new Color(192, 192, 192));
		Result.setBounds(0, 0, 347, 286);
		panel_1.add(Result);
		Result.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(235, 22, 103, 30);
		Result.add(lblNewLabel_1);
		
		JLabel lblStudentName = new JLabel("Student Id:");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStudentName.setBounds(31, 64, 95, 24);
		Result.add(lblStudentName);
		
		StdId = new JTextField();
		StdId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		StdId.setColumns(10);
		StdId.setBounds(136, 68, 96, 19);
		Result.add(StdId);
		
		JLabel lblModule = new JLabel("Module:");
		lblModule.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblModule.setBounds(288, 80, 95, 24);
		Result.add(lblModule);
		
		JLabel lblMarks = new JLabel("Marks:");
		lblMarks.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMarks.setBounds(31, 113, 95, 24);
		Result.add(lblMarks);
		
		Marks = new JTextField();
		Marks.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Marks.setColumns(10);
		Marks.setBounds(136, 117, 53, 19);
		Result.add(Marks);
		
		JComboBox Module = new JComboBox();
		HashSet<String> moduleSet = new HashSet<>(Mod);
		String[] moduleArray = moduleSet.toArray(new String[0]);
		Arrays.sort(moduleArray);
		String[] options = new String[moduleArray.length + 1];
		options[0] = "Select module";
		System.arraycopy(moduleArray, 0, options, 1, moduleArray.length);
		Module.setModel(new DefaultComboBoxModel(options));
		Module.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Module.setBounds(353, 82, 219, 21);
		Result.add(Module);
//		Student Resuly table
		DefaultTableModel tableModel2 = new DefaultTableModel();
		ResultTable = new JTable(tableModel2);
		ResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ResultTable.setBounds(10, 177, 562, 231);
		Result.add(ResultTable);
		tableModel2.addColumn("Student Id");
		tableModel2.addColumn("Student Name");
		tableModel2.addColumn("Module Name");
		tableModel2.addColumn("Marks");
		tableModel2.addColumn("Grade");
		ResultTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		ResultTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		ResultTable.getColumnModel().getColumn(2).setPreferredWidth(250);
		ResultTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ResultTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		JScrollPane scrollPane2 = new JScrollPane(ResultTable);
        scrollPane2.setBounds(10, 188, 562, 220);
        Result.add(scrollPane2);
        Result.remove(ResultTable);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_3.setBounds(328, 150, 118, 17);
        Result.add(lblNewLabel_3);
//		open student panel
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Student);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String detai3="SELECT student_id,student_name,email,module1_name,module2_name,module3_name,module4_name FROM student WHERE module1_name='" + m1 + "' OR module1_name='" + m2 
			    			+ "' OR module1_name='" + m3 + "' OR module1_name='" + m4 + "' OR module2_name='" + m1 
			    			+ "' OR module2_name='" + m2 + "' OR module2_name='" + m3 + "' OR module2_name='" + m4 
			    			+ "' OR module3_name='" + m1 + "' OR module3_name='" + m2 + "' OR module3_name='" + m3 
			    			+ "' OR module3_name='" + m4 + "' OR module4_name='" + m1 + "' OR module4_name='" + m2 
			    			+ "' OR module4_name='" + m3 + "' OR module4_name='" + m4 + "';";
			    	ResultSet rs4=st.executeQuery(detai3);
			    	tableModel1.setRowCount(0);
			    	while(rs4.next()) {
			    		sm1=rs4.getString("module1_name");
			    		sm2=rs4.getString("module2_name");
			    		sm3=rs4.getString("module3_name");
			    		sm4=rs4.getString("module4_name");
			    		if(sm1.equals(m1)||sm1.equals(m2)||sm1.equals(m3)||sm1.equals(m4)) {
			    			tableModel1.addRow(new Object[]{rs4.getString("student_id"),rs4.getString("student_name"),rs4.getString("email"),sm1 });
			    		}
			    		if(sm2.equals(m1)||sm2.equals(m2)||sm2.equals(m3)||sm2.equals(m4)) {
			    			tableModel1.addRow(new Object[]{rs4.getString("student_id"),rs4.getString("student_name"),rs4.getString("email"),sm2 });
			    		}
			    		if(sm3.equals(m1)||sm3.equals(m2)||sm3.equals(m3)||sm3.equals(m4)) {
			    			tableModel1.addRow(new Object[]{rs4.getString("student_id"),rs4.getString("student_name"),rs4.getString("email"),sm3 });
			    		}
			    		if(sm4.equals(m1)||sm4.equals(m2)||sm4.equals(m3)||sm4.equals(m4)) {
			    			tableModel1.addRow(new Object[]{rs4.getString("student_id"),rs4.getString("student_name"),rs4.getString("email"),sm4 });
			    		}
			    	} 
			    }
				
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStudent.setBounds(10, 191, 122, 35);
		panel.add(btnStudent);
//		open dashboard panel
		JButton back = new JButton("Dashboard");
		back.setBounds(10, 50, 122, 33);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Dashboard);
				panel_1.repaint();
				panel_1.revalidate();
				
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		add marks of the student
		JButton btnNewButtoAn = new JButton("Add");
		btnNewButtoAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sid = StdId.getText();
				mod = (String)Module.getSelectedItem();
				mark = Integer.parseInt(Marks.getText());
				if(mark>=70&&mark<=100) {
					grade="A";
				}
				else if(mark>=60&&mark<=69){
					grade="B";
				}
				else if(mark>=50&&mark<=59){
					grade="C";
				}
				else if(mark>=43&&mark<=49){
					grade="D";
				}
				else if(mark>=40&&mark<=42){
					grade="E";
				}
				else if(mark>=0&&mark<=39){
					grade="f";
				}
				try {
					Statement st = con.createStatement();
					String detai3="SELECT student_name from student where student_id='"+sid+"'";
					ResultSet rs=st.executeQuery(detai3);
					if(rs.next()) {
						name=rs.getString("student_name");
						String deta="SELECT module1_name,module2_name,module3_name,module4_name from student where student_id='"+sid+"'";
						ResultSet rs1=st.executeQuery(deta);
						while(rs1.next()) {
							s1=rs1.getString("module1_name");
							s2=rs1.getString("module2_name");
							s3=rs1.getString("module3_name");
							s4=rs1.getString("module4_name");
						}
						if(s1.equals(mod)||s2.equals(mod)||s3.equals(mod)||s4.equals(mod)) {
							String data="Insert into marks value('"+sid+"','"+name+"','"+mod+"','"+mark+"','"+grade+"')";
							st.executeUpdate(data);
							JOptionPane.showMessageDialog(null, "Succesfully added", "Success", JOptionPane.INFORMATION_MESSAGE);	
						}
						else {
							JOptionPane.showMessageDialog(null, "The student doesnt have the module", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Student Id is wrong", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButtoAn.setBounds(456, 146, 103, 21);
		Result.add(btnNewButtoAn);
//		open result panel with new student result data
		JButton btnMarks = new JButton("Result");
		btnMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(Result);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String detai3="SELECT student_id,student_name,module_name,marks,grade from marks where module_name='"+m1+
							"'OR module_name='"+m2+"'OR module_name='"+m3+"'OR module_name='"+m4+"'";
			    	ResultSet rs4=st.executeQuery(detai3);
			    	tableModel2.setRowCount(0);
			    	while(rs4.next()) {
			    		tableModel2.addRow(new Object[]{rs4.getString("student_id"),rs4.getString("student_name"),
			            		rs4.getString("module_name"),rs4.getInt("marks"),rs4.getString("grade")});  
			    	} 
			    }
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMarks.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMarks.setBounds(10, 263, 122, 33);
		panel.add(btnMarks);
		
		
	}
//	Connecting the database
	private Connection Connectors() {
	Connect c1 = new Connect();
	Connection x = c1.Connector();
	return x;
	}
}
