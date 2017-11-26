package app.service;

import app.entity.Post;
import app.entity.PostDetail;

import java.util.List;

public interface PostDetailService {

    public List<PostDetail> getPostDetails();

    public void savePostDetail(PostDetail postDetail);



}
