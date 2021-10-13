package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaTheater;

import java.util.List;

public interface CinemaTheaterService {
  List<CinemaTheater> getAll();
  CinemaTheater getById(int id);
}
