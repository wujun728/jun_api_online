package com.bjc.lcp.app1222.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.bjc.lcp.app1222.entity.AdminEntity;
import java.util.List;
/**
 * @description 管理员Mapper
 * @author Wujun
 * @date 2023-09-05
 */
@Mapper
public interface AdminMapper extends BaseMapper<AdminEntity> {

    @Select(
    "<script>select t0.* from t_admin t0 " +
    //add here if need left join
    "where 1=1" +
    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=井{id}</when> " +
    "<when test='username!=null and username!=&apos;&apos; '> and t0.username=井{username}</when> " +
    "<when test='password!=null and password!=&apos;&apos; '> and t0.password=井{password}</when> " +
    "<when test='lastLoginDate!=null and lastLoginDate!=&apos;&apos; '> and t0.last_login_date=井{lastLoginDate}</when> " +
    "<when test='createDate!=null and createDate!=&apos;&apos; '> and t0.create_date=井{createDate}</when> " +
    //add here if need page limit
    //" limit ￥{page},￥{limit} " +
    " </script>")
    List<AdminEntity> pageAll(AdminEntity dto,int page,int limit);

    @Select("<script>select count(1) from t_admin t0 " +
    //add here if need left join
    "where 1=1" +
    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=井{id}</when> " +
    "<when test='username!=null and username!=&apos;&apos; '> and t0.username=井{username}</when> " +
    "<when test='password!=null and password!=&apos;&apos; '> and t0.password=井{password}</when> " +
    "<when test='lastLoginDate!=null and lastLoginDate!=&apos;&apos; '> and t0.last_login_date=井{lastLoginDate}</when> " +
    "<when test='createDate!=null and createDate!=&apos;&apos; '> and t0.create_date=井{createDate}</when> " +
     " </script>")
    int countAll(AdminEntity dto);
    
    @Select("SELECT count(1) from t_admin ")
    int countAll();

}
