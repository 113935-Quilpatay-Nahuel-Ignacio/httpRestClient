package ar.edu.utn.frc.tup.lciii.clients.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//DTO (Data Transfer Object)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDTO(Long id, String title) {
}

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post{
    private Long id;
    private String title;
}
*/