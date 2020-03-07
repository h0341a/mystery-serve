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
import com.ccjr.service.UserBlogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ling
 */
@Service
public class BlogService implements AdminBlogService, UserBlogService {

    private final BlogDao blogDao;
    private final BlogCategoryDao categoryDao;

    public BlogService(BlogDao blogDao, BlogCategoryDao categoryDao) {
        this.blogDao = blogDao;
        this.categoryDao = categoryDao;
    }


    @Override
    public List<String> getCategoryList() {
        return null;
    }

    @Override
    public List<BlogVO> getBlogList() throws BusinessException {
        List<Blog> blogList = blogDao.selectAll();
        return this.convertBlogList(blogList);
    }

    @Override
    public List<BlogVO> getBlogListByCategoryName(String categoryName) throws BusinessException {
        Integer cid = categoryDao.selectIdByName(categoryName);
        if (cid == null){
            throw new BusinessException(ErrorCodeEnum.DATA_ABORT, "没有该分组");
        }
        List<Blog> blogList = blogDao.selectByCategoryId(cid);
        return this.convertBlogList(blogList);
    }

    @Override
    public void addNewBlog(BlogDTO blogDTO) throws BusinessException {
        Blog blog = this.convertBlogDTO(blogDTO, this.getCategoryIdByName(blogDTO.getCategory()));
        System.out.println(blog.getCategoryId());
        if (blogDao.insertSelective(blog) == 0) {
            throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客出错");
        }
    }

    @Override
    public void deleteBlog(int bid) throws BusinessException {
        if (blogDao.deleteByPrimaryKey(bid) != 1){
            throw new BusinessException(ErrorCodeEnum.DATA_ABORT, "没有你要删除的博客");
        }
    }

    @Override
    public void updateBlog(int bid, BlogDTO blogDTO) throws BusinessException {
        Blog blog = this.convertBlogDTO(blogDTO, this.getCategoryIdByName(blogDTO.getCategory()));
        blog.setBid(bid);
        if(blogDao.updateByPrimaryKeySelective(blog) != 1){
            throw new BusinessException(ErrorCodeEnum.DATA_ABORT, "没有找到该博客");
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
        blog.setCategoryId((byte) categoryId);
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

    /**
     * 将blogList转换为blogVoList
     * @param blogList 待传入的blogList
     * @return blogVoList
     * @throws BusinessException 分类未找到
     */
    private List<BlogVO> convertBlogList(List<Blog> blogList) throws BusinessException {
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

    /**
     * 根据分类名获取分类id
     * @param categoryName 分类名
     * @return 分类id
     */
    private Integer getCategoryIdByName(String categoryName) throws BusinessException {
        if (StringUtils.isEmpty(categoryName)){
            categoryName = "未分类";
        }
        //如果博客分组名获取分组id
        Integer categoryId = categoryDao.selectIdByName(categoryName);
        //没有该分组则新建分组
        if (categoryId == null || categoryId == 0) {
            BlogCategory category = new BlogCategory();
            category.setName(categoryName);
            if (categoryDao.insertSelective(category) == 0) {
                throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "插入新博客分组出错");
            }
            categoryId = Integer.valueOf(category.getId());
        }
        return categoryId;
    }
}
