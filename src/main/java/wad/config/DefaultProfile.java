package wad.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DefaultProfile {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {

        String dbUrl = "jdbc:postgresql://ec2-54-75-228-125.eu-west-1.compute.amazonaws.com:5432/d8k4v9q5mtkgev?sslmode=require&user=enxjzxxbfdbnst&password=-eiB2ItOtJSoSjEhpuw6boE4Np";
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername("enxjzxxbfdbnst");
        basicDataSource.setPassword("-eiB2ItOtJSoSjEhpuw6boE4Np");

        return basicDataSource;
    }
}