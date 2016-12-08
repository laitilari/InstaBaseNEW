package wad;



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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import wad.controller.RegisterController;
import wad.domain.Account;
import wad.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstaBaseNEWApplicationTest {
    
    @Autowired
    private WebApplicationContext webAppContext;
    
    @Autowired
    private AccountRepository accountRepository;
    
    private MockMvc mockMvc;
    private RegisterController registerController;
    
    public InstaBaseNEWApplicationTest() {
    }
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
    
    @Test
    public void registeringWorks() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/register/createuser")
                .param("username", "tester")
                .param("password", "tester"))
                .andExpect(status().is3xxRedirection());
        assertFalse(accountRepository.findByUsername("tester") == null);
    }
    
//    @Test
    public void registeringWithBadUsernameDoesNotWork() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/register/createuser")
                .param("username", "lol")
                .param("password", "password"))
                .andExpect(status().isOk());    // TÄYTYY PALAUTTAA REGISTERPAGE
        // MUOKKAA!!!
    }
    
    // Registering if user not validated
}
