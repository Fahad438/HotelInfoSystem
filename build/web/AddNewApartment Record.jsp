<%-- 
    Document   : newjsp
    Created on : 29/05/2022, 08:24:23 م
    Author     : fahad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Hotel">
        <meta name="keywords" content="Hotel,hotel,Best Hotel,holiday,the summer,Summer,5-star hotel">

        <link rel="stylesheet" href="css/style.css" />
        <script src="script/site.js"></script>

        <title>Add New Apartment Record</title>
    </head>

    <body>

        <%if (session.getAttribute("USER") != null) {%>
        <div class="container">

            <!--start navg-->
            <div class="nav-container">
                <div class="nav">
                    <h3 class="logo">Makkah Hotel</h3>
                    <ul>
                        <li><a href="http://localhost:8080/HISystem/MainServlet">Home</a></li>
                        <li><a href="AddNewApartment Record.jsp">Reservation</a></li>
                        <li><a href="http://localhost:8080/HISystem/BrowseAllApartments">Apartment</a></li>
                        <li><a href="http://localhost:8080/HISystem/Feedback">Feeddback</a></li>
                        <li><a href="http://localhost:8080/HISystem/Logout">Logout</a></li>

                    </ul>
                </div>
            </div>
            <!--end navg-->

            <!-- start add Apartment-->
            <div class="Add">
                <h1>Reserve your room</h1>
                <div class="form">
                    <form action="AddApartment" method="post" onsubmit=" return validate()">
                        <div class="item"> <label>
                                <div class="lbl"> Apartment Number:<span class="erro">*</span>
                                    <span class="error" id="errApartment"> </span>
                                </div> <input id="Apartment" class="inputBox" type="text" name="Apartment"
                                              placeholder="Enter Apartment Number" />
                            </label>
                        </div>


                        <div> <label>
                                <div> Floor Number:<span class="erro">*</span>
                                    <span class="error" id="errFloor"> </span>
                                </div>
                                <select id="Floor" class="inputBox" name="Floor">
                                    <option>Please select Number floor...</option>
                                    <option> 0 </option>
                                    <option> 1 </option>
                                    <option> 2 </option>
                                    <option> 3 </option>
                                    <option> 4 </option>
                                    <option> 5 </option>
                                    <option> 6 </option>
                                </select>
                            </label>
                        </div>


                        <div class="item"> <label>
                                <div class="lbl"> Number Of Rooms: <span class="erro">*</span>
                                    <span class="error" id="errRoom"> </span>
                                </div> <input id="Room" class="inputBox" type="text" name="Room"
                                              placeholder="Enter Number Of Rooms" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> occupied:<span class="erro">*</span>
                                    <span class="error" id="errOccupied"> </span>
                                </div> <input id="occupied" class="inputBox" type="number" name="occupied"
                                              placeholder="Enter occupied" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> Price:<span class="erro">*</span>
                                    <span class="error" id="errPrice"> </span>
                                </div> <input id="Price" class="inputBox" type="text" name="Price"
                                              placeholder="Enter Price" />
                            </label>
                        </div>



                        <div class="item"> <label>
                                <div class="lbl"> Payment:
                                    <span class="error" id="errPayment"> </span>
                                </div> <input id="Payment" class="inputBox" type="text" name="Payment"
                                              placeholder="Enter Payment" />
                            </label>
                        </div>
                        <div class="item"> <label>
                                <div class="lbl"> Payment DateTime
                                    <span class="error" id="errPaymentDateTime"> </span>
                                </div> <input id="Payment_DateTime" class="inputBox" type="text" name="Payment_DateTime"
                                              placeholder="Enter Payment DateTime" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> Rent Start Date:
                                    <span class="error" id="errRentStartDate"> </span>
                                </div> <input id="RentStartDate" class="inputBox" type="date" name="RentStartDate" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> Rent End Date:
                                    <span class="error" id="errRentEndDate"> </span>
                                </div> <input id="RentEndDate" class="inputBox" type="date" name="RentEndDate" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> Renter National ID:
                                    <span class="error" id="errRenterNationalID"> </span>
                                </div> <input id="RenterNationalID" class="inputBox" type="text" name="RenterNationalID"
                                              placeholder="Please enter the national number of the tenant" />
                            </label>
                        </div>

                        <div class="item"> <label>
                                <div class="lbl"> Renter Name:
                                    <span class="error" id="errRenterName"> </span>
                                </div> <input id="RenterName" class="inputBox" type="text" name="RenterName"
                                              placeholder="Please enter the Renter Name" />
                            </label>
                        </div>
                        <div  class="btnn">
                            <div class="item"> <input type="submit" value="Submit" class="btnsub" /> </div>
                        </div>


                    </form>

                </div>

            </div>
            <!-- end add Apartment-->

            <!--start footer-->
            <footer>
                <p>
                    Copyright &copy; All Right Reserved To Makkah Hotel

                </p>
            </footer>
            <!--end footer-->
        </div>
        <%} else {%>
        <div class="container">

            <!--start navg-->
            <div class="nav-container">
                <div class="nav">
                    <h3 class="logo">Makkah Hotel</h3>
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="register.html">Register </a></li>
                        <li><a href="Login.html">Login</a></li>
                        <li><a href="AddFeedback.html">Feedback</a></li>
                    </ul>
                </div>
            </div>
            <!--end navg-->

            <div class="add-correct">
                <p class="wrong-masg"> You cannot access the page because you do not have access. </p>
                <img class="center" src="./images/sad.png" alt="" />
            </div>

            <!--start footer-->
            <footer>
                <p>
                    Copyright &copy; All Right Reserved To Makkah Hotel

                </p>
            </footer>
            <%}%>
    </body>

</html>

