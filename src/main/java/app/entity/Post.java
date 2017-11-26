package app.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @CreationTimestamp
    @Column(name = "datePosted", updatable = false, insertable = true)
    private Timestamp datePosted;

    @UpdateTimestamp
    @Column(name = "date_last_modified", updatable = true, insertable = true)
    private Timestamp dateLastModified;

    @Column(name = "author")
    private Timestamp author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostDetail> postdetails;

    public Post() {

    }

    public Post(String title, String summary, Timestamp datePosted, Timestamp dateLastModified, Timestamp author) {
        this.title = title;
        this.summary = summary;
        this.datePosted = datePosted;
        this.dateLastModified = dateLastModified;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Timestamp datePosted) {
        this.datePosted = datePosted;
    }

    public Timestamp getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Timestamp dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public Timestamp getAuthor() {
        return author;
    }

    public void setAuthor(Timestamp author) {
        this.author = author;
    }

    public List getPostdetails() {
        return postdetails;
    }

    public void setPostdetails(List postdetails) {
        this.postdetails = postdetails;
    }

    // add a convenience method

    public void addPostDetail(PostDetail postDetail) {

        if (postdetails == null) {
            postdetails = new ArrayList<>();
        }

        postdetails.add(postDetail);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", datePosted=" + datePosted +
                ", dateLastModified=" + dateLastModified +
                ", author=" + author +
                ", postdetails=" + postdetails +
                '}';
    }
}
