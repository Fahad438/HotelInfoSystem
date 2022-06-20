function validate() {

    var decision = true;
    var occupied = document.getElementById("occupied").value;

    //valid occupied
    if ( (occupied != 0 || occupied == "" ) && (occupied == ""  || occupied != 1)) {

        decision = false;
        document.getElementById("errOccupied").innerHTML = "Error Please enter a value between zero and one";
        document.getElementById("errOccupied").style.display = "inline";


    } else {

        document.getElementById("errOccupied").innerHTML = "";
        document.getElementById("errOccupied").style.display = "none";


    }



    //valid Floor Number
    if (document.getElementById("Floor").value == "Please select Number floor...") {
        decision = false;
        document.getElementById("errFloor").innerHTML = "Wrong choose floor number:";
        document.getElementById("errFloor").style.display = "inline";
    } else {
        document.getElementById("errFloor").innerHTML = "";
        document.getElementById("errFloor").style.display = "none";
    }




    //valid Room Number
    if (document.getElementById("Room").value.search(/^(\d{1,8})$/) != 0) {
        decision = false;
        document.getElementById("errRoom").innerHTML = "Wrong Enter the room number (the value must be a number)";
        document.getElementById("errRoom").style.display = "inline";


    } else {


        document.getElementById("errRoom").innerHTML = "";
        document.getElementById("errRoom").style.display = "none";

    }



    //valid Apartment number
    if (document.getElementById("Apartment").value.search(/^(\d{1,8})$/) != 0) {
        decision = false;
        document.getElementById("errApartment").innerHTML = "Wrong Enter the Apartment number (the value must be a number)";
        document.getElementById("errApartment").style.display = "inline";


    } else {


        document.getElementById("errApartment").innerHTML = "";
        document.getElementById("errApartment").style.display = "none";

    }





    //valid Price

    if (document.getElementById("Price").value.search(/^(\d{1,8})$/) != 0) {
        decision = false;
        document.getElementById("errPrice").innerHTML = "Error entering room price (the value must be a number)";
        document.getElementById("errPrice").style.display = "inline";


    } else {


        document.getElementById("errPrice").innerHTML = "";
        document.getElementById("errPrice").style.display = "none";

    }



    //valid Payment
    if (document.getElementById("Payment").value !== "") {

        if (document.getElementById("Payment").value.search(/^(\d{1,8})$/) != 0) {
            decision = false;
            document.getElementById("errPayment").innerHTML = "Error entering Payment (the value must be a number)";
            document.getElementById("errPayment").style.display = "inline";

        } else {

            document.getElementById("errPayment").innerHTML = "";
            document.getElementById("errPayment").style.display = "none";
        }


    }

    //valid RenterNationalID
    if (document.getElementById("RenterNationalID").value !== "") {

        if (document.getElementById("RenterNationalID").value.search(/^1d{9}|2\d{9}$/) != 0) {
            decision = false;
            document.getElementById("errRenterNationalID").innerHTML = "Please enter the national ID correctly, such as 1********* or 2*********";
            document.getElementById("errRenterNationalID").style.display = "inline";

        } else {

            document.getElementById("errRenterNationalID").innerHTML = "";
            document.getElementById("errRenterNationalID").style.display = "none";
        }


    }

    //valid RenterName
    if (document.getElementById("RenterName").value !== "") {

        if (document.getElementById("RenterName").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0) {
            decision = false;
            document.getElementById("errRenterName").innerHTML = "The name must consist of at least 6 characters and do not contain symbols or numbers";
            document.getElementById("errRenterName").style.display = "inline";

        } else {

            document.getElementById("errRenterName").innerHTML = "";
            document.getElementById("errRenterName").style.display = "none";
        }


    }







    if (decision === false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }




}

