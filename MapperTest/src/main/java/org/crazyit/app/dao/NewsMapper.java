package org.crazyit.app.dao;

import org.crazyit.app.domain.News;

import java.util.List;

public interface NewsMapper {
    int saveNews(News news);
    int updateNews(News news);
    void deleteNews(Integer id);
    List<News> findNews (Integer id);

}
