package mandatory.cinemama.Controllers.ActorController;

import java.util.List;
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
  public List<Actor> findActorsByFirstName(String firstName) {
    return actorService.findActorsByFirstName(firstName);
  }

  @Override
  public List<Actor> findActorsByLastName(String lastName) {
    return actorService.findActorsByLastName(lastName);
  }

  @Override
  public Actor findActorsByFirstNameAndLastName(
    String firstName,
    String lastName
  ) {
    return actorService.findActorsByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  public void addActor(Actor actor) {
    actorService.addActor(actor);
  }

  @Override
  public void deleteActorById(Long id) {
    actorService.deleteActorById(id);
  }
}
