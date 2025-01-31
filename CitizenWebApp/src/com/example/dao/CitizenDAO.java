package com.example.dao;

import com.example.model.Citizen;
import com.example.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {

    public void addCitizen(Citizen citizen) throws SQLException {
        String sql = "INSERT INTO CITIZEN (SERIAL_NUMBER, NAME, AADHAAR_NUMBER, MOBILE_NUMBER, ADDRESS) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, citizen.getSerialNumber());
            stmt.setString(2, citizen.getName());
            stmt.setString(3, citizen.getAadhaarNumber());
            stmt.setString(4, citizen.getMobileNumber());
            stmt.setString(5, citizen.getAddress());
            stmt.executeUpdate();
        }
    }

    public List<Citizen> getAllCitizens() throws SQLException {
        List<Citizen> citizens = new ArrayList<>();
        String sql = "SELECT * FROM CITIZEN";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Citizen citizen = new Citizen();
                citizen.setSerialNumber(rs.getInt("SERIAL_NUMBER"));
                citizen.setName(rs.getString("NAME"));
                citizen.setAadhaarNumber(rs.getString("AADHAAR_NUMBER"));
                citizen.setMobileNumber(rs.getString("MOBILE_NUMBER"));
                citizen.setAddress(rs.getString("ADDRESS"));
                citizens.add(citizen);
            }
        }
        return citizens;
    }
}