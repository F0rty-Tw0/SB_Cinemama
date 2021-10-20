package mandatory.cinemama.Controllers.ActorController;

import java.util.List;
import javax.transaction.Transactional;

import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Services.ActorService.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController implements ActorControllerInterface {

  @Autowired
  private ActorService actorService;

  @Override
  public Actor findActorById(Long id) {
    return actorService.findActorById(id);
  }

  @Override
  public List<Actor> findAllActors() {
    return actorService.findAllActors();
  }

  @Override
  public List<ActorDTO> findActorsByNameContaining(String name) {
    return actorService.findActorsByNameContaining(name);
  }

  @Override
  public void updateActorById(ActorDTO actor, Long id) {
    actorService.updateActorById(actor, id);
  }

  @Override
  public void addActor(ActorDTO actor) {
    actorService.addActor(actor);
  }

  @Transactional
  @Override
  public void deleteActorById(Long id) {
    actorService.deleteActorById(id);
  }
}
