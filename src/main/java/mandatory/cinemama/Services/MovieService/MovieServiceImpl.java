package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.MovieRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  private String type = "Movie";

  @Override
  public List<Movie> findAllMovies(boolean isExtended) {
    List<Movie> allMovies = movieRepository.findAll();
    if (!isExtended) {
      List<MovieDTO> movieDTOs = DTOConverter.mapListDTO(
        allMovies,
        MovieDTO.class
      );
      allMovies = DTOConverter.mapListDTO(movieDTOs, Movie.class);
    }
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
  public List<MovieDTO> findMovieByTitle(String title) {
    List<Movie> movies = movieRepository.findInfoByTitleContaining(title);
    ErrorMessageCreator.throwErrorIfNotFound(movies, title, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByInfoContaining(String info) {
    List<Movie> movies = movieRepository.findByInfoContaining(info);
    ErrorMessageCreator.throwErrorIfNotFound(movies, info, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByMinAgeLessThan(int minAge) {
    List<Movie> movies = movieRepository.findByMinAgeLessThan(minAge);
    ErrorMessageCreator.throwErrorIfNotFound(movies, minAge, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByMinAgeGreaterThan(int minAge) {
    List<Movie> movies = movieRepository.findByMinAgeGreaterThan(minAge);
    ErrorMessageCreator.throwErrorIfNotFound(movies, minAge, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByRating(int rating) {
    List<Movie> movies = movieRepository.findByRating(rating);
    ErrorMessageCreator.throwErrorIfNotFound(movies, rating, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    List<Movie> movies = movieRepository.findByScreenTimeLessThan(screenTime);
    ErrorMessageCreator.throwErrorIfNotFound(movies, screenTime, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
  }

  @Override
  public List<MovieDTO> findMoviesByScreenTimeGreaterThan(
    LocalTime screenTime
  ) {
    List<Movie> movies = movieRepository.findByScreenTimeGreaterThan(
      screenTime
    );
    ErrorMessageCreator.throwErrorIfNotFound(movies, screenTime, type);
    return DTOConverter.mapListDTO(movies, MovieDTO.class);
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
