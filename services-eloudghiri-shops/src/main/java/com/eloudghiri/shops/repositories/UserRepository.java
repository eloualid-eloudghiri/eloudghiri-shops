package com.eloudghiri.shops.repositories;

import com.eloudghiri.shops.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email = :x and u.password = :y")
    User getUserByEmailPassword(@Param("x") String email, @Param("y") String password);
}
