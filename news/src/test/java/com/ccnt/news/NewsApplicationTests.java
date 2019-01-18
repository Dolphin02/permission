package com.ccnt.news;

import com.ccnt.news.Domain.NoticeResource;
import com.ccnt.news.Factory.FKSqlSessionFactory;
import com.ccnt.news.Mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApplicationTests {

    @Test
    public void contextLoads() {
//        SqlSession session = FKSqlSessionFactory.getSqlSession();
//        // 创建Session实例
//        NoticeMapper noticeMapper = session.getMapper(NoticeMapper.class);
//        NoticeResource noticeResource = noticeMapper.selectNewsById(1l);
//        // 调用selectWhitParam方法
//        System.out.println(noticeResource);
//        session.commit();
//        // 提交事务
//        session.close();
//        // 关闭Session
    }
}
