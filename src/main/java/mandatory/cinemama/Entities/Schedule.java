package mandatory.cinemama.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Schedule {
  //TODO: Change to class
  // private Movie movie;
  private String movie;
  private LocalDate date;
  private LocalTime timeSlot;
  private LocalTime screenTime;
  //TODO: Change to class
  // private Hall hall;
  private String hall;
}
