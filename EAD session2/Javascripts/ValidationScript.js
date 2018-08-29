function validateSignIn() {
	if (validateEmailSignIn() && validatePasswordSignIn()) {
		document.getElementById('SignInForm').submit();
		return true;
	}
	return false;		
}

function validateEmailSignIn(){
	var str = document.getElementById('SignInForm').email.value;
	var patt = new RegExp("^[A-Za-z0-9]*[A-Za-z0-9._]+@[A-Za-z0-9]+[.]+([a-z0-9]){2,4}$");
	var temproryVariable = document.getElementById('errorEmail');	
	if( patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validatePasswordSignIn(){
	var str = document.getElementById('SignInForm').Password.value;
	var patt = new RegExp("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
	var temproryVariable = document.getElementById('errorPassword');
	if(patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validateSignUp() {
	if(validateFirstName() && validateLastName() && validateEmail() && validatePassword() && validateConfirmPassword() && validateContactNumber()) {
		document.getElementById('SignUpForm').submit();
		return true;
	}
	return false;	
}

function validateFirstName(){
	var str = document.getElementById('SignUpForm').firstName.value;
	var patt = new RegExp("^[A-Za-z]{2,}$");
	var temproryVariable = document.getElementById('errorFirstName');
	if(patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validateLastName(){
	var str = document.getElementById('SignUpForm').lastName.value;
	var patt = new RegExp("^[A-Za-z]{2,}$");
	var temproryVariable = document.getElementById('errorLastName');
	if(patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validateEmail(){
	var str = document.getElementById('SignUpForm').email.value;
	var patt = new RegExp("^[A-Za-z0-9]*[A-Za-z0-9._]+@[A-Za-z0-9]+[.]+([a-z0-9]){2,4}$");
	var temproryVariable = document.getElementById('errorEmail');	
	if( patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validatePassword(){
	var str = document.getElementById('SignUpForm').Password.value;
	var patt = new RegExp("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
	var temproryVariable = document.getElementById('errorPassword');
	if(patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validateConfirmPassword(){
	var str = document.getElementById('SignUpForm').Password.value;
	var patt = document.getElementById('SignUpForm').confirmPassword.value ;
	var temproryVariable = document.getElementById('errorConfirmPassword');
	if(patt===str) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}

function validateContactNumber(){
	var str = document.getElementById('SignUpForm').contactNumber.value;
	var patt = new RegExp("^[0-9]{10,}$");
	var temproryVariable = document.getElementById('errorMobileNumber');	
	if( patt.test(str)) {
		temproryVariable.style.display = 'none';
		return true;
	}
	temproryVariable.style.display = 'block';
	return false;
}