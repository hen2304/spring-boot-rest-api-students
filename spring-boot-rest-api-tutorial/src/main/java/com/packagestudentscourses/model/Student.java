package com.packagestudentscourses.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * The type Student.
 *
 * @author Chen Kashi
 */
@Entity
@Table(name = "students")
public class Student extends User {
    @Override
    public String toString() {
        return "Student{" +
                "departmentName='" + departmentName + '\'' +
                ", courses=" + courses +
                '}';
    }

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses=new HashSet<>();




}
