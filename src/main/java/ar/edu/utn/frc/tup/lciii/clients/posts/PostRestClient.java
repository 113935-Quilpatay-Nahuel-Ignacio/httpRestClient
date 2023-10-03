package ar.edu.utn.frc.tup.lciii.clients.posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostRestClient {

    //consumir APIs REST
    @Autowired
    RestTemplate restTemplate;

    String baseResourceUrl = "http://my-json-server.typicode.com/TUP-UTN-FRC-LCIII/fake-apis/posts";

    public ResponseEntity<PostDTO[]> getPosts() {
        return restTemplate.getForEntity(baseResourceUrl, PostDTO[].class);
    }

    public ResponseEntity<PostDTO> getPost(Long id) {
        return restTemplate.getForEntity(baseResourceUrl + "/" + id, PostDTO.class);
    }
}
