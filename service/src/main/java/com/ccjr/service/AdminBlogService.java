package com.ccjr.service;

import com.ccjr.model.dataobject.Blog;
import com.ccjr.model.dto.BlogDTO;
import com.ccjr.model.vo.BlogVO;
import com.ccjr.response.BusinessException;

import java.util.List;

/**
 * @author ling
 */
public interface AdminBlogService {

    /**
     * 获取博客列表
     * @return 博客列表
     */
    public List<BlogVO> getBlogList() throws BusinessException;

    /**
     * 根据分类名获取博客列表
     * @return 博客列表
     */
    public List<BlogVO> getBlogList(String categoryName) throws BusinessException;

    /**
     * 添加新博客
     * @param blogDTO 博客信息
     */
    public void addNewBlog(BlogDTO blogDTO) throws BusinessException;

    /**
     * 根据博客id删除博客
     * @param bid 博客id
     */
    public void deleteBlog(int bid) throws BusinessException;

    /**
     * 修改博客
     * @param bid 博客id
     * @param blogDTO 博客信息
     */
    public void updateBlog(int bid, BlogDTO blogDTO) throws BusinessException;
}
