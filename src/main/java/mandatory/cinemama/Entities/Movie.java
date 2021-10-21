package mandatory.cinemama.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(unique = true)
  private String title;

  @Column
  private Long minAge;

  @Column(length = 30)
  @JsonFormat(pattern = "HH:mm")
  private LocalTime screenTime;

  @Column
  private String info;

  @Column(length = 10)
  @Min(0)
  @Max(10)
  private Double rating;

  @Column
  private String trailer;

  @Column
  private String image;

  @Column
  private String poster;

  @ManyToMany
  private Set<Genre> genres = new HashSet<>();

  @ManyToMany
  private Set<Actor> actors = new HashSet<>();

  @ManyToMany
  private Set<Director> directors = new HashSet<>();

  public Movie(
    String title,
    Long minAge,
    LocalTime screenTime,
    String info,
    @Min(0) @Max(10) Double rating,
    Set<Actor> actors,
    Set<Director> directors,
    Set<Genre> genres,
    String trailer,
    String image,
    String poster
  ) {
    this.title = title;
    this.minAge = minAge;
    this.screenTime = screenTime;
    this.info = info;
    this.rating = rating;
    this.actors = actors;
    this.directors = directors;
    this.genres = genres;
    this.trailer = trailer;
    this.image = image;
    this.poster = poster;
  }

  public void addDirector(Director director) {
    directors.add(director);
    director.getMovies().add(this);
  }
}
