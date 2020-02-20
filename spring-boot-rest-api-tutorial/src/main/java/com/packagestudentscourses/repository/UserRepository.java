package com.packagestudentscourses.repository;
import com.packagestudentscourses.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type User.
 *
 * @author Chen Kashi
 */
@Transactional
public interface UserRepository extends UserBaseRepository<User> { /* ... */ }



