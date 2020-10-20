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
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

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
