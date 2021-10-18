package mandatory.cinemama.Entities.Hall.HallRow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.Hall;
import mandatory.cinemama.Entities.Hall.Seat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hall_rows", schema = "cinemama")
public class Row {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ERows name;

  @ManyToOne
  private Hall hall;

  @JsonIgnore
  @OneToMany(mappedBy = "row", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Seat> seats = new ArrayList<Seat>();

  public Row(ERows name, Hall hall) {
    this.name = name;
    this.hall = hall;
  }
}
