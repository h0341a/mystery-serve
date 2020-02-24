package com.ccjr.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author ling
 */
@Data
public class BlogDTO {

    @NotBlank(message = "标题不能为空")
    private String title;
    @Length(min = 6, max = 24, message = "标题长度为6-24位")
    private String category;
    private String description;
    @NotBlank(message = "内容不能为空")
    private String content;

}
