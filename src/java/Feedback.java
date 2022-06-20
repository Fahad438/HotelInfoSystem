/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fahad
 */
public class Feedback extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("USER");
        if (userName != null) {
            resp.setContentType("text/html");
            ServletOutputStream out = resp.getOutputStream();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");

            out.println(" <script src=\"script/site.js\"></script>");
            out.println("<title> Feddback </title>");
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

            out.println("  <!--start Add Feedback-->\n"
                    + "            <div class=\"Add\">\n"
                    + "                <h1>FeedBack</h1>\n"
                    + "                <div class=\"form\">\n"
                    + "                    <form action=\"AddFeedback\" method=\"post\" onsubmit=\" return validatefeedback()\">\n"
                    + "                        <div>\n"
                    + "                            <label for=\"\">\n"
                    + "                                Name: <span class=\"erro\">*</span> <span class=\"error\" id=\"errname\"></span>\n"
                    + "                                <input type=\"text\" placeholder=\"Enter you are name\" name=\"name\" id=\"name\">\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "\n"
                    + "                        <div>\n"
                    + "                            <label for=\"\">\n"
                    + "                                Phone <span class=\"erro\">*</span> <span class=\"error\" id=\"errphone\"></span>\n"
                    + "                                <input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"Enter you are Number Phone\">\n"
                    + "\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "                        <div>\n"
                    + "                            <label for=\"\">\n"
                    + "                                Email <span class=\"erro\">*</span> <span class=\"error\" id=\"erremail\"></span>\n"
                    + "                                <input id=\"email\" name=\"email\" type=\"text\" placeholder=\"Enter you are email\">\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "\n"
                    + "                        <div>\n"
                    + "                            <label for=\"\">\n"
                    + "                                Subject <span class=\"error\" id=\"errsubject\"></span>\n"
                    + "                                <input name=\"Subject\" id=\"Subject\" type=\"text\" placeholder=\"Enter you are Subject\">\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "\n"
                    + "                        <div>\n"
                    + "                            <label for=\"\">\n"
                    + "                                <div>\n"
                    + "                                    Type  <span class=\"erro\">*</span><span class=\"error\" id=\"errtype\"></span>\n"
                    + "                                </div>\n"
                    + "                                <select  id=\"Type\"  name=\"Type\">\n"
                    + "\n"
                    + "                                    <option> Please select your type... </option>\n"
                    + "                                    <option >complaint</option>\n"
                    + "                                    <option >recovery</option>\n"
                    + "                                    <option >Suggestion</option>\n"
                    + "                                    <option>other</option>\n"
                    + "                                </select>\n"
                    + "                            </label>\n"
                    + "                        </div>\n"
                    + "\n"
                    + "\n"
                    + "                        <label for=\"\">\n"
                    + "                            Message:<span class=\"erro\">*</span> <span class=\"error\" id=\"errmesage\"></span>\n"
                    + "\n"
                    + "                            <textarea class=\"message\" name=\"message\" id=\"message\" placeholder=\"Enter feedback here\"></textarea>\n"
                    + "\n"
                    + "                        </label>\n"
                    + "                        <input type=\"submit\" value=\"Submit\" class=\"btnsub\">\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "                        \n"
                    + "                    </form>\n"
                    + "\n"
                    + "                </div>\n"
                    + "\n"
                    + "            </div>\n"
                    + "            <!--end Add Feedback-->");

            out.println("</div>");
            out.println("<footer>");
            out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        } else {
            resp.sendRedirect("AddFeedback.html");
        }
    }
}
