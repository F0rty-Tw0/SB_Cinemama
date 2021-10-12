package mandatory.cinemama.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mandatory.cinemama.Entities.Genre.Genre;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies", schema= "cinemama")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 40)
    private String title;

    @OneToMany(mappedBy = "movies")
    private List<Genre> genres; //  TODO: list<Geners>

    @OneToMany(mappedBy = "movies")
    private List<Actor> actors; // TODO: list<Actors>

  //  @OneToMany(mappedBy = "movies")
 //   private List<Director> directors; // TODO: list<Directors>


    private int minAge;

    @Column(nullable = false, length = 30)
    private LocalTime screenTime;

    @Column(nullable = false, length = 60)
    private String info;

    @Column(nullable = false, length = 10)
    @Size(min = 0, max=10)
    private int rating;


}
