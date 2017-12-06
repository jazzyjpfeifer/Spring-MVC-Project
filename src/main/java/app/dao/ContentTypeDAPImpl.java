package app.dao;

import app.entity.ContentType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentTypeDAPImpl implements ContentTypeDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<ContentType> getAllContentTypes() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<ContentType> query = currentSession.createQuery("from ContentType c order by c.Sequence asc", ContentType.class);

        List<ContentType> contentTypes = query.getResultList();

        return contentTypes;
    }

    @Override
    public void saveContentType(ContentType contentType) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(contentType);
    }

    @Override
    public ContentType getContentTypeById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        ContentType contentType = currentSession.get(ContentType.class, id);

        return contentType;
    }

    @Override
    public void deleteContentTypeById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from ContentType where id=:id");

        query.setParameter("id", id);

        query.executeUpdate();

    }


}
