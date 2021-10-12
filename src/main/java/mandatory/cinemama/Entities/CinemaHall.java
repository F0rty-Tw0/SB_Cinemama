package mandatory.cinemama.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cinema_halls", schema = "cinemama")
public class CinemaHall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false, length = 40)
  private String name;

  // TODO: private List<Schedule> movieSchedules;
  private String movieSchedules;
}
