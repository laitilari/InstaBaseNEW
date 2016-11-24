
package wad.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Comment extends AbstractPersistable<Long> {
    
    @ManyToOne
    private Account account;
    @Column
    private String identificator;
    @Column
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    @Column
    private String content;

    public Account getAccount() {
        return account;
    }

    public String getContent() {
        return content;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdentificator() {
        return identificator;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    
    
    
}
