package com.fisrt.test.Repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;

import com.fisrt.test.entity.UserDetails;

@Component
public interface UserRepository extends JpaRepositoryImplementation<UserDetails, Integer>
{
}
