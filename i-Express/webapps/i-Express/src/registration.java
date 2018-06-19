public class registration
{
	private String username;
	private String password;
	private String email;

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

	public void setEmail(String e) {
		email = e;
	}

	public String getEmail() {
		return(email);
	}

	public String toString() {
		return("Username: " + username + "Password: " + password + "Email: " + email);
	}

	public String getDetails() {
		return(username + "@" + password + "@" + email);
	}
}