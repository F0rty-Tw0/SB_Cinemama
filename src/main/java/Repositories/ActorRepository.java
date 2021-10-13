package Repositories;

import mandatory.cinemama.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import Repositories.ActorRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<> {
    List<Actor>
}
