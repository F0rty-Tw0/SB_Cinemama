package mandatory.cinemama.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    private Long id;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false, length = 30)
    private String genres; //  TODO: list<Geners>

    @Column(nullable = false, length = 60)
    private String actors; // TODO: list<Actors>

    @Column(nullable = false, length = 60)
    private String directors; // TODO: list<Directors>


    private int minAge;

    @Column(nullable = false, length = 30)
    private LocalTime screenTime;

    @Column(nullable = false, length = 60)
    private String info;

    @Column(nullable = false, length = 10)
    @Size(min = 0, max=10)
    private int rating;


}
