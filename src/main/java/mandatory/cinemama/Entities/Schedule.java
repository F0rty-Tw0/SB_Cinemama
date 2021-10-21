package mandatory.cinemama.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.Hall;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
  uniqueConstraints = {
    @UniqueConstraint(
      name = "UniqueTimeSlotAndDateAndHallId",
      columnNames = { "timeSlot", "date", "hall_id" }
    ),
  },
  name = "schedules",
  schema = "cinemama"
)
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private LocalDate date;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime timeSlot;

  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  @ManyToOne
  private Hall hall;

  @ManyToOne
  private Movie movie;

  @JsonIgnore
  @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
  private Set<Reservation> reservations;

  public Schedule(LocalTime timeSlot, LocalDate date, Movie movie, Hall hall) {
    this.timeSlot = timeSlot;
    this.date = date;
    this.movie = movie;
    this.hall = hall;
    this.screenTime = movie.getScreenTime();
  }
}
