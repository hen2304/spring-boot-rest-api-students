package com.packagestudentscourses.model;
import javax.persistence.*;
/**
 * The type Lecturer.
 *
 * @author Chen Kashi
 */
@Entity
@Table(name = "lecturers")
public class Lecturer extends User {

    @Column(name = "lecture_num", nullable = false)
    private String lectureNum;

    public String getlectureNum() {
        return lectureNum;
    }

    public void setlectureNum(String lectureNum) {
        this.lectureNum = lectureNum;
    }



}
