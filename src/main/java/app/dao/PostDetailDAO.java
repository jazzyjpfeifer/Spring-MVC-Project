package app.dao;


import app.entity.Post;
import app.entity.PostDetail;

import java.util.List;

public interface PostDetailDAO {

    public List<PostDetail> getPostDetails();

    public void savePostDetail(PostDetail postDetail);

}
