package ir.arcademy.blog.modules.posts.controller;

import ir.arcademy.blog.modules.posts.model.Category;
import ir.arcademy.blog.modules.posts.model.Posts;
import ir.arcademy.blog.modules.posts.service.CategoryService;
import ir.arcademy.blog.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String Categories(){
        return "categories/categories";
    }
    @RequestMapping(value ="/rest", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @RequestMapping(value ="/rest", method = RequestMethod.POST)
    public @ResponseBody Category registerCategory(@RequestBody Category category) {
        return categoryService.registerCategory(category);
    }


}
