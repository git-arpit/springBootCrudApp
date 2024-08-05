package com.springBootApplication.CRUDApplication.Model;
import jakarta.persistence.*;

@Entity
@Table(name="EmployeeTable")
public class Employee {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String primarySkill;
    @Column(nullable = false)
    private String secondarySkill;
    @Id
    private Long empId;

    public Employee(String name, String primarySkill, String secondarySkill, Long empId) {
        this.name = name;
        this.primarySkill = primarySkill;
        this.secondarySkill = secondarySkill;
        this.empId = empId;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getSecondarySkill() {
        return secondarySkill;
    }

    public void setSecondarySkill(String secondarySkill) {
        this.secondarySkill = secondarySkill;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", primarySkill='" + primarySkill + '\'' +
                ", secondarySkill='" + secondarySkill + '\'' +
                ", empId=" + empId +
                '}';
    }
}
