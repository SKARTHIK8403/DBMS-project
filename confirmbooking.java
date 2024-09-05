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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
public class confirmbooking extends HttpServlet {

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
            out.println("<title>confirmbooking</title>");
            out.println("    <style>\n"
                    + "        body {\n"
                    + "            margin: 0;\n"
                    + "            font-family: Arial, sans-serif;                       \n"
                    + "            padding: 0;\n"
                    + "            height: 100%;"
                    + " background-color: #f5f5f5;\n"
                    + "        }\n"
                    + "        \n"
                    + "\n"
                    + "        header {\n"
                    + "            background-color: #f2f2f2;\n"
                    + "            padding: 20px;\n"
                    + "            text-align: center;\n"
                    + "        }\n"
                    + "\n"
                    + "        .logo {\n"
                    + "            max-width: 300px;\n"
                    + "            height: auto;\n"
                    + "            vertical-align: middle;\n"
                    + "        }\n"
                    + "\n"
                    + "        h1 {\n"
                    + "            color: black;\n"
                    + "            margin: 0;\n"
                    + "        }\n"
                    + "\n"
                    + "        nav {\n"
                    + "            background-color: #333;\n"
                    + "            text-align: center;\n"
                    + "            padding: 10px 0;\n"
                    + "        }\n"
                    + "\n"
                    + "        nav a {\n"
                    + "            color: white;\n"
                    + "            text-decoration: none;\n"
                    + "            padding: 10px 20px;\n"
                    + "        }\n"
                    + "\n"
                    + "        nav a:hover {\n"
                    + "            background-color: #555;\n"
                    + "        }\n"
                    + "\n"
                    + "        #slideshow-container {\n"
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
                    + "        }      \n"
                    + "        .b{\n"
                    + "            color:gold;\n"
                    + "            padding:40px;            \n"
                    + "            margin:50px;\n"
                    + "            margin-left: 20px;\n"
                    + "            margin-right: 20px;\n"
                    + "            border: 2px solid black;\n"
                    + "            background-size: 100%; \n"
                    + "            height:500px;\n"
                    + "            background-image: url(blue.jpg);\n"
                    + "            background-repeat: no-repeat;\n"
                    + "            background-position:center;\n"
                    + "        }\n"
                    + "        .h{\n"
                    + "            padding:40px;            \n"
                    + "            margin:50px;\n"
                    + "            margin-left: 20px;\n"
                    + "            margin-right: 20px;\n"
                    + "            border: 2px solid black;\n"
                    + "            background-size: 100%; \n"
                    + "            height:500px;\n"
                    + "            background-image: url(h.jpg);\n"
                    + "            background-repeat: no-repeat;\n"
                    + "            background-position:center;\n"
                    + "        }\n"
                    + "        .p{            \n"
                    + "            padding:40px;            \n"
                    + "            margin:50px;\n"
                    + "            margin-left: 20px;\n"
                    + "            margin-right: 20px;\n"
                    + "            border: 2px solid black;\n"
                    + "            background-size: 100%; \n"
                    + "            height:500px;\n"
                    + "            background-image: url(pi.jpeg);\n"
                    + "            background-repeat: no-repeat;\n"
                    + "            background-position:center;\n"
                    + "        }\n"
                    + "         .intro {\n"
                    + "             margin-left: 8px;\n"
                    + "             margin-right: 8px;\n"
                    + "             border: 2px solid black;\n"
                    + "             font-family: 'Segoe Print';\n"
                    + "             font-size: 15px;    \n"
                    + "             text-align: center;\n"
                    + "         }  \n"
                    + "             .footer {\n"
                    + "            background-color: #333;\n"
                    + "            color: #fff;\n"
                    + "            padding: 20px;\n"
                    + "            text-align: center;            \n"
                    + "            bottom: 0;\n"
                    + "            width: 100%;\n"
                    + "           }\n"
                    + "\n"
                    + "          .footer p {\n"
                    + "            margin: 0;\n"
                    + "          }  \n"
                    + "          .footer a {\n"
                    + "        text-decoration: none;\n"
                    + "        color:white;\n"
                    + "        font-size: 15px;\n"
                    + "        }\n"
                    + "        .steps {\n"
                    + "            list-style-type: none;\n"
                    + "            padding: 0;\n"
                    + "        }\n"
                    + "\n"
                    + "        .steps li {\n"
                    + "            margin-bottom: 10px;\n"
                    + "        }\n"
                    + "\n"
                    + "        .steps li::before {\n"
                    + "            content: \"\\2022\"; \n"
                    + "            color:#330033;\n"
                    + "            font-weight: bold;\n"
                    + "            display: inline-block;\n"
                    + "            width: 1em;\n"
                    + "            margin-left: -1em;\n"
                    + "        }        \n"
                    + ".container {\n"
                    + "    max-width: 800px;\n"
                    + "    margin: 50px auto;\n"
                    + "    padding: 20px;\n"
                    + "    background-color: #f0f8ff;\n"
                    + "    border-radius: 10px;\n"
                    + "    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n"
                    + "}\n"
                    + "\n"
                    + "h1 {\n"
                    + "    color: #333;\n"
                    + "    text-align: center;\n"
                    + "}\n"
                    + "\n"
                    + "h2 {\n"
                    + "    color: #555;\n"
                    + "    margin-bottom: 10px;\n"
                    + "}\n"
                    + "\n"
                    + "ul {\n"
                    + "    list-style: none;\n"
                    + "    padding: 0;\n"
                    + "}\n"
                    + "\n"
                    + "p {\n"
                    + "    margin: 0;\n"
                    + "    padding: 5px 0;\n"
                    + "}\n"
                    + "\n"
                    + ".price {\n"
                    + "    font-weight: bold;\n"
                    + "    color: #009688;\n}"
                    + ".payment-button {\n"
                    + "    display: inline-block;\n"
                    + "    padding: 10px 20px;\n"
                    + "    background-color: #007bff; /* Blue color */\n"
                    + "    color: white;\n"
                    + "    text-decoration: none;\n"
                    + "    border: none;\n"
                    + "    border-radius: 5px;\n"
                    + "    cursor: pointer;"
                    + "    position:center;\n"
                    + "}\n"
                    + "\n"
                    + ".payment-button:hover {\n"
                    + "    background-color: #0056b3; /* Darker blue color on hover */\n"
                    + "}</style>");
            out.println("</head>");
            out.println("<body>");

