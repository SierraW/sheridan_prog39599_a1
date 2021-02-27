package ca.sheridancollege.zhanyiya.a1_movierating.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer star;
    private String reviewTitle;
    private String reviewAuthor;
    private String reviewContent;
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "REVIEW_MOVIE", joinColumns = @JoinColumn(name = "REVIEW_ID"), inverseJoinColumns = @JoinColumn(name = "MOVIE_ID"))
    private Movie movie;
}
