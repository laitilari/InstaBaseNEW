
package wad.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Comment;
import wad.domain.Image;

@Service
public class ImageService {
  public List<Image> reverseImageList(List<Image> images){
        List<Image> list = images;
        Collections.reverse(list);
        return list;
    }
    
}
