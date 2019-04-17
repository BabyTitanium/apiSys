package com.example.apimanage.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel
public class Register {
    @NotBlank
    @Email
    @ApiModelProperty(value = "邮箱", example = "houserqu@qq.com", required = true)
    private String email;

    @NotBlank
    @ApiModelProperty(value = "密码", example = "382027881", required = true)
    private String password;

    @NotBlank
    @ApiModelProperty(value = "昵称", example = "houser", required = true)
    private String nickname;
}
