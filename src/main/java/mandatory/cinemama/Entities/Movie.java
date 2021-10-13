package mandatory.cinemama.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Genre.Genre;

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

  @Column(nullable = false, length = 40, unique = true)
  private String title;

  @JsonIgnore
  @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Genre> genres = new ArrayList<>();

  @JsonIgnore
  @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Actor> actors = new ArrayList<>();

  @JsonIgnore
  @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Director> directors = new ArrayList<>();

  private int minAge;

  @Column(nullable = false, length = 30)
  private LocalTime screenTime;

  @Column(nullable = false)
  private String info;

  @Column(nullable = false, length = 10)
  @Min(0)
  @Max(10)
  private Integer rating;

  public Movie(
    String title,
    int minAge,
    LocalTime screenTime,
    String info,
    @Min(0) @Max(10) Integer rating
  ) {
    this.title = title;
    this.minAge = minAge;
    this.screenTime = screenTime;
    this.info = info;
    this.rating = rating;
  }

  public void addDirector(Director director) {
    directors.add(director);
    director.getMovies().add(this);
  }
}
