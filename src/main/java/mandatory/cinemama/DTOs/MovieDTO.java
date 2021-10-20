package mandatory.cinemama.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

  private String title;
  private List<GenreDTO> genres;
  private List<ActorDTO> actors;
  private List<DirectorDTO> directors;
  private Integer minAge;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  private String info;
  private String trailer;
  private String image;
  private String poster;
}
