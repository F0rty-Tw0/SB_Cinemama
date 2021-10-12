package mandatory.cinemama.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table
@Getter
@Setter
public class Movie {
    @Id
    public Long id;
    public String title;
    public String genres; // list<Geners>
    public String actors; // list<Actors>
    public String directors; // list<Directors>
    public int minAge;
    public Time screenTime;
    public String info;
    public int raiting;

    public Movie() {
    }

    public Movie(Long id, String title, String genres, String actors, String directors, int minAge, Time screenTime, String info, int raiting) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.actors = actors;
        this.directors = directors;
        this.minAge = minAge;
        this.screenTime = screenTime;
        this.info = info;
        this.raiting = raiting;
    }
}
