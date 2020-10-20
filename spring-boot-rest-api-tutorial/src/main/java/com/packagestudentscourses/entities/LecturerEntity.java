package com.packagestudentscourses.entities;
import javax.persistence.*;
/**
 * The type Lecturer.
 *
 * @author Chen Kashi
 */
@Entity
@Table(name = "lecturers")
public class LecturerEntity {


    @Id
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;



    @Column(name = "lecture_num", nullable = false)
    private String lectureNum;

    public String getLectureNum() {
        return lectureNum;
    }

    public void setLectureNum(String lectureNum) {
        this.lectureNum = lectureNum;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
