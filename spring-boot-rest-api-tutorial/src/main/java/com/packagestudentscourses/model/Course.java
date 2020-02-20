package com.packagestudentscourses.model;
import javax.persistence.*;
import java.util.Set;
/**
 * The type Course.
 *
 * @author Chen Kashi
 */
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY ,cascade = {CascadeType.PERSIST})
    Set<Student> students;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }


    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }






}
