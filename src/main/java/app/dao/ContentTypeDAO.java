package app.dao;

import app.entity.ContentType;

import java.util.List;

public interface ContentTypeDAO {

    public List<ContentType> getAllContentTypes();

    public void saveContentType(ContentType contentType);

    public ContentType getContentTypeById(int id);

    public void deleteContentTypeById (int id);

}
