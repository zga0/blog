package cn.zga.blog.controller;

import cn.zga.blog.dao.ArticleMapper;
import cn.zga.blog.utils.JsonUtil;
import cn.zga.blog.utils.ListToJson;
import cn.zga.blog.vo.Article;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Resource
    ArticleMapper articleMapper;

    @GetMapping(value="/")
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping(value="/index")
    public String getIndex0(Model model) {
        return "index";
    }

    @PostMapping(value = "/verify")
    public String verify(HttpServletRequest request,Model model){
        String username = request.getParameter("login");
        String pwd = request.getParameter("password");
        System.out.println("!!!!!!!!!用户名String地址：  "+username.hashCode());
        System.out.println("!!!!!!!!!密码String：  "+pwd.hashCode());
        System.out.println("qq873143381String地址"+"qq873143381".hashCode());
        System.out.println("q873143381String地址".hashCode());
        if(username.equals("qq873143381") && pwd.equals("q873143381")){
            return "manage";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    @GetMapping(value="/login")
    public String getLogin(Model model) {
        return "login";
    }

    @ResponseBody
    @GetMapping(value="/getAllBlog")
    public String getAllBlog(Model model) {
        List<Article> articles = articleMapper.queryArticles();
//        System.out.println("*************"+articles.toString());
//        String json = articles.get(0).toJson();
//        for (Article article:articles) {
//            model.addAttribute("article"+article.getId(),articleMapper.queryArticles().toString());
//        }
        model.addAttribute("articles", ListToJson.listToJson(articles));
//        return "index";
        System.out.println("*******************"+ListToJson.listToJson(articles));
        return ListToJson.listToJson(articles);
    }

    @GetMapping(value="/lookArticle/{id}")
    public String lookArticle(@PathVariable Long id, Model model) {
        System.out.println("&&&&&&&&传过来的id是:   "+id);
        model.addAttribute("id",id);
        Article article = articleMapper.getArticleById(Math.toIntExact(id));
        if(article==null){
            model.addAttribute("error","返回数据异常，请重试");
            return "error";
        }
        String content = article.getContent();
        model.addAttribute("content",content);
        System.out.println("!!!!!!!!!!!!!查询到的文章content是： "+content);
        return "look";
    }


}
