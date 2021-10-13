package Services;

import Repositories.ActorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import mandatory.cinemama.Entities.Actor;

@Service
public class ActorService {
      ActorRepository actorRepository;

      public ActorService(ActorRepository actorRepository){this.actorRepository = actorRepository;}
}
