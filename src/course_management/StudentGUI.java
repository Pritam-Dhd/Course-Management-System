package course_management;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class StudentGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable ModuleTable;
	private JTable ResultTable;
	private String id,name,n,c="Not enrolled",m1,m2,m3,m4;
	private int tn=0,s;
	String[] m={m1,m2,m3,m4};

	Connection con = Connectors();

	public StudentGUI(String id) {
		this.id=id;
		try {
			Statement st = con.createStatement();
			String detail="Select name FROM user where id='"+id+"'";
	    	ResultSet rs2=st.executeQuery(detail);
	    	while (rs2.next()) {
	    		n=rs2.getString("name");
	        }
	    	String data1="SELECT course_name FROM student where student_id='"+id+"'";
	    	ResultSet rs1=st.executeQuery(data1);
	    	while (rs1.next()) {
	            c=rs1.getString("course_name");
	        }
	    	String data2="SELECT module1_name,module2_name,module3_name,module4_name FROM student where student_id='"+id+"'";
	    	ResultSet rs3=st.executeQuery(data2);
	    	while (rs3.next()) {
	            tn=4;
	        }
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frame = this;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 153, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
//		Log out
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login f2 = new Login();
					f2.show();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogout.setBounds(10, 316, 133, 40);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(173, 10, 571, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(192, 192, 192));
		panel_1.add(Dashboard, "name_80496418765900");
		Dashboard.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Modules: "+tn);
		lblNewLabel_2.setBackground(new Color(128, 128, 192));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(32, 130, 179, 121);
		Dashboard.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Course Name: "+c);
		lblNewLabel_2_1.setBackground(new Color(128, 128, 192));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(32, 261, 474, 121);
		Dashboard.add(lblNewLabel_2_1);
		
		JLabel Total_1_2 = new JLabel("Welcome "+n);
		Total_1_2.setBackground(new Color(128, 128, 192));
		Total_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Total_1_2.setBounds(32, 22, 372, 87);
		Dashboard.add(Total_1_2);
		
		JPanel modules = new JPanel();
		modules.setBackground(new Color(192, 192, 192));
		modules.setBounds(0, 0, 272, 253);
		panel_1.add(modules);
		modules.setLayout(null);
//		Module table
		DefaultTableModel tableModel = new DefaultTableModel();
		ModuleTable = new JTable(tableModel);
		ModuleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ModuleTable.setBackground(new Color(192, 192, 192));
		ModuleTable.setBounds(10, 102, 551, 306);
		modules.add(ModuleTable);
		tableModel.addColumn("Module Id");
		tableModel.addColumn("Module Name");
		tableModel.addColumn("Semester");   
		ModuleTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		ModuleTable.getColumnModel().getColumn(1).setPreferredWidth(300);
		ModuleTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		JScrollPane scrollPane = new JScrollPane(ModuleTable);
        scrollPane.setBounds(10, 108, 545, 300);
        modules.add(scrollPane);
        modules.remove(ModuleTable);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(10, 23, 119, 39);
        modules.add(lblNewLabel);
//      open enrollcourse frame
        JButton btnNewButton_1_1 = new JButton("Enroll");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EnrollCourse f2 = new EnrollCourse(id);
				f2.show();
        	}
        });
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 9));
        btnNewButton_1_1.setBounds(486, 66, 69, 32);
        modules.add(btnNewButton_1_1);
        
		JPanel result = new JPanel();
		result.setBackground(new Color(192, 192, 192));
		result.setBounds(0, 0, 372, 290);
		panel_1.add(result);
		result.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBounds(257, 31, 71, 35);
		result.add(lblNewLabel_1);
//		Result Tabel
		DefaultTableModel tableModel1 = new DefaultTableModel();
		ResultTable = new JTable(tableModel1);
		ResultTable.setBackground(Color.LIGHT_GRAY);
		ResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ResultTable.setBounds(10, 102, 551, 306);
		result.add(ResultTable);
		tableModel1.addColumn("Student Id");
		tableModel1.addColumn("Student Name");
		tableModel1.addColumn("Module Name");
		tableModel1.addColumn("Marks");
		tableModel1.addColumn("Grade"); 
		ResultTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		ResultTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		ResultTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		ResultTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ResultTable.getColumnModel().getColumn(4).setPreferredWidth(90);
        JScrollPane scrollPane1 = new JScrollPane(ResultTable);
        scrollPane1.setBounds(10, 101, 545, 307);
        result.add(scrollPane1);
        result.remove(ResultTable);
//     	open module panel
		JButton btnNewButton = new JButton("Modules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(modules);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT course_name,module1_name,module2_name,module3_name,module4_name,semester FROM student where student_id='"+id+"'";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel.setRowCount(0);
					while (rs.next()) {
						m1=rs.getString("module1_name");
				    	m2=rs.getString("module2_name");
				    	m3=rs.getString("module3_name");
				    	m4=rs.getString("module4_name");
				    	s=rs.getInt("semester");
				    	c=rs.getString("course_name");
					}
					String data1="SELECT module_id,module_name FROM module where (module_name='"+m1+"'OR module_name='"+m2+"'"
						+ "OR module_name='"+m3+"'OR module_name='"+m4+"')AND semester='"+s+"'AND course_Name='"+c+"'";
						ResultSet rs1=st.executeQuery(data1);
						while(rs1.next()) {
							tableModel.addRow(new Object[]{rs1.getString("module_id"),rs1.getString("module_name"),s});
						}    
			    }
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(10, 152, 133, 40);
		panel.add(btnNewButton);
//		open result panel
		JButton btnSeeResult = new JButton("See Result");
		btnSeeResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.add(result);
				panel_1.repaint();
				panel_1.revalidate();
				try {
					Statement st = con.createStatement();
					String data="SELECT student_id,student_name,module_name,marks,grade FROM marks where student_id='"+id+"'";
			    	ResultSet rs=st.executeQuery(data);
			    	tableModel1.setRowCount(0);
					while (rs.next()) {
						tableModel1.addRow(new Object[]{rs.getString("student_id"),rs.getString("student_name"),
			            		rs.getString("module_name"),rs.getInt("marks"),rs.getString("grade")});  
					}
				}
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSeeResult.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSeeResult.setBounds(10, 237, 133, 40);
		panel.add(btnSeeResult);
//		open Dahboard panel
		JButton back = new JButton("Dashboard");
		back.setBounds(10, 68, 133, 40);
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
	}
//	Connectng the database
	private Connection Connectors() {
	Connect c1 = new Connect();
	Connection x = c1.Connector();
	return x;
	}
}
