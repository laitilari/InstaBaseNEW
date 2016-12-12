
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
import wad.domain.HashTag;
import wad.domain.Image;
import wad.domain.Log;


public class LogTest {
    
    public LogTest() {
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
    public void correctLogAccount() {
        Log l = new Log();
        Account a = new Account();
        l.setAccount(a);
        assertEquals(a, l.getAccount());
    }

    @Test
    public void correctLogString() {
        Log l = new Log();
        l.setLog("Hello!");
        assertEquals("Hello!", l.getLog()); 
    }
}
