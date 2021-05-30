package cn.zga.blog.controller;

import cn.zga.blog.dao.ArticleMapper;
import cn.zga.blog.vo.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class EditController {
    @Resource
    ArticleMapper articleMapper;

    @GetMapping("/article/toEditor")
    public String getEditor(Model model){
        Article article = new Article();
        model.addAttribute("article",article);
        return "editor";
    }

    @PostMapping("/article/addArticle")
    public String editor(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("content") String content){
        System.out.println(title+author+content);
        articleMapper.addArticle(new Article(0,author,title,content));
        return "editor";
    }


}
