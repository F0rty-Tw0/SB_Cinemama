package mandatory.cinemama.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schedule", schema = "cinemama")
public class Schedule {
  @EmbeddedId
  @AttributeOverrides({
          @AttributeOverride( name = "movieId", column = @Column(name = "movie_id")),
          @AttributeOverride( name = "timeSlot", column = @Column(name = "time_slot"))
  })
  SchedulePKey scheduleId;
  //TODO: Change to class
  // private Movie movie;
  private String movie;
  private LocalDate date;
  private LocalTime screenTime;
  //TODO: Change to class
  // private Hall hall;
  private String hall;
}
