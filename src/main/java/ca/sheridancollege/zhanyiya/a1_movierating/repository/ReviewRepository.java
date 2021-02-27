package ca.sheridancollege.zhanyiya.a1_movierating.repository;

import ca.sheridancollege.zhanyiya.a1_movierating.beans.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
