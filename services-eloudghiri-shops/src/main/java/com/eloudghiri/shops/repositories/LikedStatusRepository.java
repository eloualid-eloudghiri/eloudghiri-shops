package com.eloudghiri.shops.repositories;


import com.eloudghiri.shops.entities.LikedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikedStatusRepository extends JpaRepository<LikedStatus, Long> {

    @Query("SELECT l FROM LikedStatus l where l.idUser = :x and liked = :y")
    List<LikedStatus> findLikedStatusByUser(@Param("x") Long userId, @Param("y") boolean liked);
}
