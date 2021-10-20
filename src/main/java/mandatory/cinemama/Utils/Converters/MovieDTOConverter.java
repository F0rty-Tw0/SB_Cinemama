package mandatory.cinemama.Utils.Converters;

import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.Entities.Movie;
import org.modelmapper.ModelMapper;

public class MovieDTOConverter {

  private ModelMapper modelMapper = new ModelMapper();

  public MovieDTO convertMovieToMovieDTO(Movie movie) {
    return modelMapper.map(movie, MovieDTO.class);
  }

  public Movie convertMovieDTOToEntity(MovieDTO movieDTO) {
    return modelMapper.map(movieDTO, Movie.class);
  }
}
