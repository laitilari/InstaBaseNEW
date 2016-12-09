package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
