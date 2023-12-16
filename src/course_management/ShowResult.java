package course_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ShowResult extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTable StudentTable;
	private JTextField ID;
	Connection con = Connectors();
	private String id,name,cou;

	/**
	 * Create the frame.
	 */
	public ShowResult() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setBackground(new Color(128, 128, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(310, 23, 166, 38);
		contentPane.add(lblNewLabel);
		
//		close the frame
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 128, 128));
		btnNewButton.setBounds(617, 29, 102, 26);
		contentPane.add(btnNewButton);
//		Student Table
		DefaultTableModel tableModel = new DefaultTableModel();
		StudentTable = new JTable(tableModel);
		StudentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		StudentTable.setBounds(10, 158, 736, 312);
		contentPane.add(StudentTable);
		tableModel.addColumn("Student Name");
		tableModel.addColumn("Course Name");
		tableModel.addColumn("Module Name");
		tableModel.addColumn("Marks");
		tableModel.addColumn("Grade");
		StudentTable.getColumnModel().getColumn(0).setPreferredWidth(160);
		StudentTable.getColumnModel().getColumn(1).setPreferredWidth(160);
		StudentTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		StudentTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		StudentTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		JScrollPane scrollPane1 = new JScrollPane(StudentTable);
        scrollPane1.setBounds(20, 135, 715, 335);
        contentPane.add(scrollPane1);
        contentPane.remove(StudentTable);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(20, 77, 44, 26);
		contentPane.add(lblNewLabel_1_2);
		
		ID = new JTextField();
		ID.setBounds(59, 80, 93, 25);
		contentPane.add(ID);
		ID.setColumns(10);
//		Snow the result of the student
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=ID.getText();
				try {
					Statement st = con.createStatement();
					String d="Select course_name from student where student_id='"+id+"'";
					ResultSet rs1=st.executeQuery(d);
					if(rs1.next()) {
						cou=rs1.getString("course_name");
						String data="SELECT student_name,module_name,marks,grade FROM marks where student_id='"+id+"'";
				    	ResultSet rs=st.executeQuery(data);
				    	tableModel.setRowCount(0);
						while (rs.next()) {
							name=rs.getString("student_name");
							tableModel.addRow(new Object[]{name,cou,rs.getString("module_name"),rs.getInt("marks"),rs.getString("grade")});  
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Student Id", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnEnter.setBackground(new Color(255, 255, 255));
		btnEnter.setBounds(183, 77, 81, 26);
		contentPane.add(btnEnter);
	}
//	Connecting database
	private Connection Connectors() {
		Connect c1 = new Connect();
		Connection x = c1.Connector();
		return x;
		}
}
