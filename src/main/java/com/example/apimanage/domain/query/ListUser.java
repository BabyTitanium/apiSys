package com.example.apimanage.domain.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author liulingling
 */
@Data
@ApiModel
public class ListUser {
    private int id;
    private String nickname;
}
