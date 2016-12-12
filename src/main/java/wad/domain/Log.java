
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Log extends AbstractPersistable<Long> {

    private String log;
    @ManyToOne
    private Account account;

    public Log(String log, Account account) {
        this.log = log;
        this.account = account;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

  
    
    

}
