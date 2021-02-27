package ca.sheridancollege.zhanyiya.a1_movierating.repository;

import ca.sheridancollege.zhanyiya.a1_movierating.beans.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Movie findByIdEquals(Long id);
    public List<Movie> findByTitleContains(String title);
    public List<Movie> findAllByOrderByTitleAsc();
    public List<Movie> findAllByOrderByYearOfReleaseAsc();
    public List<Movie> findAllByOrderByStarRatingAsc();
}
