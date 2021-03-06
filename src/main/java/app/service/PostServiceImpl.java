package app.service;

import app.dao.PostDAO;
import app.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl  implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    @Transactional
    public List<Post> getPosts() {
        return postDAO.getPosts();
    }

    @Override
    @Transactional
    public void savePost(Post post) {
        postDAO.savePost(post);
    }

    @Override
    @Transactional
    public Post getPostById(int id) {
        return postDAO.getPostById(id);
    }

    @Override
    @Transactional
    public Post deletePostById(int id) {
        postDAO.deletePostById(id);
        return null;
    }
}
