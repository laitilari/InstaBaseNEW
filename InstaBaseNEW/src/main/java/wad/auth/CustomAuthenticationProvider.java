package wad.auth;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import wad.domain.Account;
import wad.repository.AccountRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountRepository accrepo;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        for (Account acc : accrepo.findAll()) {
            if (acc.getUsername().equals(a.getName()) && acc.getPassword().equals(a.getCredentials())) {
                grantedAuths.add(new SimpleGrantedAuthority("USER"));
            }

        }
        return new UsernamePasswordAuthenticationToken("le username from le real service", "le password", grantedAuths);
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

}
