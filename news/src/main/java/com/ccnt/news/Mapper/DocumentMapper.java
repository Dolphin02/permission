package com.ccnt.news.Mapper;

import com.ccnt.news.Domain.Document;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface DocumentMapper {
    @Select("select * from document where document_id = #{id};")
    Document selectFileById(@Param("id") Integer id);

    @Insert("insert into document(document_author, document_name, document_title, document_url, document_type, document_remark,submit_time) values(#{d.documentAuthor}, #{d.documentName}, #{d.documentTitle}, #{d.documentUrl}, #{d.documentType}, #{d.documentRemark}, #{d.submitTime})")
    int add(@Param("d") Document document);

    @DeleteProvider(type = Provider.class, method = "batchDelete")
    int deleteByIds(@Param("list") List<String> ids);

    @Select("select * from document where document_type = #{documentType} ORDER BY submit_time desc;")
    List<Document> selectFileByType(@Param("documentType") String documentType);

    @Select("select * from document ORDER BY submit_time desc LIMIT 5;")
    List<Document> selectFileByDate();

    @Select("select * from document ORDER BY submit_time desc;")
    List<Document> selectAllFile();

    class Provider {

        /* 批量删除 */
        public String batchDelete(Map map) {
            List<String> ids = (List<String>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM document WHERE document_id IN (");
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
