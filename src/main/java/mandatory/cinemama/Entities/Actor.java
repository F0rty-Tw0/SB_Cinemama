package mandatory.cinemama.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "actors", schema = "cinemama")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
  private List<Movie> movies = new ArrayList<Movie>();

  public Actor(String name) {
    this.name = name;
  }

  @PreRemove
  private void removeActorFromMovies() {
    for (Movie movie : movies) {
      movie.getActors().remove(this);
    }
  }
}
