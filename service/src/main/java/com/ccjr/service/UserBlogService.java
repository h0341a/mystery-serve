package com.ccjr.service;

import com.ccjr.model.vo.BlogVO;
import com.ccjr.response.BusinessException;

import java.util.List;

public interface UserBlogService {
    /**
     * 获取分组名列表
     * @return 分组列表
     */
    public List<String> getCategoryList();

    /**
     * 根据分组名获取博客列表
     * @return 博客列表
     */
    public List<BlogVO> getBlogListByCategoryName(String categoryName) throws BusinessException;

}
