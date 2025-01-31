package com.example.servlet;

import com.example.dao.CitizenDAO;
import com.example.model.Citizen;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/citizen")
public class GetCitizenServlet extends HttpServlet {
    private CitizenDAO citizenDAO = new CitizenDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Citizen citizen = new Citizen();
        citizen.setSerialNumber(Integer.parseInt(request.getParameter("serialNumber")));
        citizen.setName(request.getParameter("name"));
        citizen.setAadhaarNumber(request.getParameter("aadhaar"));
        citizen.setMobileNumber(request.getParameter("mobile"));
        citizen.setAddress(request.getParameter("address"));

        try {
            citizenDAO.addCitizen(citizen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("view-citizens.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Citizen> citizens = citizenDAO.getAllCitizens();
            request.setAttribute("citizens", citizens);
            request.getRequestDispatcher("view-citizens.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}