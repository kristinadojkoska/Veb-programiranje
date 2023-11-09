package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
public List<Movie> findAll(){
    return DataHolder.movies;
}

public List<Movie> searchMovies(String text){
    return DataHolder.movies.stream().filter(r->r.getTitle().contains(text) || r.getSummary().contains(text)).collect(Collectors.toList());

}




}
