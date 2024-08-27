package com.bjc.lcp.app1222.vo;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class AdminVo  extends BaseEntity  implements Serializable {

    public interface Retrieve{}
    public interface Delete {}
    public interface Update {}
    public interface Create {}

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
    @NotNull(message = "用户名不能为空", groups = {Create.class,Update.class,Delete.class})
    @Size( max = 255,message = "用户名长度限制255位")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty("密码") 
    @NotNull(message = "密码不能为空", groups = {Create.class,Update.class,Delete.class})
    @Size( max = 255,message = "密码长度限制255位")
    private String password;

    /**
    * 最后登录时间
    */
    @ApiModelProperty("最后登录时间") 
    @NotNull(message = "最后登录时间不能为空", groups = {Create.class,Update.class,Delete.class})
    @Size( max = 19,message = "最后登录时间长度限制19位")
    private Date lastLoginDate;

    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间") 
    @NotNull(message = "创建时间不能为空", groups = {Create.class,Update.class,Delete.class})
    @Size( max = 19,message = "创建时间长度限制19位")
    private Date createDate;

    public AdminVo() {}
}
