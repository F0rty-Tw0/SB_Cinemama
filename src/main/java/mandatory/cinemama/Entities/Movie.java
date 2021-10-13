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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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

  @Column(nullable = false, length = 40)
  private String title;

  @JsonIgnore
  @OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Genre> genres = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Actor> actors = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private List<Director> directors = new ArrayList<>();

  private int minAge;

  @Column(nullable = false, length = 30)
  private LocalTime screenTime;

  @Column(nullable = false, length = 60)
  private String info;

  @Column(nullable = false, length = 10)
  @Size(min = 0, max = 10)
  private int rating;
}
