package mandatory.cinemama.Controllers.ActorController;

import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Services.ActorService.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController implements ActorControllerInterface{

    @Autowired
    private ActorService actorService;


    @Override
    public Actor findActorById(Long id) {

    }

    @Override
    public List<Actor> findAllActors() {
        return null;
    }

    @Override
    public List<Actor> findActorsByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Actor> findActorsByLastName(String lastName) {
        return null;
    }

    @Override
    public Actor addActor(Actor actor) {
        return null;
    }
}
