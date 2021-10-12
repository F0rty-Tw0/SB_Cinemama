package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "Genre")
    List<Genre> genreList = new ArrayList<>();






}
