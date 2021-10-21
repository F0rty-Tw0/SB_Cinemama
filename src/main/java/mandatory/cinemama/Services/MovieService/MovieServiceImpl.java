package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.MovieInputDTO;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.Genre;
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
  public void updateMovieById(MovieInputDTO movie, Long id) {
    Movie foundMovie = movieRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    if (movie.getTitle() != null) {
      foundMovie.setTitle(movie.getTitle());
    }
    if (movie.getMinAge() != null) {
      foundMovie.setMinAge(movie.getMinAge());
    }
    if (movie.getInfo() != null) {
      foundMovie.setInfo(movie.getInfo());
    }
    if (movie.getRating() != null) {
      foundMovie.setRating(movie.getRating());
    }
    if (movie.getTrailer() != null) {
      foundMovie.setTrailer(movie.getTrailer());
    }
    if (movie.getImage() != null) {
      foundMovie.setImage(movie.getImage());
    }
    if (movie.getPoster() != null) {
      foundMovie.setPoster(movie.getPoster());
    }
    if (movie.getActors() != null) {
      foundMovie.setActors(
        DTOConverter.mapSetDTO(movie.getActors(), Actor.class)
      );
    }
    if (movie.getDirectors() != null) {
      foundMovie.setDirectors(
        DTOConverter.mapSetDTO(movie.getDirectors(), Director.class)
      );
    }
    if (movie.getGenres() != null) {
      foundMovie.setGenres(
        DTOConverter.mapSetDTO(movie.getGenres(), Genre.class)
      );
    }
    movieRepository.save(foundMovie);
  }

  @Override
  public void addMovie(MovieInputDTO movie) {
    movieRepository.save(DTOConverter.mapDTO(movie, Movie.class));
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
