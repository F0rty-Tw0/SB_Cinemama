package mandatory.cinemama.Entities.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Entities.Movie;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "schedules", schema = "cinemama")
@IdClass(SchedulePKey.class)
public class Schedule {

  @Id
  @Column(nullable = false)
  private Long movieId;

  @Id
  @Column(nullable = false)
  private Long hallId;

  @Id
  @Column(nullable = false)
  private LocalTime timeSlot;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  private LocalTime screenTime;

  public Schedule(LocalTime timeSlot, LocalDate date, Movie movie, Hall hall) {
    this.timeSlot = timeSlot;
    this.date = date;
    this.movieId = movie.getId();
    this.hallId = hall.getId();
    this.screenTime = movie.getScreenTime();
  }
}
