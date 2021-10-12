package mandatory.cinemama.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cinema_theaters", schema = "cinemama")
public class CinemaTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaTheaterId;

    private String name;
    private String address;
    private List<CinemaHall> cinemaHalls;
}
