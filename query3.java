import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class query3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter bonus ");
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
			
		PreparedStatement ps=	conn.prepareStatement("UPDATE employee2 SET salary = salary+?");
		
		ps.setInt(1, id);
		int x= ps.executeUpdate();
		
		
		if(x >0) {
			System.out.println(x+" record updated sucessfully");
		}
		else
			System.out.println("not updated...");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


