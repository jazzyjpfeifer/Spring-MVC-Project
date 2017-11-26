package app.controller;

import app.entity.PostDetail;
import app.service.PostDetailService;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/post_details")
public class PostDetailController {

    @Autowired
    private PostDetailService postDetailService;

    @GetMapping(value = "/add")
    public String showAddPostDetailsForm (Model model) {

        PostDetail newPostDetail = new PostDetail();

        model.addAttribute("postdetails", newPostDetail);

        return "post_details/post_details_add.html";
    }

    @PostMapping(value = "/save")
    public String savePostDetail(@ModelAttribute("postdetails") PostDetail postDetail) {

        System.out.println("Saving new record...");

        postDetailService.savePostDetail(postDetail);

        System.out.println("Post Details were saved to the database successfully!");

        return "redirect:/posts.html";

    }



}
