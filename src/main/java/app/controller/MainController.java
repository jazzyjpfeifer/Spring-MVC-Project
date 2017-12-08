package app.controller;

import app.entity.PostDetail;
import app.service.PostDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostDetailService postDetailService;

    @RequestMapping("/")
    public String index() {

        return "index.html";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin.html";
    }
}
