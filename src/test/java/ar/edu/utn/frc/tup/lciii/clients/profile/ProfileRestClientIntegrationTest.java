package ar.edu.utn.frc.tup.lciii.clients.profile;

import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfileRestClientIntegrationTest {

    @Autowired
    private ProfileRestClient profileRestClient;

    @Test
    void getProfileIntegrationTest(){
        ResponseEntity<ProfileDTO> result = profileRestClient.getProfile();
        ProfileDTO profile = result.getBody();
        assertEquals("typicode", profile.getName());
    }

    /*
    //WEB CLIENT
    @Test
    void getProfileIntegrationTest(){
        Mono<ProfileDTO> result = profileRestClient.getProfile();
        ProfileDTO profile = result.blockOptional().get().getBody();
        assertEquals("typicode", profile.getName());
    }*/
}
