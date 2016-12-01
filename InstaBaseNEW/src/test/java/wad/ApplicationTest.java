
package wad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;
import wad.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    private Image testImage;
    private Account testAccount;
    
    public ApplicationTest() {
    }

    @Before
    public void setUp() {
        testImage = new Image();
        testAccount = new Account();        
    }
    
    //KESKEN
    public void addingImageToAccountWorks() {
        accountService.addImage(testImage, testAccount);
        Long imageId = testImage.getId();
        assertThat(imageRepository.findOne(imageId), is(not(null)));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
