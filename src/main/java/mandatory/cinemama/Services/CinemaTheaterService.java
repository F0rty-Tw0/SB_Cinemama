package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaTheater;

import java.util.List;

public interface CinemaTheaterService {
  List<CinemaTheater> findAll();
  List<CinemaTheater> findCinemaTheaterById(Long id);
  List<CinemaTheater> findCinemaTheaterByName(String name);
  List<CinemaTheater> findCinemaTheaterByAddress(String address);
}
