package wad.unittests;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.domain.Account;
import wad.domain.Comment;
import wad.domain.HashTag;
import wad.domain.Image;

public class ImageTest {
    
    public ImageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void correctImageCaption() {
        Image i = new Image();
        i.setCaption("Hello!");
        assertEquals("Hello!", i.getCaption());
    }

    @Test
    public void correctImageAccount() {
        Image i = new Image();
        Account a = new Account();
        i.setAccount(a);
        assertEquals(a, i.getAccount());
    }

    @Test
    public void correctImageComments() {
        Image i = new Image();
        ArrayList<Comment> comments = new ArrayList<>();
        i.setComments(comments);
        assertEquals(comments, i.getCommentList());
    }
    
    @Test
    public void correctImageAmountOfComments() {
        Image i = new Image();
        ArrayList<Comment> comments = new ArrayList<>();
        Comment c1 = new Comment();
        Comment c2 = new Comment();
        comments.add(c1);
        comments.add(c2);
        i.setComments(comments);
        assertEquals(2, i.getComments());
    }

    @Test
    public void correctImageHashTags() {
        Image i = new Image();
        List<HashTag> hashtags = new ArrayList<>();
        i.setHashTags(hashtags);
        assertEquals(hashtags, i.getHashTags());
    }

    @Test
    public void correctImageAmountOfLikes() {
        Account a = new Account();
        Account b = new Account();
        Image i = new Image();
        i.addLike(a);
        i.addLike(a);
        i.addLike(b);
        assertEquals(2, i.getLikes());
    }
    
    
}
