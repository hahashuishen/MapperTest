package org.crazyit.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.crazyit.app.dao.NewsMapper;
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
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //保存消息
        saveNews(sqlSession);
        //更新消息
        updateNews(sqlSession);
        //删除消息
        deleteNews(sqlSession);
        //查询消息
        selectNews(sqlSession);

    }
    public static void saveNews(SqlSession sqlSession)
    {
        News news= new News(null,"mapper111标题","mapper111内容");
        //3.调用sqlSession的insert、update、delete、select等方法
        NewsMapper newsMapper= sqlSession.getMapper(NewsMapper.class);
        newsMapper.saveNews(news);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void updateNews(SqlSession sqlSession)
    {
        News news= new News(8,"更新Mapper标题","更新Mapper内容");
        NewsMapper newsMapper= sqlSession.getMapper(NewsMapper.class);
        newsMapper.updateNews(news);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void deleteNews(SqlSession sqlSession)
    {
        NewsMapper newsMapper= sqlSession.getMapper(NewsMapper.class);
        newsMapper.deleteNews(14);
        sqlSession.commit();
        sqlSession.close();
    }
    public static void selectNews(SqlSession sqlSession)
    {
        NewsMapper newsMapper= sqlSession.getMapper(NewsMapper.class);
        List<?> list=newsMapper.findNews(-1);
        System.out.println(list);
        sqlSession.commit();
        sqlSession.close();
    }
}
