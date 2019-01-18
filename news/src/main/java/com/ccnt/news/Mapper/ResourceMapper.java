package com.ccnt.news.Mapper;

import com.ccnt.news.Domain.Resources;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface ResourceMapper {
    @Select("select * from resource where resource_id = #{id};")
    Resources selectResourceById(@Param("id") Integer id);

    @Select("select * from resource where resource_type = #{resourceType} ORDER BY submit_time desc;")
    List<Resources> selectResourceByType(@Param("resourceType") String resourceType);

    @Select("select * from resource ORDER BY submit_time desc LIMIT 5;")
    List<Resources> selectResourceByDate();

    @Select("select * from resource ORDER BY submit_time desc;")
    List<Resources> selectAllResources();

    @Insert("insert into resource(resource_author, resource_title, resource_url, resource_type, resource_remark,submit_time) values(#{d.resourceAuthor}, #{d.resourceTitle}, #{d.resourceUrl}, #{d.resourceType}, #{d.resourceRemark}, #{d.submitTime})")
    int add(@Param("d") Resources resources);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int deleteByIds(@Param("list") List<String> ids);
    class Provider {

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM resource WHERE resource_id IN (");
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
