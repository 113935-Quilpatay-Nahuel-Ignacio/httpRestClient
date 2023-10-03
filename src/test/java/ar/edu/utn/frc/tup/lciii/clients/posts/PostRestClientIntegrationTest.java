package ar.edu.utn.frc.tup.lciii.clients.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostRestClientIntegrationTest {

    @Autowired
    private PostRestClient postRestClient;

    @Test
    void getPostsIntegrationTest(){
        ResponseEntity<PostDTO[]> result = postRestClient.getPosts();
        assertEquals(12, Objects.requireNonNull(result.getBody()).length);
    }

    @Test
    void getPostIntegrationTest(){
        ResponseEntity<PostDTO> result = postRestClient.getPost(1L);
        assertEquals("hello", Objects.requireNonNull(result.getBody()).title());
    }
}
