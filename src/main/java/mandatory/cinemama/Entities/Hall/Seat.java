package mandatory.cinemama.Entities.Hall;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.HallRow.Row;

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

  public Seat(String name, Row row) {
    this.name = name;
    this.row = row;
  }
}
