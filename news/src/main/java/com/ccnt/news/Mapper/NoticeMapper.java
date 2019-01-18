package com.ccnt.news.Mapper;

import com.ccnt.news.Domain.NoticeResource;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Mapper
public interface NoticeMapper {
    @Select("select * from news_resource where news_id = #{id};")
//    @Results(id = "newsMap", value = {
//            @Result(column = "news_id", property = "id"),
//            @Result(column = "news_author", property = "author"),
//            @Result(column = "news_title", property = "title"),
//            @Result(column = "news_url", property = "url"),
//            @Result(column = "news_type", property = "newsType"),
//
//    })
    NoticeResource selectNewsById(@Param("id") Integer id);

    @Select("select * from news_resource where news_type = #{newsType} ORDER BY submit_time desc;")
    List<NoticeResource> selectNewsByType(@Param("newsType") String newsType);

    @Select("select * from news_resource ORDER BY submit_time desc LIMIT 5;")
    List<NoticeResource> selectNewsByDate();

    @Select("select * from news_resource ORDER BY submit_time desc;")
    List<NoticeResource> selectAllNews();

    @Insert("insert into news_resource(news_author, news_title, news_url, news_type, submit_time) values(#{d.newsAuthor}, #{d.newsTitle}, #{d.newsUrl}, #{d.newsType}, #{d.submitTime})")
    int add(@Param("d") NoticeResource noticeResources);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int deleteByIds(@Param("list") List<String> ids);
    class Provider {

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM news_resource WHERE news_id IN (");
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

