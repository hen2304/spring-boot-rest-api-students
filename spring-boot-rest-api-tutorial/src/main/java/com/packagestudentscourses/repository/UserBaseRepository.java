package com.packagestudentscourses.repository;

import com.packagestudentscourses.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 *
 *
 * @author Chen Kashi
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends User>
        extends CrudRepository<T, Long> {

}