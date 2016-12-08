
package wad.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Image;

@Profile("production")
public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
