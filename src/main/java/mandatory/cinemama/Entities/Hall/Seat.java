package mandatory.cinemama.Entities.Hall;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Entities.Reservation;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seats", schema = "cinemama")
@JsonIgnoreProperties("row")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 40)
  private String name;

  @ManyToOne
  private Row row;

  @JsonIgnore
  @ManyToMany(mappedBy = "seats", fetch = FetchType.LAZY)
  private List<Reservation> reservation;

  public Seat(String name, Row row) {
    this.name = name;
    this.row = row;
  }
}
