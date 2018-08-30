//package com.apressbook.spring.springbootjournal;
//
//import com.apress.spring.domain.Post;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootJournalApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//	private static final String ROOT_URL = "http://localhost:8080";
//	RestTemplate restTemplate = new RestTemplate();
//
//	@Test
//	public void testGetAllPosts() {
//		ResponseEntity<Post[]> responseEntity =
//				restTemplate.getForEntity(ROOT_URL + "/posts", Post[].class);
//		List<Post> posts = Arrays.asList(responseEntity.getBody());
//		assertNotNull(posts);
//	}
//
//	@Test
//	public void testGetPostById() {
//		Post post = restTemplate.getForObject(ROOT_URL + "/posts/1", Post.class);
//		assertNotNull(post);
//
//	}
//
//	@Test
//	public void testCreatePost()
//	{
//		Post post = new Post();
//		post.setTitle("Exploring SpringBoot REST");
//		post.setContent("SpringBoot is awesome!!");
//		post.setCreatedOn(new Date());
//		ResponseEntity<Post> postResponse =
//				restTemplate.postForEntity(ROOT_URL+"/posts", post, Post.class);
//		assertNotNull(postResponse);
//		assertNotNull(postResponse.getBody());
//	}
//}