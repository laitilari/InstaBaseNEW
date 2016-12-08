package wad.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
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
    private Set<Account> likes;  //accounts who like this image

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<HashTag> hashTags;

    private String caption;

    public Image() {
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public List<HashTag> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<HashTag> hashTags) {
        this.hashTags = hashTags;
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

    public int getLikes() {
        return likes.size();
    }

    public Set<Account> getLikesSet() {
        return likes;
    }

    public List<Comment> getCommentList() {
        return comments;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getComments() {
        return comments.size();
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    

}
