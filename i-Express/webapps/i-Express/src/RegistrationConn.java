import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistrationConn
{
	public Connection connectdb() {
		Connection conn= null;
		Statement stmt = null;
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

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		Connection conn = DatabaseConnectionFactory.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO registration (username, password, email) VALUES (?,?,?);");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.excuteUpdate();
		}
		catch (Exception e) {
			System.out.println("Error: While Closing Connection");
		}
	
		req.setAttribute("newUser", username);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Registration.html");
		dispatcher.forward(req, res);
	}
}
