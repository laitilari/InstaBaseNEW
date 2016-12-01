package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Image extends AbstractPersistable<Long> {

    @ManyToOne
    private Account account;

    @OneToMany
    private List<Account> likes;  //accounts who like this image

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @OneToMany
    private List<Comment> comments;

    public Image() {
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
       
        
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
