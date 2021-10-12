package mandatory.cinemama.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinema_theaters", schema = "cinemama")
public class CinemaTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    private String cinemaHalls; // List
}
