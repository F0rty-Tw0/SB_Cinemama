package mandatory.cinemama.Services.ActorService;

import java.util.List;

import mandatory.cinemama.Entities.Actor;

public interface ActorService {
  List<Actor> findAllActors();
  Actor findActorById(Long id);
  List<Actor> findActorsByFirstName(String firstName);
  List<Actor> findActorsByLastName(String lastName);
}
