package com.bjc.lcp.app1222.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.jun.plugin.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @description 管理员
 * @author Wujun
 * @date 2023-09-05
 */
@Data
@ApiModel("管理员")
public class AdminDto  extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    @ApiModelProperty("") 
    private Long id;

    /**
    * 用户名
    */
    @ApiModelProperty("用户名") 
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty("密码") 
    private String password;

    /**
    * 最后登录时间
    */
    @ApiModelProperty("最后登录时间") 
    private Date lastLoginDate;

    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间") 
    private Date createDate;

    public AdminDto() {}
}
