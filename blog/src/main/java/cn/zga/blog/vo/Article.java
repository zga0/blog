package cn.zga.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private int id; //文章的唯一ID
    private String author; //作者名
    private String title; //标题
    private String content; //文章的内容
//   {"name":"Runoob", "url":"www.runoob.com"}
//]
    public String toJson(){
        String content0 = this.content;
        if(content.length()<101){
            content0 = content.substring(0)+"...";
        }else{
            content0 = content.substring(0,101)+"...";
        }
        String temp = content0.replaceAll("[\\r]", "");
        content0 = temp.replace("[\\s+#`]","");
        StringBuffer sb = new StringBuffer("{\"");
        sb.append("id\":\""+this.getId()+
                "\",\"author\":\""+this.getAuthor()+
                "\",\"title\":\""+this.getTitle()+
                "\",\"content\":\""+content0+"\"}");
//        System.out.println("!!!!!!!!!!!!!!!!!!blpg:"+this.id+"的content0:"+content0);
        return sb.toString();
    }
}
