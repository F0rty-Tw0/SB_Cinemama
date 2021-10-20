package mandatory.cinemama.Entities.User;

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
import mandatory.cinemama.Entities.Reservation;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "cinemama")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @ManyToOne
  private Role role;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Reservation> reservations = new ArrayList<Reservation>();

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
