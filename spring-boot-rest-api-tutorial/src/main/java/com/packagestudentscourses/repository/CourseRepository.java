package com.packagestudentscourses.repository;

import com.packagestudentscourses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author Chen Kashi
 */
public interface CourseRepository extends JpaRepository<Course,Long> { /* ... */ }