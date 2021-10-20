package mandatory.cinemama.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO {

  @JsonFormat(pattern = "HH:mm")
  private LocalTime timeSlot;

  private LocalDate date;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  private HallDTO hall;

  @JsonIgnoreProperties(
    {
      "genres",
      "actors",
      "directors",
      "screenTime",
      "info",
      "trailer",
      "image",
      "poster",
    }
  )
  private MovieDTO movie;
}
