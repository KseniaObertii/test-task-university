package com.botscrew.testtaskuniversity.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departmentName;

    private Long departmentHeadLectorId;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "departments")
    private List<Lector> lectors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmenName() {
        return departmentName;
    }

    public void setDepartmenName(String departmenName) {
        this.departmentName = departmenName;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    public Long getDepartmentHeadLectorId() {
        return departmentHeadLectorId;
    }

    public void setDepartmentHeadLectorId(Long departmentHeadLectorId) {
        this.departmentHeadLectorId = departmentHeadLectorId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHeadLectorId=" + departmentHeadLectorId +
                ", lectors=" + lectors +
                '}';
    }
}
