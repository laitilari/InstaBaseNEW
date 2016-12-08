
package wad;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("production")
@SpringBootApplication
public class InstaBaseNEWApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(InstaBaseNEWApplication.class, args);
    }
    
}
