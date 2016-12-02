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

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstaBaseNEWApplicationTest {
    
    @Autowired
    private WebApplicationContext webAppContext;
    
    private MockMvc mockMvc;
    private RegisterController registerController;
    
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
                // Needs the final attribute PAGE_REGISTER IN RegisterController
//                .andExpect(forwarderUrl(registerController.PAGE_REGISTER));
        mockMvc.perform(post("/register/createuser")
                .param("username", "tester")
                .param("password", "tester"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("username"));
    }
    
}
