package com.segware.upvotes.upvotes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.segware.upvotes.upvotes.models.Post;
import com.segware.upvotes.upvotes.repository.PostRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Posts")
@CrossOrigin(origins="*")
public class PostResource {

	@Autowired
	private PostRepository postRespository;
	
	@GetMapping("/posts")
	@ApiOperation(value="Retorna Lista de Posts")
	public List<Post> listarPosts(){
		
		return postRespository.findAll();
	}
	
	@GetMapping("/post/{id}")
	@ApiOperation(value="Retorna um Post")
	public Post listaPost(@PathVariable(value="id") long id){
		
		return postRespository.findById(id);
	}
	
	@PostMapping("/post")
	@ApiOperation(value="Salva um Post")
	public Post salvaPost(@RequestBody Post post) {
		
		return postRespository.save(post);
		
	}
	
	@PutMapping("/post")
	@ApiOperation(value="Adiciona + 1 Upvote ao Post")
	public Post VotePost(@RequestBody Post post) {
		
		post.addVote();
		return postRespository.save(post);
	}
	
	
	
}
