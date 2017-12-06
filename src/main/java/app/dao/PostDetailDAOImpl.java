package app.dao;

import app.entity.ContentType;
import app.entity.PostDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDetailDAOImpl implements PostDetailDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PostDetail> getPostDetails() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<PostDetail> query = currentSession.createQuery("from PostDetail", PostDetail.class);

        List<PostDetail> postdetails = query.getResultList();

        return postdetails;
    }

    @Override
    public void savePostDetail(PostDetail postDetail) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(postDetail);


    }




}
