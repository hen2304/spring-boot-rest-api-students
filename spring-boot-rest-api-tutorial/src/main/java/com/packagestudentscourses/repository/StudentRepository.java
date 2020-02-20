package com.packagestudentscourses.repository;

import com.packagestudentscourses.model.Student;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 *
 * @author Chen Kashi
 */
@Transactional
public interface StudentRepository extends UserBaseRepository<Student> { /* ... */ }