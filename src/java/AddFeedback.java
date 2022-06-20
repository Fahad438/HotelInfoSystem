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
public class AddFeedback extends HttpServlet {

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
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("USER");
        if (userName != null) {

            try {
                String uname = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String Subject = request.getParameter("Subject");
                String Type = request.getParameter("Type");
                String message = request.getParameter("message");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Feddback Done </title>");
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

                String sql = "INSERT INTO Feedbacks (Name, Phone, Email, "
                        + "Subject, Type, Message, creationDateTime) VALUES (?, ?, ?, ?, ?, ?, NOW())";   //NOW() mysql function
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, uname);             // 1 specifies the first parameter in the query  
                pStmt.setString(2, phone);             // 2 specifies the second parameter in the query
                pStmt.setString(3, email);              // 3 specifies the second parameter in the query
                pStmt.setString(4, Subject);           // 4 specifies the second parameter in the query
                pStmt.setString(5, Type);               // 5 specifies the second parameter in the query
                pStmt.setString(6, message);            // 6 specifies the second parameter in the query

                int k = pStmt.executeUpdate();     // returns number of affected rows

                if (k == 1) {
                    //insert a record success

                    out.println("<p class=\"correct-feedback\"> Thank you for sending your feedback. We hope to help you as soon as possible. </p>");
                    out.println(" <img class=\"center\" src=\"./images/happiness.png\" alt=\"\" />");
                } else // i.e.  k = 0
                {
                    //insert a record error
                    out.println("<p class=\"wrong-masg\"> There was an error in adding the data! Try again. </p>");
                    out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
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
                out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
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
        }else{

        try {
            String uname = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String Subject = request.getParameter("Subject");
            String Type = request.getParameter("Type");
            String message = request.getParameter("message");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Feddback Done </title>");
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
            out.println(" <li><a href=\"index.html\">Home</a></li>");//هنا 
            out.println("<li><a href=\"register.html\">Regsiter</a></li>");
            out.println(" <li><a href=\"Login.html\">Login</a></li>");
            out.println("<li><a href=\"http://localhost:8080/HISystem/Feedback\">Feedback</a></li>");
          
            out.println("</ul>");
          
            
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"add-correct\">");

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO Feedbacks (Name, Phone, Email, "
                    + "Subject, Type, Message, creationDateTime) VALUES (?, ?, ?, ?, ?, ?, NOW())";   //NOW() mysql function
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, uname);             // 1 specifies the first parameter in the query  
            pStmt.setString(2, phone);             // 2 specifies the second parameter in the query
            pStmt.setString(3, email);              // 3 specifies the second parameter in the query
            pStmt.setString(4, Subject);           // 4 specifies the second parameter in the query
            pStmt.setString(5, Type);               // 5 specifies the second parameter in the query
            pStmt.setString(6, message);            // 6 specifies the second parameter in the query

            int k = pStmt.executeUpdate();     // returns number of affected rows

            if (k == 1) {
                //insert a record success

                out.println("<p class=\"correct-feedback\"> Thank you for sending your feedback. We hope to help you as soon as possible. </p>");
                out.println(" <img class=\"center\" src=\"./images/happiness.png\" alt=\"\" />");
            } else // i.e.  k = 0
            {
                //insert a record error
                out.println("<p class=\"wrong-masg\"> There was an error in adding the data! Try again. </p>");
                out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
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
            out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
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
}
