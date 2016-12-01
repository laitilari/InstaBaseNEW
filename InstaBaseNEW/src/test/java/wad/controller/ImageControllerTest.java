package wad.controller;

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
import wad.domain.Likee;
import wad.domain.Image;
import wad.repository.AccountRepository;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;
import wad.repository.LikeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageControllerTest {
    
    private Image testImage;
    private Account testAccount;
    private Comment testComment;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private LikeeRepository likeeRepository;
    
    @Before
    public void setUp() {
        testImage = new Image();
        testAccount = new Account();        
    }
    
    public void addingImageToAccountWorks() {
        testAccount.
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
