package mandatory.cinemama.Entities.Hall;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Entities.Hall.HallRow.Row;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "halls", schema = "cinemama")
public class Hall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 40)
  private String name;

  @ManyToOne()
  private Theater theater;
  
  @JsonIgnore
  @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
  private List<Row> rows = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Schedule> schedules = new ArrayList<Schedule>();

  public Hall(String name, Theater theater) {
    this.name = name;
    this.theater = theater;
  }
}
