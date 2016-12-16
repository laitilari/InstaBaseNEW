package wad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
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
import org.springframework.web.multipart.MultipartFile;

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

    String usernameInt;
    String passwordInt;

    public ImageControllerTest() {
    }

    // Create an account and an image, add the image to account, test that
    // liking and commenting the image works.
    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

        Random rnd = new Random();
        usernameInt = Integer.toString(100000 + rnd.nextInt(900000));
        passwordInt = Integer.toString(100000 + rnd.nextInt(900000));
//
//        testAccount = new Account();
//        testAccount.setUsername("tester" + usernameInt);
//        testAccount.setPassword("tester" + passwordInt);
//        ArrayList<String> testUserAuthorities = new ArrayList();
//        testUserAuthorities.add("USER");
//        testAccount.setAuthorities(testUserAuthorities);
//        
//
        byte[] testContent = new byte[10000];
        new Random().nextBytes(testContent);
        testImage = new Image();
        testImage.setContent(testContent);
        testImage.setCaption("testCaption");
        testImage.setAccount(testAccount);
//        
//        ArrayList<Image> testAccountImages = new ArrayList<>();
//        testAccountImages.add(testImage);
//        testAccount.setImages(testAccountImages);
//        
//        imageRepository.save(testImage);
//        accountRepository.save(testAccount);

    }

    @Test
    public void tyhjaTest() {

    }

    // Kesken
    // Tee niin että postaat kuvankin
//    @Test
    public void likingImageWorks() throws Exception {
        mockMvc.perform(get("/register/")
                .param("username", "tester" + usernameInt)
                .param("password", "tester" + passwordInt));
        mockMvc.perform(get("/")
                .param("username", "tester" + usernameInt)
                .param("password", "tester" + passwordInt));
        MockMultipartFile newImage = new MockMultipartFile(testImage.getCaption(), testImage.getContent());
        mockMvc.perform(post("/home/")
                .param("kuva", newImage.getName()));    //Väärin
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        assertTrue(accountRepository.findByUsername(username).getImages().contains(testImage));

//        Date currentDate = new Date();
        //        PersistentRememberMeToken token = new PersistentRememberMeToken("testuser", "testseries", "atoken", currentDate);
        //        TestingAuthenticationToken auth 
        //                = new TestingAuthenticationToken("tester" + usernameInt,
        //                "tester" + usernameInt);
        String id = testImage.getId().toString();
        mockMvc.perform(get("/image/" + id))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("kuva"));
        assertEquals("a", "a");
    }

}
