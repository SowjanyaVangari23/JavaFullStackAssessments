package com.ig.ui;

import com.ig.model.Scholar;
import com.ig.service.ScholarService;
import com.ig.exception.ScholarNotFoundException;

import java.sql.SQLException;
import java.util.List;

public class ScholarUI {

    private static ScholarService scholarService = new ScholarService();

    public static void main(String[] args) {
        addSampleScholars();
        listAllScholars();
        getScholarById(101); 
        updateScholarEmail(102, "abcd@example.com");
        deleteScholarById(103); 
    }
    private static void addSampleScholars() {
        Scholar scholar1 = new Scholar(101, "Chinnu", "chinnu@gmail.com", "1234567890");
        Scholar scholar2 = new Scholar(102, "Ajay", "ajay@gmail.com", "2345678901");
        Scholar scholar3 = new Scholar(103, "Poojitha", "poojitha@gmail.com", "3456789012");
        Scholar scholar4 = new Scholar(104, "Bhavya", "bhavya@gmail.com", "4567890123");
        Scholar scholar5 = new Scholar(105, "Farha", "farha@gmail.com", "5678901234");

        try {
            // Adding scholars to the database
            scholarService.addScholar(scholar1);
            scholarService.addScholar(scholar2);
            scholarService.addScholar(scholar3);
            scholarService.addScholar(scholar4);
            scholarService.addScholar(scholar5);
            System.out.println("Sample scholars added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding sample scholars: " + e.getMessage());
        }
    }

    // List all scholars
    private static void listAllScholars() {
        try {
            List<Scholar> scholars = scholarService.listAllScholars();
            if (scholars.isEmpty()) {
                System.out.println("No scholars found.");
            } else {
                System.out.println("\nList of All Scholars:");
                for (Scholar scholar : scholars) {
                    System.out.println("Rollno: " + scholar.getRollno() +
                            ", Name: " + scholar.getName() +
                            ", Email: " + scholar.getEmail() +
                            ", Mobile: " + scholar.getMobile());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing scholars: " + e.getMessage());
        }
    }

    // Get scholar by ID
    private static void getScholarById(int rollno) {
        try {
            Scholar scholar = scholarService.getScholarById(rollno);
            System.out.println("\nScholar details - Rollno: " + scholar.getRollno() +
                    ", Name: " + scholar.getName() +
                    ", Email: " + scholar.getEmail() +
                    ", Mobile: " + scholar.getMobile());
        } catch (ScholarNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error retrieving scholar: " + e.getMessage());
        }
    }

    // Update scholar email
    private static void updateScholarEmail(int rollno, String newEmail) {
        try {
            scholarService.updateScholarEmail(rollno, newEmail);
            System.out.println("\nScholar email updated successfully.");
        } catch (ScholarNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error updating scholar email: " + e.getMessage());
        }
    }

    // Delete scholar by ID
    private static void deleteScholarById(int rollno) {
        try {
            scholarService.deleteScholarById(rollno);
            System.out.println("\nScholar deleted successfully.");
        } catch (ScholarNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error deleting scholar: " + e.getMessage());
        }
    }
}
