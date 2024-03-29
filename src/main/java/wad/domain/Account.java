package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    @Basic(fetch = FetchType.LAZY)
    private List<Image> images;

    @NotBlank
    @Column(unique=true)
    @Length(min = 3, max = 15)
    private String username;

    @NotBlank
    @Length(min = 5)
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;
    
    private boolean finnish;

    public Account() {
        this.followers = new ArrayList<>();
        this.images = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.finnish = false;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @OneToMany
    private List<Account> followers;
//

    public List<Account> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Account> followers) {
        this.followers = followers;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Comment findCommentByContent(String content) {
        for (Comment c : comments) {
            if (c.getContent().trim().toLowerCase().contains(content.trim().toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFinnish() {
        return finnish;
    }

    public void setFinnish(boolean finnish) {
        this.finnish = finnish;
    }
    

}
