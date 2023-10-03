package ar.edu.utn.frc.tup.lciii.clients.profile;

import ar.edu.utn.frc.tup.lciii.clients.posts.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProfileRestClient {

    //WEB CLIENT
    /*@Autowired
    private WebClient webClient;

    String resourceUrl = "/profile";

    public Mono<ResponseEntity<ProfileDTO>> getProfile(){
        return webClient.get()
                .uri(resourceUrl)
                .retrieve()
                .toEntity(ProfileDTO.class);
    }*/

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    String baseResourceUrl = "https://my-json-server.typicode.com/TUP-UTN-FRC-LCIII/fake-apis/profile";

    public ResponseEntity<ProfileDTO> getPost(Long id) {
        return restTemplate.getForEntity(baseResourceUrl + "/" + id, ProfileDTO.class);
    }
}
