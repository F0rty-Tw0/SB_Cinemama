package mandatory.cinemama.Entities.Genre;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mandatory.cinemama.Entities.Movie;

@Setter
@Getter
@Entity
@Table(name = "genres", schema = "cinemama")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EGenre name;

  @ManyToMany
  private List<Movie> movies;

  public Genre(EGenre name) {
    this.name = name;
  }
}
