package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaTheater;

import java.util.List;

public interface CinemaTheaterService {
  List<CinemaTheater> findAll();
  List<CinemaTheater> findAllById(Long id);
  List<CinemaTheater> findAllByName(String name);
  CinemaTheater findByAddress(String address);
}
