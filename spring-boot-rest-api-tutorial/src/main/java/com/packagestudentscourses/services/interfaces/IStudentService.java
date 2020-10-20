package com.packagestudentscourses.services.interfaces;

import java.util.List;

public interface IStudentService {


    ApiStudentResponse fetchStudent(StudentRequest studentRequest);

    List<CourseEntity> getAllCoursesBy(String studentId);

    List<StudentEntity> getAllStudents();

    List<CourseEntity> getAllCourses();

    StudentEntity getStudentBy(Long studentId);
}
