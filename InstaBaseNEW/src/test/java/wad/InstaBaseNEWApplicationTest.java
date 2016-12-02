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
import wad.domain.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstaBaseNEWApplicationTest {
    
    @Autowired
    private WebApplicationContext webAppContext;
    
    private MockMvc mockMvc;
    
    public InstaBaseNEWApplicationTest() {
    }
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
    
    @Test
    public void RegisteringWorks() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
        Account testAccount = new Account();
        testAccount.setUsername("testUsername");
        testAccount.setPassword("testPassword");
        mockMvc.perform(post("/register/createuser?username=Joel&password=JoelE"));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
