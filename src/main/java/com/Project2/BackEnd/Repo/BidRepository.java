package com.Project2.BackEnd.Repo;

import com.Project2.BackEnd.Entity.BidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<BidData, Integer> {

    @Query("SELECT b FROM BidData b WHERE b.bidder_ID.userId = :userId AND b.post_ID.postID = :postId")
    Optional<BidData> findDuplicateBidders(@Param("userId") Integer userId, @Param("postId") Integer postId);

}
