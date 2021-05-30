package cn.zga.blog.dao;

import cn.zga.blog.vo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DataDao {
    public int create(Blog blog);
    public Blog getBlogById(@Param("id") Long id);
}
