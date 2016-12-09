package wad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import wad.domain.Image;
import org.springframework.stereotype.Service;
import wad.domain.HashTag;
import wad.repository.HashTagRepository;
import wad.repository.ImageRepository;

@Service
public class HashTagService {

    @Autowired
    private HashTagRepository hashTagRepository;
    @Autowired
    private ImageRepository imageRepository;

    public void addHashTags(Long imageId) {
        Image image = imageRepository.findOne(imageId);
        if(image == null){
            return;
        }
        String[] splits = image.getCaption().split(" ");
        
        if (splits == null) {
            return;
        }
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].startsWith("#") && splits[i].length() > 1 && !splits[i].substring(1, splits[i].length() - 1).contains("#")) {
                String tag = splits[i];
                List<HashTag> tags = hashTagRepository.findByTag(tag);
                HashTag hashTag;
                if (tags.size() == 0) {
                    hashTag = new HashTag();
                    hashTag.setTag(tag);
                } else {
                    hashTag = tags.get(0);
                }

                imageRepository.findOne(image.getId()).getHashTags().add(hashTag);
                hashTag.getImages().add(image);
                hashTagRepository.save(hashTag);
            }
        }
       

    }

}
