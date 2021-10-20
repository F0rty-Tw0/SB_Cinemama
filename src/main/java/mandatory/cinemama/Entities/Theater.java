package mandatory.cinemama.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Hall.Hall;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theaters", schema = "cinemama")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 40, unique = true)
  private String name;

  @Column(nullable = false, length = 120, unique = true)
  private String address;

  @JsonIgnore
  @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
  private List<Hall> halls = new ArrayList<>();

  public Theater(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public void addHall(Hall hall) {
    halls.add(hall);
    hall.setTheater(this);
  }
}
