package wad.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Image extends AbstractPersistable<Long> {

    @ManyToOne
    private Account account;

    @Column
    private String link;

    @OneToMany
    private List<Account> likes;

    @OneToMany
    private List<Comment> comments;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addLike(Account account) {
        this.likes.add(account);
    }

    public void removeLike(Account account) {
        List<Account> toRemove = new ArrayList<>();
        for (Account a : likes) {
            if (a.getId().equals(account.getId())) {
                toRemove.add(a);
            }
        }
        likes.removeAll(toRemove);
    }

    public List<Account> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Account> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
