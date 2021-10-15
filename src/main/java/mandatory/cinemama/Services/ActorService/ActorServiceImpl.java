package mandatory.cinemama.Services.ActorService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

  private ActorRepository actorRepository;

  @Autowired
  public ActorServiceImpl(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }

  @Override
  public List<Actor> findAllActors() {
    List<Actor> allActors = actorRepository.findAll();
    return allActors;
  }

  @Override
  public Actor findActorById(Long id) {
    Optional<Actor> actor = actorRepository.findById(id);
    return actor.get();
  }

  @Override
  public List<Actor> findActorsByFirstName(String firstName) {
    List<Actor> actors = actorRepository.findByFirstName(firstName);
    return actors;
  }

  @Override
  public List<Actor> findActorsByLastName(String lastName) {
    List<Actor> actors = actorRepository.findByLastName(lastName);
    return actors;
  }

  @Override
  public Actor findActorsByFirstNameAndLastName(
    String firstName,
    String lastName
  ) {
    Optional<Actor> actor = actorRepository.findByFirstNameAndLastName(
      firstName,
      lastName
    );
    return actor.get();
  }

  @Override
  public void updateActorById(Actor actor, Long id) {
    Optional<Actor> foundActor = actorRepository.findById(id);
    if (foundActor.isPresent()) {
      foundActor.get().setFirstName(actor.getFirstName());
      foundActor.get().setLastName(actor.getLastName());
      actorRepository.save(foundActor.get());
    } else {
      System.out.println("Error handling");
    }

  }

  @Override
  public void deleteActorById(Long id) {
    actorRepository.deleteById(id);
  }

  @Override
  public void addActor(Actor actor) {
    actorRepository.save(actor);
  }
}
