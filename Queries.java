import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Queries {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id");
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
			
		PreparedStatement ps=	conn.prepareStatement("select salary from Employee2 where eid=?");
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("Salary is "+rs.getInt("salary"));
		}
		else {
			System.out.println("Employee doesnt exist");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
