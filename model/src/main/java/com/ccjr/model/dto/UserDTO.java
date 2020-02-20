package com.ccjr.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author ling
 */
@Data
public class UserDTO {
    @NotBlank(message = "用户名称不能为空")
    @Length(min = 2, max = 8, message = "用户名长度为2-8位")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 8, max = 16, message = "密码长度为8-16位")
    @Pattern(regexp = "[a-zA-Z]*", message = "密码不合法")
    private String password;
}
