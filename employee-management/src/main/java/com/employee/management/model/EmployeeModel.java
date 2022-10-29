package com.employee.management.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee_Table")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name",nullable = false)
    private String name;
    @Column(name = "emp_email",nullable = false)
    private String email;
    private String modified="Not edited";
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "Phone_number",nullable = false)
    private String phoneNumber;
    @ManyToOne
    private ProjectModel projectModel;
    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ProjectModel getProjectModel() {
        return projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "empId=" + empId +

                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", modified='" + modified + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
