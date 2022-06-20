/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author fahad
 */
public class AddApartment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_information_system";

    //  Database credentials
    static final String USER = "Fahad";
    static final String PASS = "fahad767686";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String Apartment = request.getParameter("Apartment");
            String Floor = request.getParameter("Floor");
            String Room = request.getParameter("Room");
            String occupied = request.getParameter("occupied");
            String Price = request.getParameter("Price");

            String Payment = request.getParameter("Payment");

            String Payment_DateTime = request.getParameter("Payment_DateTime");
            String RentStartDate = request.getParameter("RentStartDate");
            String RentEndDate = request.getParameter("RentEndDate");
            String RenterNationalID = request.getParameter("RenterNationalID");
            String RenterName = request.getParameter("RenterName");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add New Apartment Record  </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\"/>");

            out.println(" <meta name=\"description\" content=\"Hotel\">");
            out.println("  <meta name=\"keywords\" content=\"Hotel,hotel,Best Hotel,holiday,the summer,Summer,5-star hotel\">");

            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<div class=\"nav-container\">");
            out.println("<div class=\"nav\">");
            out.println(" <h3 class=\"logo\">Makkah Hotel</h3>");
            out.println("<ul>");
            out.println(" <li><a href=\"http://localhost:8080/HISystem/MainServlet\">Home </a></li>");//هنا 
            out.println("<li><a href=\"AddNewApartment Record.jsp\">Reservation</a></li>");
            out.println(" <li><a href=\"http://localhost:8080/HISystem/BrowseAllApartments\">Apartment </a></li>");
            out.println(" <li><a href=\"http://localhost:8080/HISystem/Feedback\">Feeddback</a></li>");
            out.println(" <li><a href=\"http://localhost:8080/HISystem/Logout\">Logout</a></li>");//هنا
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"add-correct\">");

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO Apartments (Apartment_Number, Floor_Number, Number_Of_Rooms, "
                    + "Occupied, Price, Payment, Payment_DateTime, Rent_Start_Date, Rent_End_Date, "
                    + "Renter_National_ID, Renter_Name, creationDateTime) VALUES (?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, NOW())";   //NOW() mysql function
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, Apartment);               
            pStmt.setString(2, Floor);            
            pStmt.setString(3, Room);
            pStmt.setString(4, occupied);
            pStmt.setString(5, Price);
            pStmt.setString(6, Payment);
            pStmt.setString(7, Payment_DateTime);
            pStmt.setString(8, RentStartDate);
            pStmt.setString(9, RentEndDate);
            pStmt.setString(10, RenterNationalID);
            pStmt.setString(11, RenterName);

          
            int k = pStmt.executeUpdate();     // returns number of affected rows

            if (k == 1) {
                //insert a record success
                out.println("<p class=\"correct\"> Data was added successfully. </p>");
                out.println("<img class=\"center\" src=\"images/correct.png\" alt=\"\" />");

            } else // i.e.  k = 0
            {
                //insert a record error
                out.println("<p class=\"wrong-masg\"> There was an error in adding the data! Try again. </p>");
                out.println("<img class=\"center\" src=\"images/remove.png\" alt=\"\" />");
            }

            out.println("</div>");
            out.println("<footer>");
            out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("<p class=\"wrong-masg\"> There was an error exception meesage: " + ex + "</p>");
            out.println("<img class=\"center\" src=\"images/remove.png\" alt=\"\" />");
            out.println("</div>");
            out.println("</div>");
            out.println("<footer>");
            out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
            out.println("</footer>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

   
}
