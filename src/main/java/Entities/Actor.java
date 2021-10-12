package Entities;

import javax.persistence.;
import java.util.ArrayList;
import java.util.List;

public class Actor {

    private String movieList;
    private String firstName;
    private String lastName;
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "Actor")
    List<Genre> actorList = new ArrayList<>();


    public Actor(String firstName, String lastName, int age, String movieList){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.movieList = movieList;

    }


}
