package mandatory.cinemama.Services.ActorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

  @Autowired
  private ActorRepository actorRepository;

  private String type = "Actor";

  @Operation(security = @SecurityRequirement(name = "basicAuth"))
  @Override
  public List<Actor> findAllActors() {
    List<Actor> allActors = actorRepository.findAll();
    ErrorMessageCreator.throwErrorIfNotFound(allActors, "of All", type);
    return allActors;
  }

  @Override
  public Actor findActorById(Long id) {
    Actor actor = actorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return actor;
  }

  @Override
  public List<Actor> findActorsByFirstName(String firstName) {
    List<Actor> actors = actorRepository.findByFirstName(firstName);
    ErrorMessageCreator.throwErrorIfNotFound(actors, firstName, type);
    return actors;
  }

  @Override
  public List<Actor> findActorsByLastName(String lastName) {
    List<Actor> actors = actorRepository.findByLastName(lastName);
    ErrorMessageCreator.throwErrorIfNotFound(actors, lastName, type);
    return actors;
  }

  @Override
  public Actor findActorsByFirstNameAndLastName(
    String firstName,
    String lastName
  ) {
    Actor actor = actorRepository
      .findByFirstNameAndLastName(firstName, lastName)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(
              firstName + " " + lastName,
              type
            )
          )
      );
    return actor;
  }

  @Override
  public void updateActorById(Actor actor, Long id) {
    Actor foundActor = actorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundActor.setFirstName(actor.getFirstName());
    foundActor.setLastName(actor.getLastName());
    actorRepository.save(foundActor);
  }

  @Override
  public void addActor(Actor actor) {
    actorRepository.save(actor);
  }

  @Override
  public void deleteActorById(Long id) {
    try {
      actorRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }
}
