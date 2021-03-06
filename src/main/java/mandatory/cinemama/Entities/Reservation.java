package mandatory.cinemama.Entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Entities.User.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservations", schema = "cinemama")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(columnDefinition = "BOOLEAN DEFAULT false", nullable = false)
  private boolean isPaid;

  @ManyToOne
  private Schedule schedule;

  @ManyToMany
  private List<Seat> seats;

  @ManyToOne
  private User user;

  public Reservation(
    boolean isPaid,
    Schedule schedule,
    List<Seat> seats,
    User user
  ) {
    this.isPaid = isPaid;
    this.schedule = schedule;
    this.seats = seats;
    this.user = user;
  }
}
