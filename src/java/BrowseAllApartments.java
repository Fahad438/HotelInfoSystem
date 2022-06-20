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
import javax.servlet.http.HttpSession;

/**
 *
 * @author fahad
 */
public class BrowseAllApartments extends HttpServlet {

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("USER");
        if (userName != null) {
            try {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Apartment details </title>");
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

                //Loading and register a JDBC Driver
                Class.forName(JDBC_DRIVER);

                //Establishing a Connection
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                String sql = "select * from Apartments";

                PreparedStatement pStmt = conn.prepareStatement(sql);
                ResultSet rs = pStmt.executeQuery();

                if (!rs.isBeforeFirst()) {
                    out.println("<p> No registration records in database! </p>");
                } else {

                    out.println("<div class=\"table-con\">");
                    out.println("<table class=\"table\" >");

                    out.println("<tr> <th> ID </th> <th> Apartment Number </th> <th> Floor_Number </th> <th> Number_Of_Rooms </th> <th> Occupied </th><th> Price </th>"
                            + " <th> Payment </th> <th> Payment_DateTime </th> <th> Rent_Start_Date </th> <th> Rent_End_Date </th> <th> Renter_National_ID </th> "
                            + " <th> Renter_Name </th> <th> creationDateTime </th> </tr>");

                    while (rs.next()) {

                        out.println("<tr>");

                        out.println("<td>" + rs.getInt("id") + "</td>");
                        out.println("<td>" + rs.getString("Apartment_Number") + "</td>");
                        out.println("<td>" + rs.getString("Floor_Number") + "</td>");
                        out.println("<td>" + rs.getString("Number_Of_Rooms") + "</td>");
                        out.println("<td>" + rs.getString("Occupied") + "</td>");
                        out.println("<td>" + rs.getString("Price") + "</td>");
                        out.println("<td>" + rs.getString("Payment") + "</td>");
                        out.println("<td>" + rs.getString("Payment_DateTime") + "</td>");
                        out.println("<td>" + rs.getString("Rent_Start_Date") + "</td>");
                        out.println("<td>" + rs.getString("Rent_End_Date") + "</td>");
                        out.println("<td>" + rs.getString("Renter_National_ID") + "</td>");
                        out.println("<td>" + rs.getString("Renter_Name") + "</td>");

                        out.println("<td>" + rs.getTimestamp("creationDateTime") + "</td>");

                        out.println("</tr>");

                    }

                    out.println("</table>");
                    out.println("</div>");
                }

                conn.close();

            } catch (Exception ex) {

                out.println("<p class=\"error\"> There was an error exception meesage: " + ex + "</p>");

            } finally {
                out.println("</div>");
                out.println("</div>");
                out.println("<footer>");
                out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
                out.println("</footer>");
                out.println("</body>");
                out.println("</html>");

                out.close();
            }
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Apartment details </title>");
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
            out.println(" <li><a href=\"index.html\">Home </a></li>");//هنا 

            out.println(" <li><a href=\"Login.html\">Login </a></li>");
            out.println(" <li><a href=\"register.html\">Register</a></li>");
            out.println(" <li><a href=\"http://localhost:8080/HISystem/Feedback\">Feedback</a></li>");//هنا
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"add-correct\">");
            out.println("<p class=\"wrong-masg\"> You cannot access the page because you do not have access. </p>");
            out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
            out.println("</div>");
            out.println("<footer>");
            out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
