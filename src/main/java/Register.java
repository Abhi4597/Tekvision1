

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Execption = null;
	private static final Connection DriverManneger = null;

    public Register() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fName = request.getParameter("Name");
		String lName = request.getParameter("LastName");
		String Emailid = request.getParameter("Email");
		String Password = request.getParameter("Password");

		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Abhi","root","4597");
		
		PreparedStatement ps = con.prepareStatement("insert into register valuse(?,?,?,?)");
		ps.setString(1,fName);
		ps.setString(2,lName);
		ps.setString(3,Emailid);
		ps.setString(4,Password);

		int i=ps.executeUpdate();
		if(i>0)
		{
			out.print("you are successfully register");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);
		}
		
		} catch(Exception e) {
	
		}
		out.close(); 
	}
}
