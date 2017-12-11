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

@Controller
@RequestMapping(value = "/post_details")
public class PostDetailController {

    @Autowired
    PostService postService;

    @Autowired
    ContentTypeService contentTypeService;

    @Autowired
    PostDetailService postDetailService;

    @GetMapping(value = "/show")
    public String showPostById(@RequestParam("postId") int post_id, Model model) {

        Post post = postService.getPostById(post_id);

        //getting postdetails from post
        post.getPostdetails();

        model.addAttribute("post", post);

        return "/post_details/post_details_show.html";

    }

    @GetMapping(value = "/add")
    public String showPostDetailsForm(@RequestParam("postId") int post_id, Model model) {

        Post post = postService.getPostById(post_id);
        PostDetail newPostDetail = new PostDetail();

        model.addAttribute("post", post);
        model.addAttribute("postdetails", newPostDetail);
        model.addAttribute("allTypes", contentTypeService.getAllContentTypes());

        return "/post_details/post_details_add.html";

    }

    @PostMapping(value = "/save")
    public String savePostDetails(RedirectAttributes redirectAttributes,
                                  @ModelAttribute("postdetail") PostDetail postDetail,
                                  @RequestParam("postId") int post_id,
                                  @RequestParam("content_id") int content_id) {


        //Getting Post by ID
        Post post = postService.getPostById(post_id);

        //Getting Content by ID
        ContentType contentType = contentTypeService.getContentTypeById(content_id);

        postDetail.setContentType(contentType);

        //Assigning post to post_detail
        post.add(postDetail);

        //Saving post_details
        postDetailService.savePostDetail(postDetail);

        redirectAttributes.addAttribute("postId", post_id);

        return "redirect:/post_details/add";
    }

}
