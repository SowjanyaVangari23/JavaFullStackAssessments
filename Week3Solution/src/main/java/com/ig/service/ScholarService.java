package com.ig.service;

import com.ig.dao.ScholarDao;
import com.ig.exception.ScholarNotFoundException;
import com.ig.model.Scholar;

import java.sql.SQLException;
import java.util.List;

public class ScholarService implements ScholarServiceInterface {

    private ScholarDao scholarDao = new ScholarDao();
    @Override
    public void addScholar(Scholar scholar) throws SQLException {
        scholarDao.addScholar(scholar);
    }
    @Override
    public List<Scholar> listAllScholars() throws SQLException {
        return scholarDao.listAllScholars();
    }
    @Override
    public Scholar getScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException {
        return scholarDao.getScholarById(scholarId);
    }
    @Override
    public void updateScholarEmail(Integer scholarId, String newEmail) throws SQLException, ScholarNotFoundException {
        scholarDao.updateScholarEmail(scholarId, newEmail);
    }
    @Override
    public void deleteScholarById(Integer scholarId) throws SQLException, ScholarNotFoundException {
        scholarDao.deleteScholarById(scholarId);
    }
}
