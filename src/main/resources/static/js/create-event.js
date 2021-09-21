function validate() {

	var activity = document.getElementById("activity").value;
	var description = document.getElementById("description").value;
	var place = document.getElementById("location").value;
	var date = document.getElementById("date").value;
	var contactnumber = document.getElementById("contactnumber").value;
	var contactRegex = /^[0-9]{10}$/;
	var eventdate = new Date(date);
	var today = new Date();
	
	if (activity == "" || description == "" || place == "" || (!contactnumber.match(contactRegex)) || !(eventdate >= today)) {
		alert("Please provide the highlighted mandatory field(s).");
		return false;
	}

	alert("Details updated successfully.");
	return true;
}
