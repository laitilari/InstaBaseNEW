package wad.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Account;

@Profile("production")
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByUsername(String username);
}
