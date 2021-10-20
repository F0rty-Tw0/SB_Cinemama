package mandatory.cinemama.Controllers.MovieController;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import mandatory.cinemama.DTO.MovieDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Services.ActorService.ActorService;
import mandatory.cinemama.Services.MovieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController implements MovieControllerInterface {

  @Autowired
  private MovieService movieService;
  private ActorService actorService;

  @Override
  public List<Movie> findAllMovies() {
    return movieService.findAllMovies();
  }

    @Override
    public Movie findMovieById(Long id) { return movieService.findMovieById(id);
    }

  @Override
  public MovieDTO getInfoById(Long id) {
    Movie myMovie = movieService.findMovieById(id);
    MovieDTO movieDTO = new MovieDTO();
    movieDTO.setTitle(myMovie.getTitle());
    List<String> genre = new ArrayList<>();
    for(int i=0; i<myMovie.getGenres().size(); i++){
      genre.add(myMovie.getGenres().get(i).getName().toString());
    }
    movieDTO.setGenres(genre);

   List<String> actors = new ArrayList<>();
   for(int i=0; i<myMovie.getActors().size(); i++){
       String actor= "";
       actor = myMovie.getActors().get(i).getFirstName().concat(" ");
      actor = actor.concat(myMovie.getActors().get(i).getLastName());
    actors.add(actor);
    }

      movieDTO.setActors(actors);

      List<String> directors = new ArrayList<>();
    for(int i=0; i<myMovie.getDirectors().size(); i++){
        String director = "";
     director = myMovie.getDirectors().get(i).getFirstName().concat(" ");
     director= director.concat(myMovie.getDirectors().get(i).getLastName());
     directors.add(director);
    }
    movieDTO.setDirectors(directors);

    movieDTO.setMinage(myMovie.getMinAge());
    movieDTO.setInfo(myMovie.getInfo());
    movieDTO.setScreenTime(myMovie.getScreenTime());
    movieDTO.setTrailerLink(myMovie.getTrailerLink());
    movieDTO.setImageLink(myMovie.getImageLink());
    movieDTO.setPosterLink(myMovie.getPosterLink());
    return movieDTO;
  }

  @Override
  public Movie findMovieByTitle(String title) {
    return movieService.findMovieByTitle(title);
  }

  @Override
  public List<Movie> findMoviesByInfoContaining(String info) {
    return movieService.findMoviesByInfoContaining(info);
  }

  @Override
  public List<Movie> findMoviesByMinAgeLessThan(int minAge) {
    return movieService.findMoviesByMinAgeLessThan(minAge);
  }

  @Override
  public List<Movie> findMoviesByMinAgeGreaterThan(int minAge) {
    return movieService.findMoviesByMinAgeGreaterThan(minAge);
  }

  @Override
  public List<Movie> findMoviesByRating(int rating) {
    return movieService.findMoviesByRating(rating);
  }

  @Override
  public List<Movie> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    return movieService.findMoviesByScreenTimeLessThan(screenTime);
  }

  @Override
  public List<Movie> findMoviesByScreenTimeGreaterThan(LocalTime screenTime) {
    return movieService.findMoviesByScreenTimeGreaterThan(screenTime);
  }

  @Override
  public String findInfoByTitle(String title) {
    return movieService.findInfoByTitle(title);
  }

  @Override
  public void updateMovieById(Movie movie, Long id) {
    movieService.updateMovieById(movie, id);
  }

  @Override
  public void addMovie(Movie movie) {
    movieService.addMovie(movie);
  }

  @Transactional
  @Override
  public void deleteMovieById(Long id) {
    movieService.deleteMovieById(id);
  }
}
