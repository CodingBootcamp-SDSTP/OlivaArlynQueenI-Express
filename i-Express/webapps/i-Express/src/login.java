public class login
{
	private String username;
	private String password;

	public void setUsername(String u) {
		username = u;
	}

	public String getUsername() {
		return(username);
	}

	public void setPassword(String p) {
		password = p;
	}

	public String getPassword() {
		return(password);
	}

	public String toString() {
		return("Username: " + username + "Password: " + password);
	}

	public String getDetails() {
		return(username + "@" + password);
	}
}