function validateForm()
{
	if(document.MyForm.Name.value == "" || /\d/.test(document.MyForm.Name.value))
	{
		alert("Enter your name correctly!");
		document.MyForm.Name.focus();
		return false;
	}
	if(document.MyForm.Contact_number.value=="" || /\D/.test(document.MyForm.Contact_number.value) || (document.MyForm.Password.value).length<8){
		alert("Please provide your contact number!");
		document.MyForm.Contact_number.focus();
		return false;
	}
	if(document.MyForm.Email.value=="" || (document.MyForm.Email.value).indexOf("@")<1 || ((document.MyForm.Email.value).indexOf("."))-((document.MyForm.Email.value).indexOf("@"))<2){
		alert("Please provide your email!");
		document.MyForm.Email.focus();
		return false;
	}
	if(document.MyForm.Password.value=="" || (document.MyForm.Password.value).length<8 ||  /\s/.test(document.MyForm.Password.value) ||  /\W/.test(document.MyForm.Password.value)){
		alert("Please provide password!");
		document.MyForm.Password.focus();
		return false;
	}
	return true;
	
}
	
	