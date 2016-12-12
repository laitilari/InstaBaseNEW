package wad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import wad.controller.RegisterController;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.AccountRepository;
import wad.repository.ImageRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ImageRepository imageRepository;

    private MockMvc mockMvc;
    private RegisterController imageController;
    
    private Account testAccount;
    private Image testImage;

    public ImageControllerTest() {
    }

    // Create an account and an image, add the image to account, test that
    // liking and commenting the image works.
    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

        testAccount = new Account();
        testAccount.setUsername("tester");
        testAccount.setPassword("tester");
        ArrayList<String> testUserAuthorities = new ArrayList();
        testUserAuthorities.add("USER");
        testAccount.setAuthorities(testUserAuthorities);
        accountRepository.save(testAccount);

        byte[] testContent = new byte[10000];
        new Random().nextBytes(testContent);
        testImage = new Image();
        testImage.setContent(testContent);
        testImage.setCaption("testCaption");
        testImage.setAccount(testAccount);
        imageRepository.save(testImage);
    }

    // Kesken
    @Test
    public void likingImageWorks() throws Exception {
        String id = testImage.getId().toString();
        mockMvc.perform(get("/image/" + id + "/content"));
    }

}
