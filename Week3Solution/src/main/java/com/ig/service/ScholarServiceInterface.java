package com.ig.service;

import com.ig.model.Scholar;
import com.ig.exception.ScholarNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface ScholarServiceInterface {

    // Add a new scholar
    void addScholar(Scholar scholar) throws SQLException;

    // List all scholars
    List<Scholar> listAllScholars() throws SQLException;

    // Get scholar by ID
    Scholar getScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException;

    // Update scholar email
    void updateScholarEmail(Integer scholarId, String newEmail) throws SQLException, ScholarNotFoundException;

    // Delete scholar by ID
    void deleteScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException;
}
