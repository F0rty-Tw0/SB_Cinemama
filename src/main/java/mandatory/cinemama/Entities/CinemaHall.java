package mandatory.cinemama.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name = "CinemaHalls", schema = "?")
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaHallId;

    private String name;
    private List<MovieSchedule> movieSchedules;

}
