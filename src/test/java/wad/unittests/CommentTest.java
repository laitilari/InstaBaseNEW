
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


public class CommentTest {
    
    public CommentTest() {
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
    public void correctCommentAccount() {
        Comment c = new Comment();
        Account a = new Account();
        c.setAccount(a);
        assertEquals(a, c.getAccount());
    }

    @Test
    public void correctCommentContent() {
        Comment c = new Comment();
        c.setContent("Hello!");
        assertEquals("Hello!", c.getContent());   
    }

    @Test
    public void correctCommentIdentificator() {
        Comment c = new Comment();
        c.setIdentificator("id");
        assertEquals("id", c.getIdentificator());  
    }
}
