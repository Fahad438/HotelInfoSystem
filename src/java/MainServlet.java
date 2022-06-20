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
public class MainServlet extends HttpServlet {

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
            out.println("<title> Home </title>");
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

            out.println("<!--start hero-->\n"
                    + "            <div class=\"hero\">\n"
                    + "                <div class=\"content\">\n"
                    + "                    <h1>Make <span>Way</span> for Summer</h1>\n"
                    + "                    <h4>\n"
                    + "\n"
                    + "                        That \"anything is possible\" season is almost here. Where will you spend it?\n"
                    + "                    </h4>\n"
                    + "                    <a href=\"#qualities\" class=\"btn\"> Know more about us </a>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <!--end hero-->\n"
                    + "\n"
                    + "            <!--start services-->\n"
                    + "            <section id=\"services\">\n"
                    + "                <h2>OUR SERVICES</h2>\n"
                    + "                <div class=\"services-container\">\n"
                    + "\n"
                    + "                    <div class=\"service\">\n"
                    + "                        <div class=\"header-container\">\n"
                    + "                            <i class=\"fas fa-tachometer-alt\"></i>\n"
                    + "                            <h3>Room service</h3>\n"
                    + "                        </div>\n"
                    + "                        <p>\n"
                    + "                            Room service is available around the clock at great rates and very fast service \n"
                    + "                            ,Our motto is customer convenience\n"
                    + "                        </p>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"service\">\n"
                    + "                        <div class=\"header-container\">\n"
                    + "                            <i class=\"fas fa-star\"></i>\n"
                    + "                            <h3>Places of entertainment</h3>\n"
                    + "                        </div>\n"
                    + "                        <p>\n"
                    + "                            We offer the customer beautiful recreational places such as swimming pools, gyms, children's areas, as well as football fields\n"
                    + "                        </p>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"service\">\n"
                    + "                        <div class=\"header-container\">\n"
                    + "                            <i class=\"fas fa-money-bill-wave-alt\"></i>\n"
                    + "                            <h3>Restaurants</h3>\n"
                    + "                        </div>\n"
                    + "                        <p>\n"
                    + "                            We offer the customer distinguished 5-star restaurants that serve the finest types of food and also at very nice prices\n"
                    + "                        </p>\n"
                    + "                    </div>\n"
                    + "            </section>\n"
                    + "            <!--end services-->\n"
                    + "\n"
                    + "            <!--start about--> \n"
                    + "            <div id='aboutus' class=\"about-container\">\n"
                    + "                <section class=\"about-us\">\n"
                    + "                    <div class=\"about-content\">\n"
                    + "                        <h2>Who?</h2>\n"
                    + "                        <p>\n"
                    + "                            A 5-star hotel that is considered one of the oldest hotels in the world. Recipients of several international awards. We are considered the best in this field\n"
                    + "\n"
                    + "                        </p>\n"
                    + "                    </div>\n"
                    + "                    <img src=\"./images/who.jpg\" alt=\"\" />\n"
                    + "\n"
                    + "\n"
                    + "            </div>\n"
                    + "        </section>\n"
                    + "    </div>\n"
                    + "    <!--end about--> \n"
                    + "\n"
                    + "\n"
                    + "    <!-- start imge -->\n"
                    + "    <div class=\"imge\">\n"
                    + "\n"
                    + "        <h2>Image Hotel</h2>\n"
                    + "        <div class=\"allimage\">\n"
                    + "            <img src=\"images/wallpaperflare.com_wallpaper (7).jpg\" alt=\"\">\n"
                    + "\n"
                    + "            <img src=\"images/nav.jpg\" alt=\"\">\n"
                    + "            <img src=\"images/hotel5.jpg\" alt=\"\">\n"
                    + "\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <!--end image-->");

            out.println("</div>");
            out.println("<footer>");
            out.println("<p> Copyright &copy; All Right Reserved To Makkah Hotel  </p>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        } else {
            resp.sendRedirect("Login.html");
        }
    }
}
