package mandatory.cinemama.Services.ActorService;

import java.util.List;
import mandatory.cinemama.Entities.Actor;

public interface ActorService {
  public Actor findActorById(Long id);

  public List<Actor> findAllActors();

  public List<Actor> findActorsByFirstName(String firstName);

  public List<Actor> findActorsByLastName(String lastName);

  public Actor findActorsByFirstNameAndLastName(
    String firstName,
    String lastName
  );

  public void deleteActorById(Long id);

  public void addActor(Actor actor);
}
