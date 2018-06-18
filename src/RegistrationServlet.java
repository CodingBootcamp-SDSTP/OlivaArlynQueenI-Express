import java.sql.*;

public class RegistrationServlet
{
	public RegistrationServlet() {
		Connection c = connectdb();
		if(c == null) {
			System.out.println("Error connecting to your MySQL Database...");
		}
		else {
			System.out.println("Connected!");
			readFromMySQLDB(c);
		}
	}	

	public Connection connectdb() {
		Connection conn= null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/projectdb?user=arlyn&password=arlyn143&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
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
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO registration VALUES ('" + username + "', '" password + "', '" + email + "')";
			stmt.excuteUpdate(sql);
		}
		catch (Exception e) {
			System.out.println("Error: While Closing Connection");
		}
	
		req.setAttribute("newUser", username);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
		dispatcher.forward(req, res);
	}
}
