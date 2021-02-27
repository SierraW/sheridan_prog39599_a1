package ca.sheridancollege.zhanyiya.a1_movierating.controllers;

import ca.sheridancollege.zhanyiya.a1_movierating.beans.Movie;
import ca.sheridancollege.zhanyiya.a1_movierating.beans.Review;
import ca.sheridancollege.zhanyiya.a1_movierating.repository.MovieRepository;
import ca.sheridancollege.zhanyiya.a1_movierating.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class MainController {
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }

    @PostMapping("/findByTitle")
    public String findByTitle(Model model, @RequestParam String title) {
        model.addAttribute("movieList", movieRepository.findByTitleContains(title));
        Movie movie = new Movie();
        movie.setTitle(title);
        model.addAttribute("movie", movie);
        return "findResult";
    }

    @PostMapping("/details")
    public String details(Model model, @RequestParam String id) {
        Movie movie = movieRepository.findByIdEquals(Long.valueOf(id));
        model.addAttribute("movie", movie);
        model.addAttribute("reviewList", movie.getReviewList());
        Review review = Review.builder().movie(movie).build();
        model.addAttribute("review", review);
        return "details";
    }

    @GetMapping("/details/{movie_id}")
    public String getDetails(Model model, @PathVariable String movie_id) {
        Movie movie = movieRepository.findByIdEquals(Long.valueOf(movie_id));
        model.addAttribute("movie", movie);
        model.addAttribute("reviewList", movie.getReviewList());
        Review review = Review.builder().movie(movie).build();
        model.addAttribute("review", review);
        return "details";
    }

    @PostMapping("/addReview")
    public String addReview(Model model, @ModelAttribute Review review, @RequestParam String movie_id) {
        Movie movie = movieRepository.findByIdEquals(Long.parseLong(movie_id));
        review.setMovie(movie);
        Review savedReview = reviewRepository.save(review);
        double combinedRating = 0;
        for (Review r: movie.getReviewList()) {
            combinedRating += r.getStar();
        }
        movie.setStarRating(combinedRating / movie.getReviewList().size());
        Movie savedMovie = movieRepository.save(movie);

        model.addAttribute("movie", savedMovie);
        model.addAttribute("reviewList", savedMovie.getReviewList());
        Review newReview = Review.builder().movie(savedMovie).build();
        model.addAttribute("review", newReview);

        return "details";
    }

    @PostMapping("/addMovie")
    public String addMovie(Model model, @ModelAttribute Movie movie) {
        movie.setStarRating(0.0);
        Movie savedMovie = movieRepository.save(movie);

        model.addAttribute("movie", movie);
        model.addAttribute("reviewList", movie.getReviewList());
        Review newReview = Review.builder().movie(movie).build();
        model.addAttribute("review", newReview);

        return "details";
    }
}
