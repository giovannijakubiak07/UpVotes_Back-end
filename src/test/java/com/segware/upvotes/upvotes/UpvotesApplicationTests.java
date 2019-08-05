package com.segware.upvotes.upvotes;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.segware.upvotes.upvotes.models.Post;
import com.segware.upvotes.upvotes.resources.PostResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpvotesApplicationTests {
	
	@Autowired
	PostResource pr = new PostResource();
	
	public void setUp() {
		
        System.out.println("Inicializando o teste");
    }
	public void tearDown() {

	    System.out.println("Finalizando teste");
	}
	
	@Test
	public void contextLoads() {
		
	}
	
	
	@Test
	public void GetListTest() {
		try {
			List<Post> posts = pr.listarPosts();
			assertTrue(true);
		}catch(Exception e){
			System.out.println(e);
			assertTrue(false);
		}
	}
	
}
