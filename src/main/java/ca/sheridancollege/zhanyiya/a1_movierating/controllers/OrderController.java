package ca.sheridancollege.zhanyiya.a1_movierating.controllers;

import ca.sheridancollege.zhanyiya.a1_movierating.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class OrderController {
    private final MovieRepository movieRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("movieList", movieRepository.findAll());
        return "index";
    }

    @GetMapping("/orderByTitle")
    public String orderByTitle(Model model) {
        model.addAttribute("movieList", movieRepository.findAllByOrderByTitleAsc());
        return "index";
    }

    @GetMapping("/orderByStarRating")
    public String orderByStarRating(Model model) {
        model.addAttribute("movieList", movieRepository.findAllByOrderByStarRatingAsc());
        return "index";
    }

    @GetMapping("/orderByYearOfRelease")
    public String orderByYearOfRelease(Model model) {
        model.addAttribute("movieList", movieRepository.findAllByOrderByYearOfReleaseAsc());
        return "index";
    }
}
