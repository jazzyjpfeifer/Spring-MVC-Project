package app.dao;


import app.entity.PostDetail;

import java.util.List;

public interface PostDetailDAO {

    public List<PostDetail> getPostDetails(int post_id);

    public void savePostDetail(PostDetail postDetail);

}
