package app.controller;

import app.entity.ContentType;
import app.entity.PostDetail;
import app.service.ContentTypeService;
import app.service.PostDetailService;
import app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/post_details")
public class PostDetailController {

    @Autowired
    private PostDetailService postDetailService;

    @Autowired
    private ContentTypeService contentTypeService;

    @GetMapping()
    public String showAllPostDetails (Model model) {

        List<PostDetail> postDetail = postDetailService.getPostDetails();

        model.addAttribute("postdetails", postDetail);

        return "post_details/post_details.html";

    }

    @GetMapping(value = "/add")
    public String showAddPostDetailsForm (Model model) {

        PostDetail newPostDetail = new PostDetail();

        model.addAttribute("postdetails", newPostDetail);
        model.addAttribute("allTypes", contentTypeService.getAllContentTypes());

        return "redirect:/post_details";
    }

    @PostMapping(value = "/save")
    public String savePostDetail(@ModelAttribute("postdetails") PostDetail postDetail, @RequestParam("content_id") int content_id) {

        System.out.println("Saving new record...");

        ContentType contentType = contentTypeService.getContentTypeById(content_id);

        postDetail.setContentType(contentType);

        postDetailService.savePostDetail(postDetail);

        System.out.println("Post Details were saved to the database successfully!");

        return "redirect:/post_details/add";

    }



}
