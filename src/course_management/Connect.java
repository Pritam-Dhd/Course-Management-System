package course_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public  Connection Connector() {
		Connection con = null;
		try {
			String url="jdbc:mysql://localhost:3306/cms";
			String username="root";
			String password="";
			con=DriverManager.getConnection(url,username,password);	
		}
		catch(Exception e1) {
			System.out.println("error");
			e1.printStackTrace();
		}
		return con;
	}
}
