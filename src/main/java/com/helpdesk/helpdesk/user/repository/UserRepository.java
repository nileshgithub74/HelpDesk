package com.helpdesk.helpdesk.user.repository;


import com.helpdesk.helpdesk.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where u.isDeleted= false")
    List<User> findAllAndNotDeleted();


//    @Query("select u.id from User where isDeleted=false")
//    User findByIdNotDeleted(Long id);


    boolean existsByEmail(String email);


    Optional<User> findByEmail(String email);

}
