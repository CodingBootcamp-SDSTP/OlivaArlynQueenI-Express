 function validate() {
	var user = document.getElementById("username");
	var pass = document.getElementById("password");
	var email = document.getElementById("email");
	var fname = document.getElementById("fname");
	var lname = document.getElementById("lname");
	var add = document.getElementById("add");
	if(user.value != '' && pass.value != '' && email.value != '' && fname.value != '' && lname.value != '' && add.value != '') {
		if(user.value != pass.value != email.value != fnam.value != lname.value !=add.value) {
			alert("Login Successfully!\n\nHello, '" + user.value);
		}
		return(true);
	}
	else {
		alert('Input should be filled!');
		return(false);
	}
}
