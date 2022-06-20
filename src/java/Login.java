/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fahad
 */
public class Login extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_information_system";

    //  Database credentials
    static final String USER = "Fahad";
    static final String PASS = "fahad767686";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String salat = "There was a mans12@$@4&#%^$* playing football";
        String hash = SHA512(password + salat);
        
        
        PrintWriter out = resp.getWriter();
          out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Login </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\"/>");
            out.println(" <meta name=\"description\" content=\"Hotel\">");
            out.println("  <meta name=\"keywords\" content=\"Hotel,hotel,Best Hotel,holiday,the summer,Summer,5-star hotel\">");
           

        if (isLoginValid(username, hash)) {
            HttpSession session = req.getSession();
            session.setAttribute("USER", username);
            resp.sendRedirect("MainServlet");
        } else {
            out.println("<meta http-equiv=\"refresh\" content=\"4; url='Login.html'\" />");
             out.println("</head>");
            out.println("<body>");
              out.println("<p class=\"wrong-masg\"> Username or password incorrect</p>");
            out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
            
             out.println("<p class=\"wrong-masg\"> You will be redirected to the login page in seconds</p>");
            
            
       
            out.println("</body>");
            out.println("</html>");

        }

    }

    public boolean isLoginValid(String username, String password) {
        boolean status = false;
        try {
            //Loading and register a JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "select UserName, Password from Users where UserName =  ? and  Password =  ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            status = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;//هنا

    }

    public static String SHA512(String input) {
        String SHA512 = null;
        if (null == input) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex)
            SHA512 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return SHA512;
    }
}
