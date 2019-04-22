package com.example.apimanage.domain.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liulingling
 */
@Data
@ApiModel
public class ListUser implements Serializable {
    private static final long serialVersionUID = -3946734305303957850L;
    private int id;
    private String nickname;
}
