package com.bjc.lcp.app1222.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jun.plugin.common.entity.BaseEntity;

/**
 * @description 管理员
 * @author Wujun
 * @date 2023-09-05
 */
@Data
@TableName("t_admin")
public class AdminEntity  extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    @TableId(value = "id" ,type = IdType.AUTO )
    private Long id;

    /**
    * 用户名
    */
    @TableField(value = "username" )
    private String username;

    /**
    * 密码
    */
    @TableField(value = "password" )
    private String password;

    /**
    * 最后登录时间
    */
    @TableField(value = "last_login_date" )
    private Date lastLoginDate;

    /**
    * 创建时间
    */
    @TableField(value = "create_date" )
    private Date createDate;

    public AdminEntity() {}
}
