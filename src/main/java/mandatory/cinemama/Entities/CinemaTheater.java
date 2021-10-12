package mandatory.cinemama.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Getter
@Setter
@Entity
@Table(name = "cinema_theaters", schema = "cinemama")
public class CinemaTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    private String cinemaHalls; // List
}
