package mandatory.cinemama.Services.ActorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.ActorRepository;
import mandatory.cinemama.Utils.DTOConverter;
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
  public List<Actor> findActorsByNameContaining(
    String firstName,
    boolean isExtended
  ) {
    List<Actor> actors = actorRepository.findByNameContaining(firstName);
    ErrorMessageCreator.throwErrorIfNotFound(actors, firstName, type);
    if (!isExtended) {
      List<ActorDTO> actorDTOs = DTOConverter.mapListDTO(
        actors,
        ActorDTO.class
      );
      actors = DTOConverter.mapListDTO(actorDTOs, Actor.class);
    }
    return actors;
  }

  @Override
  public void updateActorById(ActorDTO actor, Long id) {
    Actor foundActor = actorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundActor.setName(actor.getName());
    actorRepository.save(foundActor);
  }

  @Override
  public void addActor(ActorDTO actor) {
    actorRepository.save(DTOConverter.mapDTO(actor, Actor.class));
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
