package com.cheer.mybatis.dao;


import com.cheer.mybatis.model.Blog;
import com.cheer.mybatis.util.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface BlogMapper {
    Blog getBlog(Integer id);

    List<Blog> getAll();

    List<Blog> getPage(Page page);

    void insert(Blog blog);

    void delete(Integer id);

    void update(Blog blog);

    int getCount();
}