function validatefeedback() {
    valid = true;



    if (document.getElementById("name").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0)         //name should be at least 6 characters. Not complete regex. Each character should be a-z OR A-Z OR ' or - or _ or space
    {
        valid = false;
        document.getElementById("errname").innerHTML = "ERROR: Name is mandatory and should be at least 6 characters !";
        document.getElementById("errname").style.display = "inline";
    } else {
        document.getElementById("errname").innerHTML = "";
        document.getElementById("errname").style.display = "none";
    }

    var phone = document.getElementById("phone").value;

    //Validate the phone field
    if (document.getElementById("phone").value.search(/^(05\d{8}|9665\d{8})$/) != 0)        //e.g.  0512345678  or   966512345678
    {
        valid = false;
        document.getElementById("errphone").innerHTML = "ERROR: Phone number is wrong (05xxxxxxxx or 9665xxxxxxxx) !";
        document.getElementById("errphone").style.display = "inline";
    } else {
        document.getElementById("errphone").innerHTML = "";
        document.getElementById("errphone").style.display = "none";

    }
    //Validate the email field
    if (document.getElementById("email").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0) {
        valid = false;
        document.getElementById("erremail").innerHTML = "ERROR: Provide a correct email address !";
        document.getElementById("erremail").style.display = "inline";
    } else {
        document.getElementById("erremail").innerHTML = "";
        document.getElementById("erremail").style.display = "none";
    }

    //Validate the Subject field
    if (document.getElementById("Subject").value.search(/^[A-Za-z'\-\._ ]{4,}$/) != 0) {
        valid = false;
        document.getElementById("errsubject").innerHTML = "Subject is should be at least 4 characters !";
        document.getElementById("errsubject").style.display = "inline";
    } else {
        document.getElementById("errsubject").innerHTML = "";
        document.getElementById("errsubject").style.display = "none";
    }



    //Validate the Type field

    if (document.getElementById("Type").value == "Please select your type...") {
        valid = false;
        document.getElementById("errtype").innerHTML = "Please select a  type";
        document.getElementById("errtype").style.display = "inline";
    } else {

        document.getElementById("errtype").innerHTML = "";
        document.getElementById("errtype").style.display = "none";
    }

    //Validate the Type field
    var message = document.getElementById("message").value;
    if (!message) {
        valid = false;
        document.getElementById("errmesage").innerHTML = "Please enter the message"
        document.getElementById("errmesage").style.display = "inline"

    } else {
        document.getElementById("errmesage").innerHTML = ""
        document.getElementById("errmesage").style.display = "none"
    }
    if (valid == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}
function validateLogin() {
    valid = true;
    
    if(document.getElementById("username").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0){
        valid = false;
        document.getElementById("userError").innerHTML = "Please enter the username";
        document.getElementById("userError").style.display = "inline";

    } else {
        document.getElementById("userError").innerHTML = "";
        document.getElementById("userError").style.display = "none";
    }

    if(document.getElementById("password").value==""){
        valid = false;
        document.getElementById("passEror").innerHTML = "Please enter the password";
        document.getElementById("passEror").style.display = "inline";

    } else {
        document.getElementById("passEror").innerHTML = "";
        document.getElementById("passEror").style.display = "none";
    }



    if (valid == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}
function validateRegister() {
    valid = true;
    
    if(document.getElementById("FullName").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0) {
        valid = false;
        document.getElementById("errorFullName").innerHTML = "Please enter the FullNmae";
        document.getElementById("errorFullName").style.display = "inline";

    } else {
        document.getElementById("errorFullName").innerHTML = "";
        document.getElementById("errorFullName").style.display = "none";
    }

    if(document.getElementById("username").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0){
        valid = false;
        document.getElementById("userError").innerHTML = "Please enter the UserName";
        document.getElementById("userError").style.display = "inline";

    } else {
        document.getElementById("userError").innerHTML = "";
        document.getElementById("userError").style.display = "none";
    }

      //Validate the password and confirm password fields
      if (document.getElementById("password").value.length < 6   ||   document.getElementById("password").value != document.getElementById("cPassword").value)
      {
        valid = false;
          document.getElementById("passError").innerHTML = "Password and Confirm Password should match and be at least 6 characters !";
          document.getElementById("passError").style.display = "inline";
      }
      else
      {
          document.getElementById("passError").innerHTML = "";
          document.getElementById("passError").style.display = "none";
      }
  



    if (valid == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    } else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }
}