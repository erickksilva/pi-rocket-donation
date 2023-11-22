package com.rocketdonation.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rocketdonation.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = (:email)")
//    public User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = (:email)")
    public User findByEmail(@Param("email") String username);

    boolean existsByEmail(String email);


}
