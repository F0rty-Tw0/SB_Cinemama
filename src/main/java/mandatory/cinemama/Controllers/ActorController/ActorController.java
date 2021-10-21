package mandatory.cinemama.Controllers.ActorController;

import java.util.List;
import javax.transaction.Transactional;

import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Services.ActorService.ActorService;
import mandatory.cinemama.Utils.CheckExtended;

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
  public List<Actor> findActorsByNameContaining(String name, String type) {
    return actorService.findActorsByNameContaining(name, CheckExtended.isExtended(type));
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
