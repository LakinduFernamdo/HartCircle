package com.Project2.BackEnd.Repo;

import com.Project2.BackEnd.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByItemTypeIgnoreCase(String itemType);


}
