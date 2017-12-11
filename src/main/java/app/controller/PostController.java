package app.controller;


import app.entity.ContentType;
import app.entity.Post;
import app.entity.PostDetail;
import app.service.ContentTypeService;
import app.service.PostDetailService;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDetailService postDetailService;

    @Autowired
    private ContentTypeService contentTypeService;

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

        return "redirect:/posts";
    }

    @GetMapping(value = "/edit")
    public String editRoleById(@RequestParam("postId") int id, Model model) {

        model.addAttribute("post", postService.getPostById(id));

        return "/posts/post_add.html";
    }


    @GetMapping(value = "/delete")
    public String deletePostById(@RequestParam("postId") int id) {

        System.out.println("Deleting record...");

        postService.deletePostById(id);

        System.out.println("Record was removed successfully form the database");

        return "redirect:/posts";
    }




}
