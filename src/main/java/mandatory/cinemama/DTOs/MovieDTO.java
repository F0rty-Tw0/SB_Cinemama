package mandatory.cinemama.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

  private String title;
  private List<String> genres;
  private List<String> actors;
  private List<String> directors;
  private Integer minAge;
  private String info;
  private LocalTime screenTime;
  private String trailerLink;
  private String imageLink;
  private String posterLink;
}
