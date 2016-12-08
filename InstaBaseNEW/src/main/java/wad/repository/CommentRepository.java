package wad.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Comment;

@Profile("production")
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
