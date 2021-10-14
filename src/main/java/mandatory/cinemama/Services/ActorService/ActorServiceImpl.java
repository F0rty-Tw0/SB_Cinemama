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
    List<Actor> actors = actorRepository.findActorsByFirstName(firstName);
    return actors;
  }

  @Override
  public List<Actor> findActorsByLastName(String lastName) {
    List<Actor> actors = actorRepository.findActorsByLastName(lastName);
    return actors;
  }

  @Override
  public Actor addActor(Actor actor) {
    Actor newActor = actorRepository.save(actor);
    return newActor;
  }
}
