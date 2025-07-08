package com.Project2.BackEnd.Repo;

import com.Project2.BackEnd.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNic(String nic); // 🔍 to find user by NIC


}

