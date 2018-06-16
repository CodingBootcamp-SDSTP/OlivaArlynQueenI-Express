function validate() {
	var user = document.getElementById("username");
	var pass = document.getElementById("password");
	if(user.value != '' && pass.value) {
		if(email.value != pass.value) {
			alert("Login Successfully!\n\nHello, '" + user.value + "'\nYour Password is: '" + pass.value + "'");
		}
		return(true);
	}
	else {
		alert('Input should be filled!');
		return(false);
	}
}
