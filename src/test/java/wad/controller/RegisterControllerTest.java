package wad.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import wad.controller.RegisterController;
import wad.domain.Account;
import wad.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private AccountRepository accountRepository;

    private MockMvc mockMvc;
    private RegisterController registerController;

    public RegisterControllerTest() {
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Test
    public void registeringWorks() throws Exception {
        
        Random rnd = new Random();
        String usernameInt = Integer.toString(100000 + rnd.nextInt(900000));
        String passwordInt = Integer.toString(100000 + rnd.nextInt(900000));
        
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
        MvcResult res = mockMvc.perform(post("/register/createuser")
                .param("username", "tester" + usernameInt)
                .param("password", "tester" + passwordInt))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        String content = res.getResponse().getContentAsString();
        
        assertTrue(accountRepository.findByUsername("tester" + usernameInt) != null);
    }
    
    // Toimimaton testi
    
//    @Test
//    public void registeringWithBadUsernameDoesNotWork() throws Exception {
//        mockMvc.perform(get("/register"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("text/html;charset=UTF-8"));
//        MvcResult res = mockMvc.perform(post("/register/createuser")
//                .param("username", "nouuuu")
//                .param("password", "password"))
//                .andReturn();
//        String content = res.getResponse().getContentAsString();
//        assertTrue(content.contains("Username"));
//        assertTrue(content.contains("Password"));
//    }

    
    @Test
    public void registeringWithTooShortUsernameDoesNotWork() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
        mockMvc.perform(post("/register/createuser")
                .param("username", "k")
                .param("password", "tester"))
                .andReturn();
        assertTrue(accountRepository.findByUsername("k") == null);
    }
    
    @Test
    public void registeringWithTooShortUsernameDoesNotWork2() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
        mockMvc.perform(post("/register/createuser")
                .param("username", "kk")
                .param("password", "tester"))
                .andReturn();
        assertTrue(accountRepository.findByUsername("kk") == null);
    }
    
    @Test
    public void registeringWithTooShortPasswordDoesNotWork() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
        mockMvc.perform(post("/register/createuser")
                .param("username", "tester2")
                .param("password", "k"))
                .andReturn();
        assertTrue(accountRepository.findByUsername("tester2") == null);
    }
    
    @Test
    public void registeringWithTooShortPasswordDoesNotWork2() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
        mockMvc.perform(post("/register/createuser")
                .param("username", "tester3")
                .param("password", "kkkk"))
                .andReturn();
        assertTrue(accountRepository.findByUsername("tester3") == null);
    }
}
