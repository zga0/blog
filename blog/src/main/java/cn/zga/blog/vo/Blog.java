package cn.zga.blog.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Blog implements Serializable {
    /**
     * Blog的id主键
     */
    private Long bid;
    //Blog的标题
    private String title;
//    Blog的内容
    private String contentUrl;
//    Blog的标签
    private String tags;
//    浏览次数
    private Integer Views;
//    是否发布
    private boolean publshed;
//    创建时间
    private Date createDate;
//    最后一次更新时间
    private Date updateDate;


}
