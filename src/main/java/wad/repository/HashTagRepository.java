
package wad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {
    List<HashTag> findByTag(String tag);
}
