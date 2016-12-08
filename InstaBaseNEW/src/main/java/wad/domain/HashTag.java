
package wad.domain;

import javax.persistence.Entity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Profile("production")
@Entity
public class HashTag extends AbstractPersistable<Long>{
    
    private String tag;
    
//    @OneToMany
//    private Image image;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
//    
    
    
}
