package ir.arcademy.blog.modules.posts.controller;

import ir.arcademy.blog.modules.posts.model.Posts;
import ir.arcademy.blog.modules.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerPosts (@ModelAttribute Posts post ) throws IOException{

        postsService.registerPost(post);
        return "posts/registerPosts";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public  String showRegisterPosts() {
        return "posts/posts";
    }


    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public @ResponseBody
    List<Posts> getPosts() {
        return postsService.findAllPosts();
    }

    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public @ResponseBody
    Posts registerPost(@RequestBody Posts posts) throws IOException{
        return postsService.registerPost(posts);
    }


}
