package mandatory.cinemama.DTOs.ImputDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInputDTO {

  private String title;
  private Long minAge;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  private String info;
  private Double rating;
  private String trailer;
  private String image;
  private String poster;
  private Set<GenreInputDTO> genres;
  private Set<ActorInputDTO> actors;
  private Set<DirectorInputDTO> directors;
}
