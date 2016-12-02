
package wad.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
import wad.domain.Comment;
import wad.domain.Image;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;
import wad.service.ImageService;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    private Image testImage;
    private Account testAccount;
    private Comment testComment;
    
    public AccountControllerTest() {
    }

    @Before
    public void setUp() {
        // Setup for Integration tests
        testImage = new Image();
        testAccount = new Account(); 
        testAccount.setPassword("password");
        testAccount.setUsername("username");
        testComment = new Comment();
        testComment.setContent("This is a test comment.");
        
        // Setup for System tests
    }
    
    // INTEGRATION TEST
    public void addingImageToAccountWorks() {
        accountService.addImage(testImage, testAccount);
        assertThat(imageRepository.findOne(testImage.getId()), is(not(null)));
        assertTrue(testAccount.getImages().contains(testImage));
    }
    
    public void addingCommentToImageWorks() {
        accountService.commentImage(testImage, testComment);
        assertThat(commentRepository.findOne(testComment.getId()), is(not(null)));
        assertTrue(testImage.getComments().contains(testComment));
    }
    
    public void likingImageWorks() {
        int testImageLikes = testImage.getLikes().size();
        accountService.likeImage(testImage);
        assertTrue(testImage.getLikes().contains(testAccount));
        assertTrue(testImage.getLikes().size() == testImageLikes + 1);
    }
    
    // SYSTEM TESTS
    
}
