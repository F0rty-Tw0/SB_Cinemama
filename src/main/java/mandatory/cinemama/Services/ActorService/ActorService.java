package mandatory.cinemama.Services.ActorService;

import java.util.List;
import java.util.Optional;

import mandatory.cinemama.Entities.Actor;

public interface ActorService {
  public Actor findActorById(Long id);

  public List<Actor> findAllActors();

  public List<Actor> findActorsByFirstName(String firstName);

  public List<Actor> findActorsByLastName(String lastName);

  public Actor addActor(Actor actor);

  public void deleteActorById(Long id);
}
