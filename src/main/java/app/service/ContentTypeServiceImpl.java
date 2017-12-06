package app.service;

import app.dao.ContentTypeDAO;
import app.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContentTypeServiceImpl implements ContentTypeService {

    @Autowired
    ContentTypeDAO contentTypeDAO;

    @Override
    @Transactional
    public List<ContentType> getAllContentTypes() {

        return contentTypeDAO.getAllContentTypes();

    }

    @Override
    @Transactional
    public void saveContentType(ContentType contentType) {
        contentTypeDAO.saveContentType(contentType);

    }

    @Override
    @Transactional
    public ContentType getContentTypeById(int id) {
        return contentTypeDAO.getContentTypeById(id);
    }

    @Override
    @Transactional
    public void deleteContentTypeById (int id) {
        contentTypeDAO.deleteContentTypeById(id);

    }

}
