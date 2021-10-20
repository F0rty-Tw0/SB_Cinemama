package mandatory.cinemama.Entities.Hall;

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
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Entities.Schedule;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seats", schema = "cinemama")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 40)
  private String name;

  @ManyToOne
  private Row row;

  @Column(nullable = false, length = 40, columnDefinition = "boolean default true")
  private Boolean available;

  /*@ManyToMany
  private List<Schedule> schedules;*/

  public Seat(String name, Row row, Boolean available) {
    this.name = name;
    this.row = row;
    this.available = available;
  }
}
