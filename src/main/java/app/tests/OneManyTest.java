package app.tests;

import app.entity.Post;
import app.entity.PostDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OneManyTest {

    @Autowired
    SessionFactory sessionFactory;

    public void savePost() {

        Session currentSession = sessionFactory.getCurrentSession();

        Post tempPost = new Post("Title", "Summary", null, null, "Joe");

        currentSession.saveOrUpdate(tempPost);

    }

    public void savePostDetail() {

        Session currentSession = sessionFactory.getCurrentSession();

        //get post by ID
        int theId = 1;
        Post tempPost = currentSession.get(Post.class, theId);

        //Setup new post details
        PostDetail postDetail1 = new PostDetail("Content 1");
        PostDetail postDetail2 = new PostDetail("Content 2");

        //add PostDetails to Post
        tempPost.add(postDetail1);
        tempPost.add(postDetail2);

        //save post details
        currentSession.saveOrUpdate(postDetail1);
        currentSession.saveOrUpdate(postDetail2);




    }



}
