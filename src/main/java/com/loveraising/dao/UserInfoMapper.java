package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.UserInfo;

import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select id,user_name,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role_id from userinfo")
    List<UserInfo> findAll();
    @Insert("insert into userinfo(user_name,password,real_name,sex,email,telephone,birthday,id_number,creat_time) " +
            "values(#{userName},#{password},#{realName},#{sex},#{email},#{telephone},#{birthday},#{idNumber},#{creatTime})")
    int insertUserInfo(UserInfo userInfo);
    @Update("update userinfo set status=#{status} where id = #{id}")
    int updateStatus(UserInfo userInfo);
    @Select("select id,user_name,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role_id " +
            "from userinfo where id = #{id}")
    UserInfo selectUserInfo(int id);
    @Select(value = "select id,user_name,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role_id " +
            "from userinfo where locate(#{keyword},user_name)>0 OR locate(#{keyword},real_name)>0 OR " +
            "locate(#{keyword},role_id)>0 OR locate(#{keyword},email)>0 OR locate(#{keyword},birthday)>0 " +
            "OR locate(#{keyword},telephone)>0 limit #{beginIndex},#{pageSize}")
    List<UserInfo> findByKeyWord(PageBean<UserInfo> pageBean);
    @Select(value = "SELECT count(id) from userinfo where locate(#{keyword},user_name)>0 OR locate(#{keyword},real_name)>0 OR " +
            "locate(#{keyword},role_id)>0 OR locate(#{keyword},email)>0 OR locate(#{keyword},birthday)>0 " +
            "OR locate(#{keyword},telephone)>0")
    int countByKeyWord(String keyword);
    @Insert("insert into userinfo(user_name,password,role_id) values(#{userName},#{password},#{roleId})")
    int insertAdmin(UserInfo userInfo);
    @Select("select id,user_name,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role_id " +
            "from userinfo where user_name=#{userName}")
    List<UserInfo> checkUserName(String userName);
    @Select("select id,user_name,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role_id " +
            "from userinfo where user_name=#{userName}")
    List<UserInfo> selectUserInfos(String userName);
    @Select("select id,user_name,real_name,remaining_sum from userinfo where id=#{id}")
    UserInfo selectUserWallet(int id);
    @Update("update userinfo set remaining_sum = remaining_sum+#{add} where id=#{id}")
    int addRemainingSum(@Param("id")int id,@Param("add")double add);
    @Update("update userinfo set remaining_sum = remaining_sum-${add} where id=#{id}")
    int cutRemainSum(@Param("id")int userId,@Param("add")double add);
    @Select("select remaining_sum-${add} from userinfo where id = #{id}")
    double selectSum(@Param("id")int userId,@Param("add")double add);
    @Update("update userinfo set last_login = #{lastLogin} where id = #{id}")
    int updateLastLogin(@Param("id")int id, @Param("lastLogin")String lastLogin);

}