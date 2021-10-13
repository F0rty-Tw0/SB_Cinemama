package mandatory.cinemama.Services.MovieService;

import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired


    @Override
    public Optional<Movie> findById(Long id){
       return movieRepository.findById(id);
    }


    @Override
    public void deleteMovieById(Long id){
        movieRepository.deleteMovieById(id);
    }

    @Override
    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findMoviesByActor(String actor){
        return movieRepository.findMoviesByActor(actor);
    }

    @Override
    public List<Movie> findMoviesByDirector(String director){
        return movieRepository.findMoviesByDirector(director);
    }

    @Override
    public List<Movie> findMoviesByGenre(String genre){
        return movieRepository.findMoviesByGenre(genre);
    }

    @Override
    public Movie findMovieByTitle (String title){
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(long id) {
       Optional<Movie> foundMovie = movieRepository.findById(id);
       Movie newMovie = new Movie();
       newMovie.setActors(foundMovie.get().getActors());
       newMovie.setMinAge(foundMovie.get().getMinAge());
       newMovie.setDirectors(foundMovie.get().getDirectors());
       newMovie.setGenres(foundMovie.get().getGenres());
       newMovie.setRating(foundMovie.get().getRating());
       newMovie.setInfo(foundMovie.get().getInfo());
       newMovie.setScreenTime(foundMovie.get().getScreenTime());
       return newMovie;
    }
}
