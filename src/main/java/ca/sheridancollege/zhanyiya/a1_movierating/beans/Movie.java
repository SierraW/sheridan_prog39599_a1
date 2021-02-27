package ca.sheridancollege.zhanyiya.a1_movierating.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private Integer yearOfRelease;
    private String uri;
    private Double starRating = 0.0;
    @OneToMany
    @JoinTable(name = "REVIEW_MOVIE", joinColumns = @JoinColumn(name = "MOVIE_ID"), inverseJoinColumns = @JoinColumn(name = "REVIEW_ID"))
    private List<Review> reviewList;
}
