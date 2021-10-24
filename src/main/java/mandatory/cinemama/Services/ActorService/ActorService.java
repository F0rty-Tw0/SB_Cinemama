package mandatory.cinemama.Services.ActorService;

import java.util.List;
import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.Entities.Actor;

public interface ActorService {
  public List<Actor> findAllActors();

  public Actor findActorById(Long id);

  public List<Actor> findActorsByNameContaining(String name, boolean isExtended);

  public void updateActorById(ActorDTO actor, Long id);

  public void addActor(ActorDTO actor);

  public void deleteActorById(Long id);
}
