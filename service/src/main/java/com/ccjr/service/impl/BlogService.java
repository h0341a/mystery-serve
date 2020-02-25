package com.ccjr.service.impl;

import com.ccjr.dao.BlogCategoryDao;
import com.ccjr.dao.BlogDao;
import com.ccjr.model.dataobject.Blog;
import com.ccjr.model.dataobject.BlogCategory;
import com.ccjr.model.dto.BlogDTO;
import com.ccjr.model.vo.BlogVO;
import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.service.AdminBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ling
 */
@Service
public class BlogService implements AdminBlogService {

    private final BlogDao blogDao;
    private final BlogCategoryDao categoryDao;

    public BlogService(BlogDao blogDao, BlogCategoryDao categoryDao) {
        this.blogDao = blogDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public List<BlogVO> getBlogList() {
        return null;
    }

    @Override
    public void addNewBlog(BlogDTO blogDTO) throws BusinessException {
        //将dto转换为dataobject
        Blog blog = this.convertBlogDTO(blogDTO);
        //如果博客分组名获取分组id
        Integer cid = categoryDao.selectIdByName(blogDTO.getCategory());
        //没有该分组则新建分组
        if (cid == null || cid == 0) {
            BlogCategory category = new BlogCategory();
            category.setName(blogDTO.getCategory());
            if (categoryDao.insertSelective(category) == 0) {
                throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客分组出错");
            }
            blog.setCategoryId(category.getId());
        }
        if (blogDao.insertSelective(blog) == 0) {
            throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客出错");
        }
    }

    /**
     * 将blogDto转换为blog
     *
     * @param blogDTO 待转换对象
     * @return 转换后的blog
     */
    private Blog convertBlogDTO(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setContent(blogDTO.getContent());
        return blog;

    }
}
