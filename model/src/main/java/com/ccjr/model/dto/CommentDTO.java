package com.ccjr.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CommentDTO {

    @NotBlank(message = "昵称不能为空")
    private String nickname;
    @Email(message = "邮箱格式不正确")
    private String email;
    @NotBlank(message = "内容不能为空")
    private String content;

}
