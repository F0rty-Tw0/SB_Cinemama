package mandatory.cinemama.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theaters", schema = "cinemama")
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 40, unique = true)
  private String name;

  @Column(nullable = false, length = 120, unique = true)
  private String address;

  // TODO: private List<Hall> halls;
  public Theater(String name, String address) {
    this.name = name;
    this.address = address;
  }
}
