package ar.edu.utn.frc.tup.lciii.clients.posts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostRestClientTest {

    @MockBean
    private RestTemplate restTemplate;

    @SpyBean
    private PostRestClient postRestClient;

    @Test
    void getPostsTest() {
        PostDTO postDTO = new PostDTO(10L, "Test unitario");
        PostDTO postDTO2 = new PostDTO(11L, "Test unitario 2");
        PostDTO[] myArrayPost = {postDTO, postDTO2};
        when(restTemplate.getForEntity("https://my-json-server.typicode.com/TUP-UTN-FRC-LCIII/fake-apis/posts", PostDTO[].class))
                .thenReturn(ResponseEntity.ok(myArrayPost));
        ResponseEntity<PostDTO[]> result = postRestClient.getPosts();
        assertEquals(2, Objects.requireNonNull(result.getBody()).length);
        assertEquals("Test unitario", Objects.requireNonNull(result.getBody())[0].title());
        assertEquals("Test unitario 2", Objects.requireNonNull(result.getBody())[1].title());
    }

    @Test
    void getPostTest() {
        PostDTO postDTO = new PostDTO(10L, "Test unitario");
        when(restTemplate.getForEntity("https://my-json-server.typicode.com/TUP-UTN-FRC-LCIII/fake-apis/posts/10", PostDTO.class))
                .thenReturn(ResponseEntity.ok(postDTO));
        ResponseEntity<PostDTO> result = postRestClient.getPost(10L);
        assertEquals(10L, Objects.requireNonNull(result.getBody()).id());
    }
}
