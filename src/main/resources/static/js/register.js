function validate() {

	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var password = document.getElementById("password").value;
	var contact = document.getElementById("contactnumber").value;
	var age = document.getElementById("age").value;
	var nameRegex = /[A-Za-z]{4,50}/;
	var passwordRegex = /[^\s.]{6,20}$/;
	var contactRegex = /^[0-9]{10}$/;

	if (!(firstname.match(nameRegex)) || (!lastname.match(nameRegex)) || (!password.match(passwordRegex)) ||
		(!contact.match(contactRegex)) || (!(age >= 18 && age <= 60))) {
		alert("Please update the mandatory field(s)");
		return false;
	}

	alert("Your details are submitted successfully");
	return true;
}
