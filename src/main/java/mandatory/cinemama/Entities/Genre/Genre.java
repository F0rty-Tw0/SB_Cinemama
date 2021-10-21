package mandatory.cinemama.Entities.Genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Movie;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "genres", schema = "cinemama")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EGenres name;

  @JsonIgnore
  @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
  private List<Movie> movies = new ArrayList<Movie>();

  public Genre(EGenres name) {
    this.name = name;
  }

  @PreRemove
  private void removeGenreFromMovies() {
    for (Movie movie : movies) {
      movie.getGenres().remove(this);
    }
  }
}
