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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BlogVO> getBlogList() throws BusinessException {
        List<Blog> blogList = blogDao.selectAll();
        List<BlogVO> blogVOList = new ArrayList<>();
        for (Blog blog:blogList){
            BlogCategory category = categoryDao.selectByPrimaryKey(blog.getCategoryId());
            //todo 可以通过数据库外键来解决这个问题的出现
            if (category == null){
                throw new BusinessException(ErrorCodeEnum.DATA_ABORT, "文章分类未找到");
            }
            blogVOList.add(this.convertBlog(blog, category.getName()));
        }
        return blogVOList;
    }

    @Override
    public void addNewBlog(BlogDTO blogDTO) throws BusinessException {
        //如果博客分组名获取分组id
        Integer cid = categoryDao.selectIdByName(blogDTO.getCategory());
        //没有该分组则新建分组
        if (cid == null || cid == 0) {
            BlogCategory category = new BlogCategory();
            category.setName(blogDTO.getCategory());
            if (categoryDao.insertSelective(category) == 0) {
                throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客分组出错");
            }
            cid = Integer.valueOf(category.getId());
        }
        Blog blog = this.convertBlogDTO(blogDTO, cid);
        if (blogDao.insertSelective(blog) == 0) {
            throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客出错");
        }
    }

    /**
     * 将blogDto转换为blog
     *
     * @param blogDTO 待转换对象
     * @param categoryId 分类id
     * @return 转换后的blog
     */
    private Blog convertBlogDTO(BlogDTO blogDTO, int categoryId) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setContent(blogDTO.getContent());
        return blog;
    }
    /**
     * 将blogDataObject转换为vo
     * @param blog 待转换的dataobject
     * @return 转换后的结果
     */
    private BlogVO convertBlog(Blog blog, String categoryName){
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blog, blogVO);
        blogVO.setCategory(categoryName);
        return blogVO;
    }
}
