package mandatory.cinemama.Controllers.MovieController;


import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Services.MovieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements MovieControllerInterface {

    @Autowired
    private MovieService movieService;



   @Override
   public Movie findMovieById(@RequestParam(required = false) String type, @PathVariable Long id){
       return movieService.findMovieById(id);
   }

   @Override
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
   }

   @Override
   public List<Movie> findAllMovies(){
    return findAllMovies();
   }

   @Override
   public Movie findMovieByTitle(@RequestParam(required = false) String type, @PathVariable String title){
    return movieService.findMovieByTitle(title);
   }

   @Override
       public Movie addMovie(@RequestBody Movie movie){
       return movieService.addMovie(movie);
   }



}
