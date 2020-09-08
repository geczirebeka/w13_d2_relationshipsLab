package com.codeclan.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "employee_number")
    private int employeeNumber;

    @JsonIgnoreProperties({"employees"})
    @ManyToOne
    @JoinColumn(name= "department_id", nullable=false)
    private Department department;

    @JsonIgnoreProperties({"employees"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = {@JoinColumn(
                    name= "employee_id",
                    nullable= false,
                    updatable= false)
            },
            inverseJoinColumns = {@JoinColumn(
                    name= "project_id",
                    nullable= false,
                    updatable= false)
            }
    )
    private List<Project> projects;

    public Employee(String firstName, String lastName, int employeeNumber, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
