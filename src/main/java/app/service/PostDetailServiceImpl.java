package app.service;

import app.dao.PostDAO;
import app.dao.PostDetailDAO;
import app.entity.Post;
import app.entity.PostDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostDetailServiceImpl implements PostDetailService {

    @Autowired
    private PostDetailDAO postDetailDAO;

    @Override
    @Transactional
    public List<PostDetail> getPostDetails(int post_id) {
        return postDetailDAO.getPostDetails(post_id);
    }

    @Override
    @Transactional
    public void savePostDetail(PostDetail postDetail) {
        postDetailDAO.savePostDetail(postDetail);
    }

}
