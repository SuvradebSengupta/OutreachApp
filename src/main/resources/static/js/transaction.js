/**
 * 
 */
function validateTransaction() {
	var input = document.getElementById("donation").value;
	if(!input==""){
		alert("Congratulations! Your payment is successful");
		return true;
	}
	alert("Please enter an amount");
	return false;
}