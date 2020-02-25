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
     * 添加新博客
     * @param blogDTO 博客信息
     */
    public void addNewBlog(BlogDTO blogDTO) throws BusinessException;

}
