package app.controller;

import app.entity.Post;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public String getPosts(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "/posts/posts.html";
    }

    @GetMapping(value = "/add")
    public String showAddPostForm(Model model) {
        Post newPost = new Post();

        model.addAttribute("post", newPost);

        return "/posts/post_add.html";

    }

    @PostMapping(value = "/save")
    public String savePost(@ModelAttribute("post") Post post) {

        System.out.println("Saving new record...");

        // save the customer using our service
        postService.savePost(post);

        System.out.println("Post was saved to the database successfully!");

        return "redirect:/posts.html";
    }

    @GetMapping(value = "/edit")
    public String editRoleById(@RequestParam("postId") int id, Model model) {

        model.addAttribute("post", postService.getPostById(id));

        return "/posts/post_add.html";
    }

    @GetMapping(value = "/show")
    public String showPostById(@RequestParam("postId") int id, Model model) {

        Post post = postService.getPostById(id);

        model.addAttribute("post", post);

        return "/posts/post_show.html";

    }


}
