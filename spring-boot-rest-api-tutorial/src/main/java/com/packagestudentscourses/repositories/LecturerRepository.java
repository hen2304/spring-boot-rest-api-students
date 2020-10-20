package com.packagestudentscourses.repository;

import com.packagestudentscourses.model.Lecturer;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 *
 * @author Chen Kashi
 */
@Transactional
public class LecturerRepository extends UserBaseRepository<LecturerEntity> { /* ... */ }