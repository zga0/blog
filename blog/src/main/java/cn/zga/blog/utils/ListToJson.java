package cn.zga.blog.utils;

import cn.zga.blog.vo.Article;

import java.util.List;

public class ListToJson {
//    "sites":[
//    {"name":"Runoob", "url":"www.runoob.com"},
//    {"name":"Google", "url":"www.google.com"},
//    {"name":"Taobao", "url":"www.taobao.com"}
//]
    public static String listToJson(List<Article> list){
        StringBuilder sb = new StringBuilder("[");
        for (int a = 0;a<list.size()-1;a++) {
            sb.append(list.get(a).toJson()+",");
        }
        sb.append(list.get(list.size()-1).toJson()+"]");
        return sb.toString();
    }
}
