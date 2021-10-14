package mandatory.cinemama.Entities.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  @Column(name = "hall_id")
  private Long hallId;

  @Id
  @Column(name = "movie_id")
  private Long movieId;

  @Id
  @Column(nullable = false)
  private LocalTime timeSlot;

  @Id
  @Column(nullable = false)
  private LocalDate date;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(insertable = false, updatable = false)
  private Hall hall;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(insertable = false, updatable = false)
  private Movie movie;

  @Column(nullable = false)
  private LocalTime screenTime;

  public Schedule(LocalTime timeSlot, LocalDate date, Movie movie, Hall hall) {
    this.timeSlot = timeSlot;
    this.date = date;
    this.movie = movie;
    this.hall = hall;
    this.hallId = hall.getId();
    this.movieId = movie.getId();
    this.screenTime = movie.getScreenTime();
  }
}
