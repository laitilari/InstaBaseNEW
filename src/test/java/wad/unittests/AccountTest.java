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

public class AccountTest {

    public AccountTest() {
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
    public void correctAccountUsername() {
        Account a = new Account();
        a.setUsername("Test");
        assertEquals("Test", a.getUsername());
    }

    @Test
    public void correctAccountPassword() {
        Account a = new Account();
        a.setPassword("testpassword");
        assertEquals("testpassword", a.getPassword());
    }

    @Test
    public void correctAccountFollowers() {
        Account a = new Account();
        List<Account> followers = new ArrayList<>();
        a.setFollowers(followers);
        assertEquals(followers, a.getFollowers());
    }

    @Test
    public void setCommentWorks() {
        Account a = new Account();
        List<Account> comments = new ArrayList<>();
        a.setFollowers(comments);
        assertEquals(comments, a.getComments());
    }

    @Test
    public void MethodFindCommentByContentReturnsCorrectComment() {
        Account a = new Account();
        Comment c = new Comment();
        c.setContent("Hello");
        a.addComment(c);
        assertEquals(c, a.findCommentByContent("Hello"));
    }
    
    @Test
    public void MethodFindCommentByContentReturnsNullCorrectly() {
        Account a = new Account();
        Comment c = new Comment();
        c.setContent("Hello");
        a.addComment(c);
        assertEquals(null, a.findCommentByContent("Hi"));
    }
}
