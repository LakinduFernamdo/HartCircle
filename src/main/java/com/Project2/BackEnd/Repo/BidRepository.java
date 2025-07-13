package com.Project2.BackEnd.Repo;

import com.Project2.BackEnd.Entity.BidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidData, Integer>  {


}
