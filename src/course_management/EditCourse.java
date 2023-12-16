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

public class EditCourse extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField Name;
	private JTextField S1M1C;
	private JTextField S1M2C;
	private JTextField S1M3C;
	private JTextField S2M1C;
	private JTextField S2M2C;
	private JTextField S2M3C;
	private JTextField S3M1C;
	private JTextField S3M2C;
	private JTextField S3M3C;
	private JLabel lblSem_2_2;
	private JLabel lblSem_2_3;
	private JLabel lblSem_2_4;
	private JTextField S4M2C;
	private JTextField S4M3C;
	private JTextField S4M4C;
	private JTextField S5M1C;
	private JTextField S5M3C;
	private JTextField S5M4C;
	private JTextField S6M1C;
	private JTextField S6M3C;
	private JTextField S6M4C;
	private JTextField S1M4C;
	private JTextField S2M4C;
	private JTextField S3M4C;
	private JTextField S4M1C;
	private JTextField S5M2C;
	private JTextField S6M2C;
	private JTextField Id;
	private JTextField S1M1N;
	private JTextField S2M1N;
	private JTextField S3M1N;
	private JTextField S1M2N;
	private JTextField S1M3N;
	private JTextField S1M4N;
	private JTextField S2M2N;
	private JTextField S2M3N;
	private JTextField S2M4N;
	private JTextField S3M2N;
	private JTextField S3M3N;
	private JTextField S3M4N;
	private JTextField S4M1N;
	private JTextField S4M2N;
	private JTextField S4M3N;
	private JTextField S4M4N;
	private JTextField S5M1N;
	private JTextField S5M2N;
	private JTextField S5M3N;
	private JTextField S5M4N;
	private JTextField S6M1N;
	private JTextField S6M2N;
	private JTextField S6M3N;
	private JTextField S6M4N;
	private JTextField Year;
	private JTextField S5M5C;
	private JTextField S6M5C;
	private JTextField S5M5N;
	private JTextField S6M5N;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public EditCourse() {
		Connection con = Connectors();
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 28, 53, 24);
		contentPane.add(lblNewLabel);
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Name.setColumns(10);
		Name.setBounds(22, 60, 96, 19);
		contentPane.add(Name);
		
		JLabel lblSem = new JLabel("Sem 1");
		lblSem.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem.setBounds(23, 99, 53, 24);
		contentPane.add(lblSem);
		
		S1M1C = new JTextField();
		S1M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M1C.setColumns(10);
		S1M1C.setBounds(23, 128, 64, 19);
		contentPane.add(S1M1C);
		
		S1M2C = new JTextField();
		S1M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M2C.setColumns(10);
		S1M2C.setBounds(22, 159, 64, 19);
		contentPane.add(S1M2C);
		
		S1M3C = new JTextField();
		S1M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M3C.setColumns(10);
		S1M3C.setBounds(23, 195, 64, 19);
		contentPane.add(S1M3C);
		
		JLabel lblSem_2 = new JLabel("Sem 2");
		lblSem_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2.setBounds(310, 99, 53, 24);
		contentPane.add(lblSem_2);
		
		S2M1C = new JTextField();
		S2M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M1C.setColumns(10);
		S2M1C.setBounds(310, 128, 64, 19);
		contentPane.add(S2M1C);
		
		S2M2C = new JTextField();
		S2M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M2C.setColumns(10);
		S2M2C.setBounds(310, 159, 64, 19);
		contentPane.add(S2M2C);
		
		S2M3C = new JTextField();
		S2M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M3C.setColumns(10);
		S2M3C.setBounds(310, 195, 64, 19);
		contentPane.add(S2M3C);
		
		JLabel lblSem_2_1 = new JLabel("Sem 3");
		lblSem_2_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_1.setBounds(610, 99, 53, 24);
		contentPane.add(lblSem_2_1);
		
		JLabel lblAddCourse = new JLabel("Edit course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddCourse.setBounds(327, 10, 147, 34);
		contentPane.add(lblAddCourse);
		
		S3M1C = new JTextField();
		S3M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M1C.setColumns(10);
		S3M1C.setBounds(610, 128, 64, 19);
		contentPane.add(S3M1C);
		
		S3M2C = new JTextField();
		S3M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M2C.setColumns(10);
		S3M2C.setBounds(610, 159, 64, 19);
		contentPane.add(S3M2C);
		
		S3M3C = new JTextField();
		S3M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M3C.setColumns(10);
		S3M3C.setBounds(610, 195, 64, 19);
		contentPane.add(S3M3C);
		
		lblSem_2_2 = new JLabel("Sem 4");
		lblSem_2_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_2.setBounds(23, 264, 53, 24);
		contentPane.add(lblSem_2_2);
		
		lblSem_2_3 = new JLabel("Sem 5");
		lblSem_2_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_3.setBounds(310, 264, 53, 24);
		contentPane.add(lblSem_2_3);
		
		lblSem_2_4 = new JLabel("Sem 6");
		lblSem_2_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSem_2_4.setBounds(610, 264, 53, 24);
		contentPane.add(lblSem_2_4);
		
		S4M2C = new JTextField();
		S4M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M2C.setColumns(10);
		S4M2C.setBounds(23, 327, 64, 19);
		contentPane.add(S4M2C);
		
		S4M3C = new JTextField();
		S4M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M3C.setColumns(10);
		S4M3C.setBounds(23, 363, 64, 19);
		contentPane.add(S4M3C);
		
		S4M4C = new JTextField();
		S4M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M4C.setColumns(10);
		S4M4C.setBounds(23, 392, 64, 19);
		contentPane.add(S4M4C);
		
		S5M1C = new JTextField();
		S5M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M1C.setColumns(10);
		S5M1C.setBounds(310, 298, 64, 19);
		contentPane.add(S5M1C);
		
		S5M3C = new JTextField();
		S5M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M3C.setColumns(10);
		S5M3C.setBounds(310, 363, 64, 19);
		contentPane.add(S5M3C);
		
		S5M4C = new JTextField();
		S5M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M4C.setColumns(10);
		S5M4C.setBounds(310, 392, 64, 19);
		contentPane.add(S5M4C);
		
		S6M1C = new JTextField();
		S6M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M1C.setColumns(10);
		S6M1C.setBounds(610, 298, 64, 19);
		contentPane.add(S6M1C);
		
		S6M3C = new JTextField();
		S6M3C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M3C.setColumns(10);
		S6M3C.setBounds(610, 363, 64, 19);
		contentPane.add(S6M3C);
		
		S6M4C = new JTextField();
		S6M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M4C.setColumns(10);
		S6M4C.setBounds(610, 392, 64, 19);
		contentPane.add(S6M4C);
		
		S1M4C = new JTextField();
		S1M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M4C.setColumns(10);
		S1M4C.setBounds(23, 224, 64, 19);
		contentPane.add(S1M4C);
		
		S2M4C = new JTextField();
		S2M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M4C.setColumns(10);
		S2M4C.setBounds(310, 224, 64, 19);
		contentPane.add(S2M4C);
		
		S3M4C = new JTextField();
		S3M4C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M4C.setColumns(10);
		S3M4C.setBounds(610, 224, 64, 19);
		contentPane.add(S3M4C);
		
		S4M1C = new JTextField();
		S4M1C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M1C.setColumns(10);
		S4M1C.setBounds(23, 298, 64, 19);
		contentPane.add(S4M1C);
		
		S5M2C = new JTextField();
		S5M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M2C.setColumns(10);
		S5M2C.setBounds(310, 327, 64, 19);
		contentPane.add(S5M2C);
		
		S6M2C = new JTextField();
		S6M2C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M2C.setColumns(10);
		S6M2C.setBounds(610, 327, 64, 19);
		contentPane.add(S6M2C);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblId.setBounds(621, 28, 53, 24);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Id.setColumns(10);
		Id.setBounds(619, 60, 96, 19);
		contentPane.add(Id);
		
		S1M1N = new JTextField();
		S1M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M1N.setColumns(10);
		S1M1N.setBounds(104, 128, 125, 19);
		contentPane.add(S1M1N);
		
		S2M1N = new JTextField();
		S2M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M1N.setColumns(10);
		S2M1N.setBounds(396, 128, 125, 19);
		contentPane.add(S2M1N);
		
		S3M1N = new JTextField();
		S3M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M1N.setColumns(10);
		S3M1N.setBounds(692, 128, 125, 19);
		contentPane.add(S3M1N);
		
		S1M2N = new JTextField();
		S1M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M2N.setColumns(10);
		S1M2N.setBounds(104, 159, 125, 19);
		contentPane.add(S1M2N);
		
		S1M3N = new JTextField();
		S1M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M3N.setColumns(10);
		S1M3N.setBounds(104, 195, 125, 19);
		contentPane.add(S1M3N);
		
		S1M4N = new JTextField();
		S1M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S1M4N.setColumns(10);
		S1M4N.setBounds(104, 224, 125, 19);
		contentPane.add(S1M4N);
		
		S2M2N = new JTextField();
		S2M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M2N.setColumns(10);
		S2M2N.setBounds(396, 159, 125, 19);
		contentPane.add(S2M2N);
		
		S2M3N = new JTextField();
		S2M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M3N.setColumns(10);
		S2M3N.setBounds(396, 195, 125, 19);
		contentPane.add(S2M3N);
		
		S2M4N = new JTextField();
		S2M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S2M4N.setColumns(10);
		S2M4N.setBounds(396, 224, 125, 19);
		contentPane.add(S2M4N);
		
		S3M2N = new JTextField();
		S3M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M2N.setColumns(10);
		S3M2N.setBounds(692, 159, 125, 19);
		contentPane.add(S3M2N);
		
		S3M3N = new JTextField();
		S3M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M3N.setColumns(10);
		S3M3N.setBounds(692, 195, 125, 19);
		contentPane.add(S3M3N);
		
		S3M4N = new JTextField();
		S3M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S3M4N.setColumns(10);
		S3M4N.setBounds(692, 224, 125, 19);
		contentPane.add(S3M4N);
		
		S4M1N = new JTextField();
		S4M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M1N.setColumns(10);
		S4M1N.setBounds(104, 298, 125, 19);
		contentPane.add(S4M1N);
		
		S4M2N = new JTextField();
		S4M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M2N.setColumns(10);
		S4M2N.setBounds(104, 327, 125, 19);
		contentPane.add(S4M2N);
		
		S4M3N = new JTextField();
		S4M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M3N.setColumns(10);
		S4M3N.setBounds(104, 363, 125, 19);
		contentPane.add(S4M3N);
		
		S4M4N = new JTextField();
		S4M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S4M4N.setColumns(10);
		S4M4N.setBounds(104, 392, 125, 19);
		contentPane.add(S4M4N);
		
		S5M1N = new JTextField();
		S5M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M1N.setColumns(10);
		S5M1N.setBounds(396, 298, 125, 19);
		contentPane.add(S5M1N);
		
		S5M2N = new JTextField();
		S5M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M2N.setColumns(10);
		S5M2N.setBounds(396, 327, 125, 19);
		contentPane.add(S5M2N);
		
		S5M3N = new JTextField();
		S5M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M3N.setColumns(10);
		S5M3N.setBounds(396, 363, 125, 19);
		contentPane.add(S5M3N);
		
		S5M4N = new JTextField();
		S5M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M4N.setColumns(10);
		S5M4N.setBounds(396, 392, 125, 19);
		contentPane.add(S5M4N);
		
		S6M1N = new JTextField();
		S6M1N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M1N.setColumns(10);
		S6M1N.setBounds(692, 298, 125, 19);
		contentPane.add(S6M1N);
		
		S6M2N = new JTextField();
		S6M2N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M2N.setColumns(10);
		S6M2N.setBounds(692, 327, 125, 19);
		contentPane.add(S6M2N);
		
		S6M3N = new JTextField();
		S6M3N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M3N.setColumns(10);
		S6M3N.setBounds(692, 363, 125, 19);
		contentPane.add(S6M3N);
		
		S6M4N = new JTextField();
		S6M4N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M4N.setColumns(10);
		S6M4N.setBounds(692, 392, 125, 19);
		contentPane.add(S6M4N);
		
//		Edit Instructor
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var id=Id.getText(); var name=Name.getText(); var year=Year.getText(); 
				var s1m1c=S1M1C.getText();var s1m1n=S1M1N.getText(); 
				var s1m2c=S1M2C.getText();var s1m2n=S1M2N.getText();
				var s1m3c=S1M3C.getText();var s1m3n=S1M3N.getText();
				var s1m4c=S1M4C.getText();var s1m4n=S1M4N.getText(); 
				var s2m1c=S2M1C.getText();var s2m1n=S2M1N.getText(); 
				var s2m2c=S2M2C.getText();var s2m2n=S2M2N.getText();
				var s2m3c=S2M3C.getText();var s2m3n=S2M3N.getText(); 
				var s2m4c=S2M4C.getText();var s2m4n=S2M4N.getText();
				var s3m1c=S3M1C.getText();var s3m1n=S3M1N.getText();
				var s3m2c=S3M2C.getText();var s3m2n=S3M2N.getText();
				var s3m3c=S3M3C.getText();var s3m3n=S3M3N.getText(); 
				var s3m4c=S3M4C.getText();var s3m4n=S3M4N.getText(); 
				var s4m1c=S4M1C.getText();var s4m1n=S4M1N.getText(); 
				var s4m2c=S4M2C.getText();var s4m2n=S4M2N.getText();
				var s4m3c=S4M3C.getText();var s4m3n=S4M3N.getText();
				var s4m4c=S4M4C.getText();var s4m4n=S4M4N.getText();
				var s5m1c=S5M1C.getText();var s5m1n=S5M1N.getText();
				var s5m2c=S5M2C.getText();var s5m2n=S5M2N.getText();
				var s5m3c=S5M3C.getText();var s5m3n=S5M3N.getText();
				var s5m4c=S5M4C.getText();var s5m4n=S5M4N.getText();
				var s5m5c=S5M5C.getText();var s5m5n=S5M5N.getText();
				var s6m1c=S6M1C.getText();var s6m1n=S6M1N.getText();	
				var s6m2c=S6M2C.getText();var s6m2n=S6M2N.getText();	
				var s6m3c=S6M3C.getText();var s6m3n=S6M3N.getText();	
				var s6m4c=S6M4C.getText();var s6m4n=S6M4N.getText();	
				var s6m5c=S6M5C.getText();var s6m5n=S6M5N.getText();
				
				try {
					if(id!=null||name!=null||s1m1c!=null||s1m1n!=null||s1m2c!=null||s1m2n!=null||s1m3c!=null||s1m3n!=null
							||s1m4c!=null||s1m4n!=null||s2m1c!=null||s2m1n!=null||s2m2c!=null||s2m2n!=null||s2m3n!=null
							||s2m3c!=null||s2m4c!=null||s2m4n!=null||s3m1c!=null||s3m1n!=null||s3m2c!=null||s3m2n!=null
							||s3m3c!=null||s3m3n!=null||s3m4c!=null||s3m4n!=null||s4m1c!=null||s4m1n!=null||s4m2n!=null
							||s4m2c!=null||s4m3n!=null||s4m3c!=null||s4m4n!=null||s4m4c!=null||s5m1c!=null||s5m1n!=null
							||s5m2n!=null||s5m2c!=null||s5m3n!=null||s5m3c!=null||s5m4n!=null||s5m4c!=null||s6m1n!=null
							||s6m1c!=null||s6m2n!=null||s6m2c!=null||s6m3n!=null||s6m3c!=null||s6m4n!=null||s6m4c!=null
							||year!=null){
						
						Statement st= con.createStatement();
						String data="SELECT course_id FROM course WHERE course_id = '" + id + "'";
			        	ResultSet rs=st.executeQuery(data);
			        	if(rs.next()) {
			        		String del[]={"DELETE from course WHERE course_id = '" + id + "'",
			        					"DELETE from module WHERE course_name = '" + name + "'"};
			        		for (String i : del) {
							    st.executeUpdate(i);
							}
			        		String query="INSERT INTO course VALUES ('" + id + "','" + name + "','" + year + "')";
							st.executeUpdate(query);
							String query1[]={"INSERT INTO module VALUES ('" + s1m1c + "','" + name + "','" + s1m1n + "','" + 1 + "')",
											"INSERT INTO module VALUES ('" + s1m2c + "','" + name + "','" + s1m2n + "','" + 1 + "')",
											"INSERT INTO module VALUES ('" + s1m3c + "','" + name + "','" + s1m3n + "','" + 1 + "')",
											"INSERT INTO module VALUES ('" + s1m4c + "','" + name + "','" + s1m4n + "','" + 1 + "')",
											"INSERT INTO module VALUES ('" + s2m1c + "','" + name + "','" + s2m1n + "','" + 2 + "')",
											"INSERT INTO module VALUES ('" + s2m2c + "','" + name + "','" + s2m2n + "','" + 2 + "')",
											"INSERT INTO module VALUES ('" + s2m3c + "','" + name + "','" + s2m3n + "','" + 2 + "')",
											"INSERT INTO module VALUES ('" + s2m4c + "','" + name + "','" + s2m4n + "','" + 2 + "')",
											"INSERT INTO module VALUES ('" + s3m1c + "','" + name + "','" + s3m1n + "','" + 3 + "')",
											"INSERT INTO module VALUES ('" + s3m2c + "','" + name + "','" + s3m2n + "','" + 3 + "')",
											"INSERT INTO module VALUES ('" + s3m3c + "','" + name + "','" + s3m3n + "','" + 3 + "')",
											"INSERT INTO module VALUES ('" + s3m4c + "','" + name + "','" + s3m4n + "','" + 3 + "')",
											"INSERT INTO module VALUES ('" + s4m1c + "','" + name + "','" + s4m1n + "','" + 4 + "')",
											"INSERT INTO module VALUES ('" + s4m2c + "','" + name + "','" + s4m2n + "','" + 4 + "')",
											"INSERT INTO module VALUES ('" + s4m3c + "','" + name + "','" + s4m3n + "','" + 4 + "')",
											"INSERT INTO module VALUES ('" + s4m4c + "','" + name + "','" + s4m4n + "','" + 4 + "')",
											"INSERT INTO module VALUES ('" + s5m1c + "','" + name + "','" + s5m1n + "','" + 5 + "')",
											"INSERT INTO module VALUES ('" + s5m2c + "','" + name + "','" + s5m2n + "','" + 5 + "')",
											"INSERT INTO module VALUES ('" + s5m3c + "','" + name + "','" + s5m3n + "','" + 5 + "')",
											"INSERT INTO module VALUES ('" + s5m4c + "','" + name + "','" + s5m4n + "','" + 5 + "')",
											"INSERT INTO module VALUES ('" + s5m5c + "','" + name + "','" + s5m5n + "','" + 5 + "')",
											"INSERT INTO module VALUES ('" + s6m1c + "','" + name + "','" + s6m1n + "','" + 6 + "')",
											"INSERT INTO module VALUES ('" + s6m2c + "','" + name + "','" + s6m2n + "','" + 6 + "')",
											"INSERT INTO module VALUES ('" + s6m3c + "','" + name + "','" + s6m3n + "','" + 6 + "')",
											"INSERT INTO module VALUES ('" + s6m4c + "','" + name + "','" + s6m4n + "','" + 6 + "')",
											"INSERT INTO module VALUES ('" + s6m5c + "','" + name + "','" + s6m5n + "','" + 6 + "')"
							};
							for (String i : query1) {
							    st.executeUpdate(i);
							}
							JOptionPane.showMessageDialog(null, "Successfully edited", "Success", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
			        	}
			        	else {
			        		JOptionPane.showMessageDialog(null, "Course doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			        	}
					}
					else {
						JOptionPane.showMessageDialog(null, "Something is missing", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {	
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setBounds(708, 474, 123, 25);
		contentPane.add(btnSave);
		
		JLabel lblYears = new JLabel("Years:");
		lblYears.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblYears.setBounds(171, 28, 53, 24);
		contentPane.add(lblYears);
		
		Year = new JTextField();
		Year.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Year.setColumns(10);
		Year.setBounds(171, 60, 45, 19);
		contentPane.add(Year);
		
		S5M5C = new JTextField();
		S5M5C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M5C.setColumns(10);
		S5M5C.setBounds(310, 421, 64, 19);
		contentPane.add(S5M5C);
		
		S6M5C = new JTextField();
		S6M5C.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M5C.setColumns(10);
		S6M5C.setBounds(610, 421, 64, 19);
		contentPane.add(S6M5C);
		
		S5M5N = new JTextField();
		S5M5N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S5M5N.setColumns(10);
		S5M5N.setBounds(396, 421, 125, 19);
		contentPane.add(S5M5N);
		
		S6M5N = new JTextField();
		S6M5N.setFont(new Font("Times New Roman", Font.BOLD, 12));
		S6M5N.setColumns(10);
		S6M5N.setBounds(692, 421, 125, 19);
		contentPane.add(S6M5N);
		
//		Close the frame
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 128, 128));
		btnNewButton.setBounds(715, 19, 102, 26);
		contentPane.add(btnNewButton);
	}
//	Connecting database
	private Connection Connectors() {
		// TODO Auto-generated method stub
		Connect c1 = new Connect();
		Connection x = c1.Connector();
		return x;
	}

}
