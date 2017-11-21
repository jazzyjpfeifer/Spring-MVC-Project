package app.controller;

import app.entity.Post;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
