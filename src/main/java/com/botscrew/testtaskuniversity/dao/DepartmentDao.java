package com.botscrew.testtaskuniversity.dao;

import com.botscrew.testtaskuniversity.model.*;
import com.botscrew.testtaskuniversity.model.spec_models.LectorDegreeStatisticsByDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
    //done
    @Query("select avg(l.salary) as avgSalary " +
            "from Department d " +
            "join d.lectors l " +
            "group by d.departmentName " +
            "having lower(d.departmentName)=lower(:departmentName)")
    Long getAvgSalaryByDepartmentName(@Param("departmentName") String departmentName);

    //done
    @Query("select l from Department d " +
            "join d.lectors l " +
            "where l.id = d.departmentHeadLectorId " +
            "and lower(d.departmentName) = lower(:departmentName)")
    Lector findDepartmentHeadLectorByDepartmentName(@Param("departmentName")String departmentName);

    //done
    @Query("select l.degree as lectorDegree, count(l.id) as count " +
            "from Department d " +
            "join d.lectors l " +
            "where lower(d.departmentName) = lower(:departmentName)" +
            "group by l.degree")
    List<LectorDegreeStatisticsByDepartment> getLectorDegreeStatisticsByDepartmentName(@Param("departmentName") String departmentName);

    //done
    @Query("select count(l.id) " +
            "from Department d " +
            "join d.lectors l where lower(d.departmentName) = lower(:departmentName) " +
            "group by d.departmentName")
    Long getLectorCountByDepartmentName(@Param("departmentName") String departmentName);
}
