

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class query6 {


	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter salary want to sort");
		int id= s.nextInt();
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost:3306/db2";
		
		try {
			Connection conn=DriverManager.getConnection(url,"root","mysqlroot");
			
		PreparedStatement ps=	conn.prepareStatement("select * from Employee2 where salary<?");
		ps.setInt(1, id);
		
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Employee id is "+rs.getInt("eid"));
			System.out.println("Employee name is "+rs.getString("name"));
			System.out.println("Employee address is "+rs.getString("address"));
			System.out.println("Salary is "+rs.getInt("salary"));
			
			System.out.println("-------------------------------");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


