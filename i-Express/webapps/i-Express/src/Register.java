import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class Register extends HttpServlet
{
	private static Connection conn;
	private static Statement stmt;

	public Connection connectdb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iExpressdb?user=arlyn&password=arlyn143&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		}
		catch(Exception e) {
			conn = null;
			e.printStackTrace();
		}
		finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(conn);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.println("<link rel='stylesheet' type= 'text/css' href='WEB-INF/style.css'>");

		String n=request.getParameter("username");
		String p=request.getParameter("password");
		String e=request.getParameter("email");
		String f=request.getParameter("firstname");
		String l=request.getParameter("lastname");
		String a=request.getParameter("address");
		try{
			PreparedStatement ps=conn.prepareStatement("INSERT INTO registration (username, password, email, firstname, lastname, address) VALUES(?,?,?,?,?,?);");
			ps.setString(1,n);
			ps.setString(2,p);
			ps.setString(3,e);
			ps.setString(4,f);
			ps.setString(5,l);
			ps.setString(6,a);
			
			int i=ps.executeUpdate();
			if(i>0)
			out.print("You are successfully registered...");

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
