package Repositories;

import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import Repositories.GenreRepository;

import java.util.List;

  public interface GenreRepository extends JpaRepository<> {
    List<Genre>
  }

