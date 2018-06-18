 function validate() {
	var user = document.getElementById("username");
	var pass = document.getElementById("password");
	var email = document.getElementById("email");
	if(user.value != '' && pass.value != '' && email.value != '') {
		if(user.value != pass.value != email.value) {
			alert("Login Successfully!\n\nHello, '" + user.value + "'\nYour Password is: '" + pass.value + "'\nYour Email is: '" + email.value + "'");
		}
		return(true);
	}
	else {
		alert('Input should be filled!');
		return(false);
	}
}
