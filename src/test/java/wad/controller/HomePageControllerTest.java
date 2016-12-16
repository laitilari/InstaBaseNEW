package wad.controller;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import wad.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomePageControllerTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    private String usernameInt;
    private String passwordInt;

    public HomePageControllerTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        Random rnd = new Random();

        usernameInt = Integer.toString(100000 + rnd.nextInt(900000));
        passwordInt = Integer.toString(100000 + rnd.nextInt(900000));

    }

    @Test
    public void statusOk() throws Exception {
        // Register
        mockMvc.perform(get("/register/")
                .param("username", "tester" + usernameInt)
                .param("password", "tester" + passwordInt));
        // Login
        mockMvc.perform(get("/")
                .param("username", "tester" + usernameInt)
                .param("password", "tester" + passwordInt));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        //Go to homepage
        mockMvc.perform(get("/home/")
                .param("account", username))
                .andExpect(status().isFound());

    }
}
