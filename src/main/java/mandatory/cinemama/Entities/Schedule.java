package mandatory.cinemama.Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schedules", schema = "cinemama")
@IdClass(SchedulePKey.class)
public class Schedule {

  @Id
  @Column(nullable = false)
  private Long movieId;

  @Id
  @Column(nullable = false)
  private Long hallId;

  @Column(nullable = false)
  @Id
  private LocalTime timeSlot;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  private LocalTime screenTime;

  //TODO: Change to class
  // private Movie movie;
  @Column(nullable = false)
  private String movie;

  //TODO: Change to class
  // private Hall hall;
  @Column(nullable = false)
  private String hall;
}
