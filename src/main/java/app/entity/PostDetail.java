package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "contentType")
    private String contentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public PostDetail() {

    }

    public PostDetail(String content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



    @Override
    public String toString() {
        return "PostDetail{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", post=" + post +
                '}';
    }
}
