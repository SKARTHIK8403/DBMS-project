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
public class booking extends HttpServlet {

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
            out.println("<title>My Booking</title>");
            out.println("<style>"
                    + "body {\n"
                    + "            margin: 0;\n"
                    + "            font-family: Arial, sans-serif;                       \n"
                    + "            padding: 0;\n"
                    + "            height: 100%;\n"
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
                    + "        }"
                    + " li {\n"
                    + "            list-style-type: none;\n"
                    + "            background-color: #ffffff;\n"
                    + "            padding: 20px;\n"
                    + "            margin-bottom: 20px;\n"
                    + "            border-radius: 10px;\n"
                    + "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n"
                    + "        }\n"
                    + "\n"
                    + "        h1 {\n"
                    + "            color: #3a1c71;\n"
                    + "            margin-bottom: 10px;\n"
                    + "        }\n"
                    + "\n"
                    + "        p {\n"
                    + "            margin: 10px 0;\n"
                    + "        }\n"
                    + "\n"
                    + "        /* Styling for bname and phno */\n"
                    + "        .booking-info {\n"
                    + "            background-color: #3a1c71;\n"
                    + "            color: #ffffff;\n"
                    + "            padding: 10px;\n"
                    + "            border-radius: 5px;\n"
                    + "            margin-bottom: 20px;\n"
                    + "        }"
                    + "form {\n"
                    + "    margin-top: 20px;\n"
                    + "    padding: 20px;\n"
                    + "    border: 1px solid #ccc;\n"
                    + "    border-radius: 5px;\n"
                    + "    background-color: #f9f9f9;\n"
                    + "}\n"
                    + "\n"
                    + "form input[type=\"date\"] {\n"
                    + "    padding: 10px;\n"
                    + "    border: 1px solid #ccc;\n"
                    + "    border-radius: 5px;\n"
                    + "    margin-bottom: 10px;\n"
                    + "}\n"
                    + "\n"
                    + "form button[type=\"submit\"] {\n"
                    + "    padding: 10px 20px;\n"
                    + "    background-color: #3a1c71;\n"
                    + "    color: #fff;\n"
                    + "    border: none;\n"
                    + "    border-radius: 5px;\n"
                    + "    cursor: pointer;\n"
                    + "}\n"
                    + "\n"
                    + "form button[type=\"submit\"]:hover {\n"
                    + "    background-color: #5d4879;\n"
                    + "}"
                    + "  .footer {\n"
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
                    + "        }</style>"
                    + "<script>\n"
                    + "function showDropdowns() {\n"
                    + "    document.getElementById('dropdowns').style.display = 'block';\n"
                    + "}\n"
                    + "</script>");
            out.println("</head>");
            out.println("<body>"
                    + "<header>\n"
                    + "    <img class=\"logo\" src=\"dbms logo.jpeg\" alt=\"TOURGUIDE\">\n"
                    + "    <h1 style='color:black;'>TOURGUIDE</h1>      \n"
                    + "</header>");

            //out.println("<h1>Servlet booking at " + request.getContextPath() + "</h1>");
            String bname = request.getParameter("bookingName");
            int phno = Integer.parseInt(request.getParameter("phoneNumber"));
            out.println("<p class='booking-info'>Booking Name: " + bname + "</p>");
            out.println("<p class='booking-info'>Phone Number: " + phno + "</p>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itinerary", "root", "root123");
            String query = "SELECT * FROM user_itinerary WHERE bname = ? AND phno = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, bname);
            pstmt.setDouble(2, phno);
            ResultSet hotelRs = pstmt.executeQuery();
            String hotelName = null;
            while (hotelRs.next()) {
                hotelName = hotelRs.getString("hotel_name");
                String checkin = hotelRs.getString("check_in_date");
                String checkout = hotelRs.getString("check_out_date");
                out.println("<li>");
                out.println("<h1>Hotel Name: " + hotelName + "</h1>");
                out.println("<p>Check-in-date: " + checkin + "</p>");
                out.println("<p>check-out-date: " + checkout + "</p>");
                out.println("</li>");
                out.println("<p>  Update Your Booking</p>"
                        + "<form action=\"UpdateBooking\" method=\"post\">");
                out.println("    <input type=\"hidden\" name=\"bookingName\" value=\"" + bname + "\">");
                out.println("    <input type=\"hidden\" name=\"phoneNumber\" value=\"" + phno + "\">");
                out.println("    New Check-in Date: <input type=\"date\" name=\"newCheckin\"><br>");
                out.println("    New Check-out Date: <input type=\"date\" name=\"newCheckout\"><br>");
                out.println("    <button type=\"submit\">Update Booking</button>");
                out.println("</form>");

                out.println("<br><br><p>Delete Your booking</p>"
                        + "<form action=\"DeleteBooking\" method=\"post\">\n"
                        + "    <input type=\"hidden\" name=\"bookingName\" value=\"" + bname + "\">\n"
                        + "    <input type=\"hidden\" name=\"phoneNumber\" value=\"" + phno + "\">\n"
                        + "    <button type=\"submit\">Delete Booking</button>\n"
                        + "</form>");
            }

            pstmt.close();
            con.close();
            out.println("<div class=\"footer\">\n"
                    + "    <a href=\"contact.html\">Contact US</a>\n"
                    + "    <p>&copy; 2024 Your TourGuide. All rights reserved.</p>\n"
                    + "</div>"
                    + "</body>");
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
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
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
