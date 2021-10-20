package mandatory.cinemama.Services.ActorService;

import java.util.List;
import mandatory.cinemama.Entities.Actor;

public interface ActorService {
  public Actor findActorById(Long id);

  public List<Actor> findAllActors();

  public List<Actor> findActorsByNameContaining(String name);

  public void updateActorById(Actor actor, Long id);

  public void deleteActorById(Long id);

  public void addActor(Actor actor);
}
