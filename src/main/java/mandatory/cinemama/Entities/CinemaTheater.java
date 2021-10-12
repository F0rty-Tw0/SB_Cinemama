package mandatory.cinemama.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
//@Table(name = "CinemaHalls", schema = "?")
public class CinemaTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CinemaTheaterId;

    private String name;
    private String address;
    private List<CinemaHall> cinemaHalls;
}
