package mandatory.cinemama.Controllers.MovieController;

import io.swagger.annotations.ApiOperation;
import mandatory.cinemama.Entities.Movie;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



public interface MovieControllerInterface {

    @ApiOperation("Returns the movie based on the ID")
    @GetMapping("/{id}")
    public Movie findMovieById(@RequestParam(required = false) String type, @PathVariable Long id);

    @ApiOperation("Deletes the movie based on the ID")
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id);

    @ApiOperation("Returns all the movies")
    @GetMapping
    public List<Movie> findAllMovies();

    @ApiOperation("Returns the movies based on the title")
    @GetMapping("/title/{title}")
    public Movie findMovieByTitle(@RequestParam(required = false) String type, @PathVariable String title);

    @ApiOperation("Adds the movie to the database")
    @PostMapping()
    public Movie addMovie(@RequestBody Movie movie);

}
