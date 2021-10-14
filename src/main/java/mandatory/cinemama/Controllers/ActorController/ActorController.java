package mandatory.cinemama.Controllers.ActorController;

import java.util.List;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Services.ActorService.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/actor")
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
  public List<Actor> findActorsByFirstName(String firstName) {
    return actorService.findActorsByFirstName(firstName);
  }

  @Override
  public List<Actor> findActorsByLastName(String lastName) {
    return actorService.findActorsByLastName(lastName);
  }

  @Override
  public Actor addActor(Actor actor) {
    return actorService.addActor(actor);
  }

  @Transactional
  @Override
  public void deleteActorById(Long id) {
    actorService.deleteActorById(id);
  }
}
