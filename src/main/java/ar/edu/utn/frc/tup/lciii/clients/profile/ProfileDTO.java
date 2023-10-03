package ar.edu.utn.frc.tup.lciii.clients.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProfileDTO (String name) {
}*/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private String name;
}
