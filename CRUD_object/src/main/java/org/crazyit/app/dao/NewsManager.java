package org.crazyit.app.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.crazyit.app.domain.News;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NewsManager {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //1.创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.打开sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //保存消息
//        saveNews(sqlSession);
        //更新消息
//        updateNews(sqlSession);
        //删除消息
//        deleteNews(sqlSession);
        //查询消息
        selectNews(sqlSession);

    }

    public static void saveNews(SqlSession sqlSession) {
        News news = new News(null, "测试标题", "测试内容");
        //3.调用sqlSession的insert、update、delete、select等方法
        sqlSession.insert("mapper.NewsMapper.saveNews", news);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void updateNews(SqlSession sqlSession) {
        News news = new News(2, "更新标题", "更新内容");
        //3.调用sqlSession的insert、update、delete、select等方法
        sqlSession.update("mapper.NewsMapper.updateNews", news);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void deleteNews(SqlSession sqlSession) {
        //3.调用sqlSession的insert、update、delete、select等方法
        sqlSession.insert("mapper.NewsMapper.deleteNews", 9);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void selectNews(SqlSession sqlSession) {
        //3.调用sqlSession的insert、update、delete、select等方法
        List<?> list = sqlSession.selectList("mapper.NewsMapper.findNews", -1);
        System.out.println(list);
        sqlSession.commit();
        sqlSession.close();
    }
}