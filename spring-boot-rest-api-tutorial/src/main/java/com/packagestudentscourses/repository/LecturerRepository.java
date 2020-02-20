package com.packagestudentscourses.repository;

import com.packagestudentscourses.model.Lecturer;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 *
 * @author Chen Kashi
 */
@Transactional
public interface LecturerRepository extends UserBaseRepository<Lecturer> { /* ... */ }