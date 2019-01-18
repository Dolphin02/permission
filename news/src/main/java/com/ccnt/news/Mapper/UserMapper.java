package com.ccnt.news.Mapper;

import com.ccnt.news.Domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Mapper
public interface UserMapper {
    @Select("select * from user where user_id = #{id};")
    User selectUserById(@Param("id") Integer id);

//    @Select("select * from user where user_type = #{userType} ORDER BY submit_time desc;")
//    List<User> selectUserByType(@Param("newsType") String newsType);

    @Select("select * from user ORDER BY submit_time desc LIMIT 5;")
    List<User> selectUserByDate();

    @Select("select * from user ORDER BY submit_time desc;")
    List<User> selectAllUsers();

    @Update("update user set level = 1 where user_id = #{id}")
    int updateUserLevel(@Param("id") Integer id);

    @Update("update user set password = #{pwd} where user_id = #{id}")
    int updatePassword(@Param("id") Integer id, @Param("pwd") String pwd);

    @Insert("insert into user(username, password, level, submit_time) values(#{u.username}, #{u.password}, #{u.level}, #{u.submitTime})")
    int add(@Param("u") User user);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int deleteByIds(@Param("list") List<String> ids);
    class Provider {
        /* 批量删除 */
        public String batchDelete(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM user WHERE user_id IN (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append("'").append(ids.get(i)).append("'");
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }
}

