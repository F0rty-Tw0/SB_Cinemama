package mandatory.cinemama.Entities;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies", schema = "cinemama")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false, length = 40)
  private String title;

  @Column(nullable = false, length = 30)
  // TODO: List<Geners>
  private String genres;

  @Column(nullable = false, length = 60)
  // TODO: List<Actors> actors;
  private String actors;

  @Column(nullable = false, length = 60)
  // TODO: List<Directors> directors;
  private String directors;

  private int minAge;

  @Column(nullable = false, length = 30)
  private LocalTime screenTime;

  @Column(nullable = false, length = 60)
  private String info;

  @Column(nullable = false, length = 10)
  @Size(min = 0, max = 10)
  private int rating;
}
