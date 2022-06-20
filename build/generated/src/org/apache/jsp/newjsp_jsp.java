package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <meta name=\"description\" content=\"Hotel\">\n");
      out.write("        <meta name=\"keywords\" content=\"Hotel,hotel,Best Hotel,holiday,the summer,Summer,5-star hotel\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\n");
      out.write("        <script src=\"script/site.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Feedback</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
if (session.getAttribute("USER") != null) {
      out.write("\n");
      out.write("               \n");
      out.write("      \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!--start navg-->\n");
      out.write("            <div class=\"nav-container\">\n");
      out.write("                <div class=\"nav\">\n");
      out.write("                    <h3 class=\"logo\">Makkah Hotel</h3>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                        <li><a href=\"register.html\">Regsiter</a></li>\n");
      out.write("                        <li><a href=\"Login.html\">Login</a></li>\n");
      out.write("                        <li><a href=\"http://localhost:8080/HISystem/Feedback\">Feedback</a></li>\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--end navg-->\n");
      out.write("\n");
      out.write("            <!--start Add Feedback-->\n");
      out.write("            <div class=\"Add\">\n");
      out.write("                <h1>FeedBack</h1>\n");
      out.write("                <div class=\"form\">\n");
      out.write("                    <form action=\"AddFeedback\" method=\"post\" onsubmit=\" return validatefeedback()\">\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"\">\n");
      out.write("                                Name: <span class=\"erro\">*</span> <span class=\"error\" id=\"errname\"></span>\n");
      out.write("                                <input type=\"text\" placeholder=\"Enter you are name\" name=\"name\" id=\"name\">\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"\">\n");
      out.write("                                Phone <span class=\"erro\">*</span> <span class=\"error\" id=\"errphone\"></span>\n");
      out.write("                                <input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"Enter you are Number Phone\">\n");
      out.write("\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"\">\n");
      out.write("                                Email <span class=\"erro\">*</span> <span class=\"error\" id=\"erremail\"></span>\n");
      out.write("                                <input id=\"email\" name=\"email\" type=\"text\" placeholder=\"Enter you are email\">\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"\">\n");
      out.write("                                Subject <span class=\"error\" id=\"errsubject\"></span>\n");
      out.write("                                <input name=\"Subject\" id=\"Subject\" type=\"text\" placeholder=\"Enter you are Subject\">\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"\">\n");
      out.write("                                <div>\n");
      out.write("                                    Type  <span class=\"erro\">*</span><span class=\"error\" id=\"errtype\"></span>\n");
      out.write("                                </div>\n");
      out.write("                                <select  id=\"Type\"  name=\"Type\">\n");
      out.write("\n");
      out.write("                                    <option> Please select your type... </option>\n");
      out.write("                                    <option >complaint</option>\n");
      out.write("                                    <option >recovery</option>\n");
      out.write("                                    <option >Suggestion</option>\n");
      out.write("                                    <option>other</option>\n");
      out.write("                                </select>\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <label for=\"\">\n");
      out.write("                            Message:<span class=\"erro\">*</span> <span class=\"error\" id=\"errmesage\"></span>\n");
      out.write("\n");
      out.write("                            <textarea class=\"message\" name=\"message\" id=\"message\" placeholder=\"Enter feedback here\"></textarea>\n");
      out.write("\n");
      out.write("                        </label>\n");
      out.write("                        <input type=\"submit\" value=\"Submit\" class=\"btnsub\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--end Add Feedback-->\n");
      out.write("\n");
      out.write("            <!--start footer-->\n");
      out.write("            <footer>\n");
      out.write("                <p> \n");
      out.write("                    Copyright &copy; All Right Reserved To Makkah Hotel\n");
      out.write("                </p>\n");
      out.write("            </footer>\n");
      out.write("            <!--end footer-->\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("  ");
} else {
      out.write("\n");
      out.write("           <p> \n");
      out.write("                    Copyright &copy; All Right Reserved To Makkah Hotel\n");
      out.write("                </p>  \n");
      out.write("        ");
}
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