            //out.println("<h1>Servlet confirmbooking at " + request.getContextPath() + "</h1>");
            out.println(""
                    + "<header>\n"
                    + "    <img class=\"logo\" src=\"dbms logo.jpeg\" alt=\"TOURGUIDE\">\n"
                    + "    <h1 style='color:black;'>TOURGUIDE</h1>      \n"
                    + "</header>\n"
                    + "<nav> \n"
                    + "    <a href=\"HomeI.html\">Home</a>\n"                    
                    + "    <a href=\"#footer\">Contact Us </a>\n"
                    + "    <a href=\"HomeI.html\">Travel Now</a>        \n"
                    + "</nav>\n"
                    + "\n"
                    + "<div id=\"slideshow-container\">\n"
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
                    + "</div>"
                    + "<script>\n"
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
                    + "</script>");
            String[] selectedPlaces = request.getParameterValues("places");
            String selectedHotel = request.getParameter("hotel");
            String checkInDateStr = request.getParameter("checkin");
            String checkOutDateStr = request.getParameter("checkout");
            int numGuests = Integer.parseInt(request.getParameter("guests"));
            String bname = request.getParameter("bname");
            int phno = Integer.parseInt(request.getParameter("phno"));
            LocalDate checkInDate = LocalDate.parse(checkInDateStr);
            LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);
            long numNights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            out.println("<div class='container'><h1>Booking Confirmation</h1>");
            out.println("<h2>Selected Places:</h2>");
            out.println("<ul>");
            if (selectedPlaces != null) {
                for (String place : selectedPlaces) {
                    out.println("<li>" + place + "</li>");
                }
            }
            out.println("</ul>");
            out.println("<h2>Booking Name:</h2>");
            out.println("<p>" + bname + "</p>");
            out.println("<h2>Phone Number:</h2>");
            out.println("<p>" + phno + "</p>");
            out.println("<h2>Selected Hotel:</h2>");
            out.println("<p>" + selectedHotel + "</p>");
            out.println("<h2>Check-in Date:</h2>");
            out.println("<p>" + checkInDateStr + "</p>");
            out.println("<h2>Check-out Date:</h2>");
            out.println("<p>" + checkOutDateStr + "</p>");
            out.println("<h2>Number of Guests:</h2>");
            out.println("<p>" + numGuests + "</p>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itinerary", "root", "root123");
            String query = "SELECT price FROM hotels WHERE hotel_name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, selectedHotel);
            ResultSet priceResult = pstmt.executeQuery();
            double totalPrice = 0;
            if (priceResult.next()) {
                double price = priceResult.getDouble("price");
                out.println("<p class='price'>Price: " + price + "</p>");
                totalPrice = price * numNights;
                out.println("<h2>Total Price:</h2>");
                out.println("<p class='totalprice'>" + totalPrice + "</p>");
            } else {
                out.println("<p>No price found for the selected hotel.</p>");
            }
            String query2 = "INSERT INTO user_itinerary (hotel_name, num_guests, check_in_date, check_out_date, price, bname,phno ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt2 = con.prepareStatement(query2);
            pstmt2.setString(1, selectedHotel);
            pstmt2.setInt(2, numGuests);
            pstmt2.setString(3, checkInDateStr);
            pstmt2.setString(4, checkOutDateStr);
            pstmt2.setDouble(5, totalPrice);
            pstmt2.setString(6, bname);
            pstmt2.setInt(7, phno);
            pstmt2.executeUpdate();
            priceResult.close();
            pstmt.close();
            con.close();
            out.println("<a href='paymentpg.html'><button type='submit' name='pay'>Pay Now</button></a></div>");
            out.println("<div class=\"footer\" id=\"footer\">");
            out.println("<p id=\"phone\">Phone: +91 12345 67890</p>\n"
                    + "    <p id=\"email\">Email: example@example.com</p>");
            out.println("<p>&copy; 2024 Your TourGuide. All rights reserved.</p>");
            out.println("</div>");
            out.println("</div></body>");
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
            Logger.getLogger(confirmbooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(confirmbooking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(confirmbooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(confirmbooking.class.getName()).log(Level.SEVERE, null, ex);
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
