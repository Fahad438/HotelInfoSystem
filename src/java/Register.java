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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fahad
 */
public class Register extends HttpServlet {

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
            String FullName = request.getParameter("FullName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String salat = "There was a mans12@$@4&#%^$* playing football";
            String hashed_passwd = SHA512(password + salat);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Register </title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\"/>");
            out.println(" <meta name=\"description\" content=\"Hotel\">");
            out.println("  <meta name=\"keywords\" content=\"Hotel,hotel,Best Hotel,holiday,the summer,Summer,5-star hotel\">");
       

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO Users (FullName, UserName, Password, CreationDataTime) VALUES (?, ?, ?, NOW())";   //NOW() mysql function
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, FullName);             // 1 specifies the first parameter in the query  
            pStmt.setString(2, username);             // 2 specifies the second parameter in the query
            pStmt.setString(3, hashed_passwd);              // 3 specifies the second parameter in the query
            // 6 specifies the second parameter in the query

            int k = pStmt.executeUpdate();     // returns number of affected rows

            if (k == 1) {
                //insert a record success

                response.sendRedirect("Login.html");
            } else // i.e.  k = 0
            {
                //insert a record error
         

            }
        

        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("<meta http-equiv=\"refresh\" content=\"4; url='register.html'\" />");
              out.println("</head>");
            out.println("<body>");
            out.println("<p class=\"wrong-masg\"> Email alredy exist</p>");
            out.println(" <img class=\"center\" src=\"./images/sad.png\" alt=\"\" />");
              out.println("<p class=\"wrong-masg\"> You will be redirected to the register page in seconds</p>");
       
            out.println("</body>");
            out.println("</html>");

        } finally {

            out.close();
        }
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
