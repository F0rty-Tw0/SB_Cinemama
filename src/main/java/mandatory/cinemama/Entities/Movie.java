package mandatory.cinemama.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

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
    public Long id;

    @Column(nullable = false, length = 40)
    public String title;

    @Column(nullable = false, length = 30)
    public String genres; //  TODO: list<Geners>

    @Column(nullable = false, length = 60)
    public String actors; // TODO: list<Actors>

    @Column(nullable = false, length = 60)
    public String directors; // TODO: list<Directors>

    @Column(nullable = true)
    public int minAge;

    @Column(nullable = false, length = 30)
    public LocalTime screenTime;

    @Column(nullable = false, length = 60)
    public String info;

    @Column(nullable = false, length = 30)
    public int raiting;


}
