package mandatory.cinemama.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.Genre;

import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    private String title;
    private List<String> genres;
    private List<String> actors;
    private List<String> directors;
    private Integer minage;
    private String info;
    private LocalTime screenTime;
    private String trailerLink;
    private String imageLink;
    private String posterLink;

}

