public class chat
{
	private String username;
	private String message;
	private String date;

	public void setUsername(String u) {
		username = u;
	}

	public String getUsername() {
		return(username);
	}

	public void setMessage(String m) {
		message = m;
	}

	public String getMessage() {
		return(message);
	}

	public void setDate(String d) {
		date = d;
	}

	public String getDate() {
		return(date);
	}

	public String toString() {
		return("Username: " + username + "Message: " + message + "Date: " + date);
	}

	public String getDetails() {
		return(username + "@" + message + "@" + date);
	}
}