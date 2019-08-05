package com.segware.upvotes.upvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segware.upvotes.upvotes.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	
	Post findById(long id);
}
