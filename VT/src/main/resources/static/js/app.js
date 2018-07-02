function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} 
		
	var url = document.getElementById("url").value;
	if (url == '') {
		alert('Please enter a valid url.');
		return false;
	}
	
	return true;
}