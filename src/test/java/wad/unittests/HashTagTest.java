
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

public class HashTagTest {
    
    public HashTagTest() {
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
    public void correctHashTagTag() {
        HashTag h = new HashTag();
        h.setTag("Hello!");
        assertEquals("Hello!", h.getTag());
    }

    @Test
    public void correctHashTagImagesList() {
        HashTag h = new HashTag();
        List<Image> images = new ArrayList<>();
        h.setImages(images);
        assertEquals(images, h.getImages()); 
    }

    
}
