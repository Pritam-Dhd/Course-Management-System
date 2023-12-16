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

public class DeleteStudent extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField ID;
	/**
	 * Create the frame.
	 */
	public DeleteStudent() {
		frame=this;
		Connection con = Connectors();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setBackground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(51, 50, 186, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student Id:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(51, 121, 201, 30);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setBounds(49, 161, 157, 30);
		contentPane.add(ID);
		ID.setColumns(10);
//		Delete Student
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var id=ID.getText();
				if(id!=null) {
					try {
						Statement st= con.createStatement();
						String data="SELECT student_id FROM student WHERE student_id = '" + id + "'";
						ResultSet rs=st.executeQuery(data);
						if(rs.next()) {
							String del="DELETE from student WHERE student_id = '" + id + "'";
							st.executeUpdate(del);
							JOptionPane.showMessageDialog(null, "Succesfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Wrong Instructor Id", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Enter Id in the text field", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(69, 228, 119, 36);
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
		btnNewButton_1.setBounds(173, 21, 79, 22);
		contentPane.add(btnNewButton_1);
	}
//	Connecting database
	private Connection Connectors() {
		Connect c1 = new Connect();
		Connection x = c1.Connector();
		return x;
	}

}
