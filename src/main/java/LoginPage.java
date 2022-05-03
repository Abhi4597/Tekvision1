import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import java.sql.DriverManager;


public class LoginPage {

	public static boolean validate(String email,String pass) {
		boolean status= false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Abhi","root","4597");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=?");
			ps.setString(1,email);
			ps.setString(2,pass);
			
			ResultSet rs = ps.executeQuery();
			status=rs.next();
			

		
			
		} catch(Exception e) {
	
		
		}return status;
	}

}
