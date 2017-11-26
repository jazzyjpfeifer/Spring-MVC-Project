package app.dao;


import app.entity.Post;

import java.util.List;

public interface PostDAO {

    public List<Post> getPosts();

    public void savePost(Post post);

    public Post getPostById(int id);

    public void deletePostById(int Id);
}
