package com.ig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ig.exception.ScholarNotFoundException;
import com.ig.model.Scholar;
import com.ig.util.DbUtil;

public class ScholarDao implements ScholarDaoInterface {

    // Add a new scholar
	@Override
    public void addScholar(Scholar scholar) throws SQLException {
        String sql = "INSERT INTO scholar1 (Rollno, Name, Email, Mobile) VALUES (?, ?, ?, ?)";

        try (Connection connection = DbUtil.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scholar.getRollno());
            preparedStatement.setString(2, scholar.getName());
            preparedStatement.setString(3, scholar.getEmail());
            preparedStatement.setString(4, scholar.getMobile());
            preparedStatement.executeUpdate();
        }
    }

    // List all scholars
	@Override
    public List<Scholar> listAllScholars() throws SQLException {
        String sql = "SELECT * FROM scholar1";
        List<Scholar> scholars = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Integer rollno = resultSet.getInt("Rollno");
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String mobile = resultSet.getString("Mobile");
                scholars.add(new Scholar(rollno, name, email, mobile));
            }
        }
        return scholars;
    }

    // Get scholar by id
	@Override
    public Scholar getScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException {
        String sql = "SELECT * FROM scholar1 WHERE Rollno = ?";
        Scholar scholar = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scholarId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer rollno = resultSet.getInt("Rollno");
                    String name = resultSet.getString("Name");
                    String email = resultSet.getString("Email");
                    String mobile = resultSet.getString("Mobile");
                    scholar = new Scholar(rollno, name, email, mobile);
                }
            }
        }

        if (scholar == null) {
            throw new ScholarNotFoundException("Scholar1 with Rollno " + scholarId + " not found.");
        }

        return scholar;
    }

    // Update scholar email
	@Override
    public void updateScholarEmail(Integer scholarId, String newEmail) throws SQLException, ScholarNotFoundException {
        String sql = "UPDATE scholar1 SET Email = ? WHERE Rollno = ?";

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, scholarId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new ScholarNotFoundException("Scholar1 with Rollno " + scholarId + " not found.");
            }
        }
    }

	@Override
    public void deleteScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException {
        String sql = "DELETE FROM scholar1 WHERE Rollno = ?";

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scholarId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new ScholarNotFoundException("Scholar1 with Rollno " + scholarId + " not found.");
            }
        }
    }
}
