package mandatory.cinemama.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

  private String title;

  private Integer minAge;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  private Double rating;

  private String info;
  private String trailer;
  private String image;
  private String poster;
  private List<GenreDTO> genres;
  private List<ActorDTO> actors;
  private List<DirectorDTO> directors;
}
