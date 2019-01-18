package com.ccnt.news.Factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class FKSqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory = null;
    // 初始化创建SqlSessionFactory对象

//    static{
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            // 读取mybatis-config.xml文件
//            sqlSessionFactory = new SqlSessionFactoryBuilder()
//                    .build(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static SqlSession getSqlSession(){
//        // 获取SqlSession对象的静态方法
//        return sqlSessionFactory.openSession();
//    }
//
//    public static SqlSessionFactory getSqlSessionFactory() {
//        // 获取SqlSessionFactory的静态方法
//        return sqlSessionFactory;
//    }
}