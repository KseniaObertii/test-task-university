package com.botscrew.testtaskuniversity.service;

import com.botscrew.testtaskuniversity.dao.DepartmentDao;
import com.botscrew.testtaskuniversity.model.Lector;
import com.botscrew.testtaskuniversity.model.spec_models.LectorDegreeStatisticsByDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Long getAvgSalaryByDepartmentName(String departmentName) {
        return departmentDao.getAvgSalaryByDepartmentName(departmentName);
    }

    public Lector findDepartmentHeadLectorByDepartmentName(String departmentName) {
        return departmentDao.findDepartmentHeadLectorByDepartmentName(departmentName);
    }

    public List<LectorDegreeStatisticsByDepartment> getLectorDegreeStatisticsByDepartmentName(String departmentName) {
        return departmentDao.getLectorDegreeStatisticsByDepartmentName(departmentName);
    }

    public Long getLectorCountByDepartmentName(String departmentName) {
        return departmentDao.getLectorCountByDepartmentName(departmentName);
    }
}
