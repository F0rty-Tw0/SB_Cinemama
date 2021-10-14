package mandatory.cinemama.Entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Genre.Genre;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movies", schema = "cinemama")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false, length = 40, unique = true)
  private String title;

  @ManyToMany
  private List<Genre> genres = new ArrayList<>();

  @ManyToMany
  private List<Actor> actors = new ArrayList<>();

  @ManyToMany
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
    @Min(0) @Max(10) Integer rating,
    List<Actor> actors,
    List<Director> directors,
    List<Genre> genres
  ) {
    this.title = title;
    this.minAge = minAge;
    this.screenTime = screenTime;
    this.info = info;
    this.rating = rating;
    this.actors = actors;
    this.directors = directors;
    this.genres = genres;
  }

  public void addDirector(Director director) {
    directors.add(director);
    director.getMovies().add(this);
  }
}
