package app.service;

import app.entity.Post;

import java.util.List;

public interface PostService {

    public List<Post> getPosts();

    public void savePost(Post post);

    public Post getPostById(int id);

    public void deletePostById(int id);

}
