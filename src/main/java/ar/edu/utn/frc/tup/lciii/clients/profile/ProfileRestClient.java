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

    @Autowired
    private RestTemplate restTemplate;

    String baseResourceUrl = "https://my-json-server.typicode.com/TUP-UTN-FRC-LCIII/fake-apis/profile";

    public ResponseEntity<ProfileDTO> getProfile() {
        return restTemplate.getForEntity(baseResourceUrl, ProfileDTO.class);
    }


    //WEB CLIENT
    /*@Autowired
    private WebClient webClient;

    String resourceUrl = "/profile";

    //Mono: capturar el resultado de una operación asíncrona
    //Flux: capturar el resultado de una operación asíncrona que devuelve una colección
    public Mono<ResponseEntity<ProfileDTO>> getProfile(){
        return webClient.get()
                .uri(resourceUrl)
                .retrieve()
                .toEntity(ProfileDTO.class);
    }*/

}
