/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itinerary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author preethi
 */
public class bookplacebe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Coorg Booking</title>");
            out.println("<style>");
            out.println("body { margin: 0; font-family: Arial, sans-serif; padding: 0; height: 100%; position: relative; }");
            out.println("header { background-color: #f2f2f2; padding: 20px; text-align: center; }");
            out.println(".logo { max-width: 300px; height: auto; vertical-align: middle; }");
            out.println("h1 { color: black; margin: 0; }");
            out.println("nav { background-color: #333; text-align: center; padding: 10px 0; }");
            out.println("nav a { color: white; text-decoration: none; padding: 10px 20px; }");
            out.println("nav a:hover { background-color: #555; }.result {\n"
                    + "    margin-top: 10px; /* Adjust as needed */\n"
                    + "    padding-left: 20px; /* Adjust as needed for indentation */\n"
                    + "    font-size: 16px; /* Adjust as needed */\n"
                    + "    color: #333; /* Adjust as needed */\n"
                    + "    /* Add more styles as needed */\n"
                    + "}\n"
                    + "\n"
                    + ".result li {\n"
                    + "    list-style-type: disc; /* Adjust as needed */\n"
                    + "    /* Add more styles for list items as needed */\n"
                    + "}.footer {\n"
                    + "    background-color: #333;\n"
                    + "    color: #fff;\n"
                    + "    padding: 20px;\n"
                    + "    text-align: center;\n"
                    + "    bottom: 0;\n"
                    + "    width: 100%;\n"
                    + "}\n"
                    + "\n"
                    + ".footer p {\n"
                    + "    margin: 0;\n"
                    + "}\n"
                    + "\n"
                    + ".footer a {\n"
                    + "    text-decoration: none;\n"
                    + "    color: white;\n"
                    + "    font-size: 15px;\n"
                    + "}#slideshow-container {\n"
                    + "            position: relative;\n"
                    + "            max-width: 100%;\n"
                    + "            overflow: hidden;\n"
                    + "            margin-bottom: 20px;\n"
                    + "        }\n"
                    + "\n"
                    + "        .mySlides {\n"
                    + "            display: none;\n"
                    + "            width: 100%;\n"
                    + "            height: 200px;\n"
                    + "        }\n"
                    + "\n"
                    + "        .slide-img {\n"
                    + "            width: 100%;\n"
                    + "            height: 400px;\n"
                    + "        }\n"
                    + "\n"
                    + "        .prev, .next {\n"
                    + "            cursor: pointer;\n"
                    + "            position: absolute;\n"
                    + "            top: 50%;\n"
                    + "            width: auto;\n"
                    + "            padding: 16px;\n"
                    + "            margin-top: -22px;\n"
                    + "            color: white;\n"
                    + "            font-weight: bold;\n"
                    + "            font-size: 18px;\n"
                    + "            transition: 0.6s ease;\n"
                    + "            border-radius: 0 3px 3px 0;\n"
                    + "            background-color: rgba(0, 0, 0, 0.5);\n"
                    + "        }\n"
                    + "\n"
                    + "        .next {\n"
                    + "            right: 0;\n"
                    + "            border-radius: 3px 0 0 3px;\n"
                    + "        }\n"
                    + "\n"
                    + "        .prev:hover, .next:hover {\n"
                    + "            background-color: rgba(0, 0, 0, 0.8);\n"
                    + "        }\n"
                    + "\n"
                    + "        .dot {\n"
                    + "            height: 15px;\n"
                    + "            width: 15px;\n"
                    + "            margin: 0 2px;\n"
                    + "            background-color: #bbb;\n"
                    + "            border-radius: 50%;\n"
                    + "            display: inline-block;\n"
                    + "            transition: background-color 0.6s ease;\n"
                    + "        }\n"
                    + "\n"
                    + "        .active {\n"
                    + "            background-color: #717171;\n"
                    + "        }    "
                    + " .container {\n"
                    + "    max-width: 90%;\n"
                    + "    margin: 50px auto;\n"
                    + "    padding: 20px;\n"
                    + "    background-color: #fff;\n"
                    + "    border-radius: 10px;\n"
                    + "    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n"
                    + "}\n"
                    + "\n"
                    + "h2 {\n"
                    + "    text-align: center;\n"
                    + "    margin-bottom: 20px;\n"
                    + "}\n"
                    + "\n"
                    + ".result {\n"
                    + "    list-style: none;\n"
                    + "    padding: 0;\n"
                    + "}\n"
                    + "\n"
                    + ".result li {\n"
                    + "    margin-bottom: 10px;\n"
                    + "}\n"
                    + "\n"
                    + "input[type=\"checkbox\"] {\n"
                    + "    margin-right: 10px;\n"
                    + "}\n"
                    + "\n"
                    + "input[type=\"submit\"] {\n"
                    + "    display: block;\n"
                    + "    margin-top: 20px;\n"
                    + "    width: 100%;\n"
                    + "    padding: 10px;\n"
                    + "    background-color: #333;\n"
                    + "    color: #fff;\n"
                    + "    border: none;\n"
                    + "    border-radius: 5px;\n"
                    + "    cursor: pointer;\n"
                    + "}\n"
                    + "\n"
                    + "input[type=\"submit\"]:hover {\n"
                    + "    background-color: #555;\n"
                    + "} "
                    + ".hotel-list {\n"
                    + "    list-style: none;\n"
                    + "    padding: 0;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-list li {\n"
                    + "    margin-bottom: 20px;\n"
                    + "    border: 1px solid #ccc;\n"
                    + "    border-radius: 5px;\n"
                    + "    padding: 10px;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-name {\n"
                    + "    font-weight: bold;\n"
                    + "    color: #333;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-address {\n"
                    + "    color: #666;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-price {\n"
                    + "    font-size: 18px;\n"
                    + "    color: #009688;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-select {\n"
                    + "    margin-top: 10px;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-select label {\n"
                    + "    font-weight: bold;\n"
                    + "    margin-right: 10px;\n"
                    + "}\n"
                    + "\n"
                    + ".hotel-select input[type=\"text\"], .hotel-select input[type=\"date\"], .hotel-select select {\n"
                    + "    width: 200px;\n"
                    + "    padding: 5px;\n"
                    + "    border-radius: 5px;\n"
                    + "    border: 1px solid #ccc;\n"
                    + "    margin-bottom: 10px;\n"
                    + "}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<img class=\"logo\" src=\"dbms logo.jpeg\" alt=\"TOURGUIDE\">");
            out.println("<h1 style='color:black;'>TOURGUIDE</h1>");
            out.println("</header>");
            out.println("<nav>");
            out.println("<a href=\"HomeI.html\">Home</a>");
            out.println("<a href=\"Signup.html\">About Us</a>");
            out.println("<a href=\"Signup.html\">Contact Us</a>");
            out.println("</nav>        <div id=\"slideshow-container\">\n"
                    + "    <div class=\"mySlides\">\n"
                    + "        <img class=\"slide-img\" src=\"slideshow1.jpg\" alt=\"Slide 1\">\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"mySlides\">\n"
                    + "        <img class=\"slide-img\" src=\"slideshow2.jpg\" alt=\"Slide 2\">\n"
                    + "    </div>\n"
                    + "    <!-- Add more slides as needed -->\n"
                    + "    <div class=\"mySlides\">\n"
                    + "        <img class=\"slide-img\" src=\"slideshow3.jpg\" alt=\"Slide 2\">\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <a class=\"prev\" onclick=\"plusSlides(-1)\">❮</a>\n"
                    + "    <a class=\"next\" onclick=\"plusSlides(1)\">❯</a>\n"
                    + "    <script>\n"
                    + "    var slideIndex = 1;\n"
                    + "    showSlides(slideIndex);\n"
                    + "\n"
                    + "    function plusSlides(n) {\n"
                    + "        showSlides(slideIndex += n);\n"
                    + "    }\n"
                    + "\n"
                    + "    function showSlides(n) {\n"
                    + "        var i;\n"
                    + "        var slides = document.getElementsByClassName(\"mySlides\");\n"
                    + "\n"
                    + "        if (n > slides.length) {\n"
                    + "            slideIndex = 1;\n"
                    + "        }\n"
                    + "\n"
                    + "        if (n < 1) {\n"
                    + "            slideIndex = slides.length;\n"
                    + "        }\n"
                    + "\n"
                    + "        for (i = 0; i < slides.length; i++) {\n"
                    + "            slides[i].style.display = \"none\";\n"
                    + "        }\n"
                    + "\n"
                    + "        slides[slideIndex - 1].style.display = \"block\";\n"
                    + "    }\n"
                    + "\n"
                    + "    setInterval(function() {\n"
                    + "        plusSlides(1);\n"
                    + "    }, 2000);\n"
                    + "</script>\n"
                    + "</div>");
            // out.println("<h1>Servlet bookplacebe at " + request.getContextPath() + "</h1>");
            String dest = request.getParameter("coorg");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itinerary", "root", "root123");
            String sql = "SELECT place_name FROM places WHERE location = 'Coorg'; ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String hotelSql = "SELECT hotel_name, address, price FROM hotels WHERE location = 'Coorg'";
            Statement stmt1 = con.createStatement();
            ResultSet hotelRs = stmt1.executeQuery(hotelSql);
            out.println("<div class=\"container\">");
            out.println("<h2>Select the places to visit from the given list</h2>");
            out.println("<form action=\"confirmbooking\">");
            out.println("<ul class=\"result\">");
            while (rs.next()) {
                out.println("<li><input type=\"checkbox\" name=\"places\" value=\"" + rs.getString(1) + "\">" + rs.getString(1) + "</li>");
            }

            out.println("</ul>");
            out.println("<h2>Select the hotel and enter check-in and check-out details</h2>");
            out.println("<h3>Hotels:</h3>");
            out.println("<ul class=\"hotel-list\">");
            while (hotelRs.next()) {
                String hotelName = hotelRs.getString("hotel_name");
                String address = hotelRs.getString("address");
                double price = hotelRs.getDouble("price");
                out.println("<li>");
                out.println("<input type=\"radio\" name=\"hotel\" value=\"" + hotelName + "\">");
                out.println("<label>" + hotelName + "</label>");
                out.println("<p>Address: " + address + "</p>");
                out.println("<p>Price: " + price + "</p>");
                out.println("</li>");
            }
            out.println("<h3>Check-in and Check-out Details:</h3>");
            out.println("<label for=\"checkin\">Check-in Date:</label>");
            out.println("<input type=\"date\" id=\"checkin\" name=\"checkin\" required>");
            out.println("<label for=\"checkout\">Check-out Date:</label>");
            out.println("<input type=\"date\" id=\"checkout\" name=\"checkout\" required>");
            out.println("<label for=\"guests\">Number of Guests:</label>");            
            out.println("<input type=\"number\" id=\"guests\" name=\"guests\" required>");
            out.println("<label for=\"bname\">Enter Booking Name:</label>");
            out.println("<input type=\"text\" id=\"bname\" name=\"bname\" required>");
            out.println("<label for=\"phno\">Enter Phnoe Number:</label>");
            out.println("<input type=\"number\" id=\"phno\" name=\"phno\" required>");
            out.println("<input type=\"submit\" value=\"BOOK NOW\">");
            out.println("</form>");
            out.println("</div>");


            out.println("</ul>");
            out.println("</form>");
            out.println("</div>");
            hotelRs.close();
            stmt.close();
            con.close();
            out.println("<div class=\"footer\">");
            out.println("<a href=\"contact.html\">Contact US</a>");
            out.println("<p>&copy; 2024 Your TourGuide. All rights reserved.</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookplacebe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookplacebe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bookplacebe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(bookplacebe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
