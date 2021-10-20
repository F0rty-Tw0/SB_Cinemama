package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;

import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  private String type = "Movie";

  @Override
  public List<Movie> findAllMovies() {
    List<Movie> allMovies = movieRepository.findAll();
    return allMovies;
  }


  @Override
  public Movie findMovieById(Long id) {
    Movie movie = movieRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return movie;
  }

  @Override
  public Movie findMovieByTitle(String title) {
    Movie foundMovies = movieRepository
      .findByTitle(title)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(title, type)
          )
      );
    return foundMovies;
  }

  @Override
  public List<Movie> findMoviesByInfoContaining(String info) {
    List<Movie> allMovies = movieRepository.findByInfoContaining(info);
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, info, type);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByMinAgeLessThan(int minAge) {
    List<Movie> allMovies = movieRepository.findByMinAgeLessThan(minAge);
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, minAge, type);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByMinAgeGreaterThan(int minAge) {
    List<Movie> allMovies = movieRepository.findByMinAgeGreaterThan(minAge);
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, minAge, type);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByRating(int rating) {
    List<Movie> allMovies = movieRepository.findByRating(rating);
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, rating, type);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    List<Movie> allMovies = movieRepository.findByScreenTimeLessThan(
      screenTime
    );
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, screenTime, type);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByScreenTimeGreaterThan(LocalTime screenTime) {
    List<Movie> allMovies = movieRepository.findByScreenTimeGreaterThan(
      screenTime
    );
    ErrorMessageCreator.throwErrorIfNotFound(allMovies, screenTime, type);
    return allMovies;
  }

  @Override
  public String findInfoByTitle(String title) {
    Movie info = movieRepository
      .findInfoByTitle(title)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(title, type)
          )
      );
    return info.getInfo();
  }

  @Override
  public void updateMovieById(Movie movie, Long id) {
    Movie foundMovie = movieRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundMovie.setActors(movie.getActors());
    foundMovie.setDirectors(movie.getDirectors());
    foundMovie.setGenres(movie.getGenres());
    foundMovie.setTitle(movie.getTitle());
    foundMovie.setInfo(movie.getInfo());
    foundMovie.setRating(movie.getRating());
    foundMovie.setMinAge(movie.getMinAge());
    movieRepository.save(foundMovie);
  }

  @Override
  public void addMovie(Movie movie) {
    movieRepository.save(movie);
  }

  @Override
  public void deleteMovieById(Long id) {
    try {
      movieRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }
}
