package app.controller;

import app.entity.ContentType;
import app.service.ContentTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/content_type")
public class ContentTypeController {

    @Autowired
    ContentTypeService contentTypeService;

    @GetMapping()
    public String showContentTypes(Model model) {

        List<ContentType> contentTypes = contentTypeService.getAllContentTypes();

        model.addAttribute("content_types", contentTypes);

        return "content_type/content_types.html";
    }

    @GetMapping("/add")
    public String showAddContentTypeForm(Model model) {

        ContentType contentType = new ContentType();

        model.addAttribute("type", contentType);

        return "content_type/content_type_add.html";
    }

    @PostMapping("/save")
    public String saveNewContentType(@ModelAttribute("type") ContentType contentType) {

        contentTypeService.saveContentType(contentType);

        System.out.println("Content Type was saved to the database successfully!");

        return "redirect:/content_type";
    }

    @GetMapping("delete")
    public String deleteContentTYpeById(@RequestParam("id") int id) {

        System.out.println("Deleting record...");

        contentTypeService.deleteContentTypeById(id);

        System.out.println("Record was removed succesfully from the database");

        return "redirect:/content_type";
    }

}
