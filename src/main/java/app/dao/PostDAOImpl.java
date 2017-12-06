package app.dao;

import app.entity.ContentType;
import app.entity.Post;
import app.entity.PostDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Post> getPosts() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Post> query = currentSession.createQuery("from Post order by datePosted", Post.class);

        List<Post> posts = query.getResultList();

        return posts;
    }

    @Override
    public void savePost(Post post) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(post);
    }

    @Override
    public Post getPostById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Post post = currentSession.get(Post.class, id);

        return post;
    }

    @Override
    public void deletePostById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Post where id=:postId");

        query.setParameter("postId", id);

        query.executeUpdate();
    }


}
