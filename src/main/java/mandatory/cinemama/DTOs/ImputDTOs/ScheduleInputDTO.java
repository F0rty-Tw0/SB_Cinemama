package mandatory.cinemama.DTOs.ImputDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties("screenTime")
public class ScheduleInputDTO {

  private LocalDate date;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime timeSlot;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  private ScheduleHallInputDTO hall;

  private ScheduleMovieInputDTO movie;

  public ScheduleInputDTO(
    LocalDate date,
    LocalTime timeSlot,
    ScheduleHallInputDTO hall,
    ScheduleMovieInputDTO movie
  ) {
    this.date = date;
    this.timeSlot = timeSlot;
    this.hall = hall;
    this.movie = movie;
  }
}
