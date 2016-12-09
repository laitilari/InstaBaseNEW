
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class HashTag extends AbstractPersistable<Long>{
    
    private String tag;
    
    @ManyToMany
    private List<Image> images;

    public HashTag() {
        this.images = new ArrayList<>();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> image) {
        this.images = image;
    }
   
    
    
}
