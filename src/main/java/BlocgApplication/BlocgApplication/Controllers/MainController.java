package BlocgApplication.BlocgApplication.Controllers;

import BlocgApplication.BlocgApplication.models.entities.Post;
import BlocgApplication.BlocgApplication.models.entities.PostCommet;
import BlocgApplication.BlocgApplication.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")

       public String postPage(Model model){
        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable= postRepository.findAll();
        for (Post post : postIterable){
            postList.add(post);
        }
 model.addAttribute("posts",postList);
        return "posts";
    }
    @PostMapping("/addPost")
    public String addPost(@RequestParam(value = "title") String titleParam,
                          @RequestParam(value = "content") String content){

        Post post = new Post(titleParam, content);
        PostCommet postCommet = new PostCommet();
        postCommet.setComment(titleParam);

        post.addComment(postCommet);
        postRepository.save(post);

        return "index";
    }
    @GetMapping("/addPost")
    public String addPost(){
        return "addPost";
    }

}
