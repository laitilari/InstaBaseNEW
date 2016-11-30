
package wad.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {

    @OneToMany
    private List<Comment> comments;
    
//    @Id
    private String username;
    @Column
    private String password;
    @OneToMany
    private List<Image> images;
    
////    @OneToMany
////    private List<Account> followers;
//
//    public List<Account> getFollowers() {
//        return followers;
//    }
//
//    public void setFollowers(List<Account> followers) {
//        this.followers = followers;
//    }
    
    private boolean admin;
    private boolean user;
    
    

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

    public boolean isAdmin() {
        return admin;
    }

    public boolean isUser() {
        return user;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setUser(boolean user) {
        this.user = user;
    }
}
