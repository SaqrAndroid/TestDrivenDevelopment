package com.database;

import java.util.List;

import com.article.Article;

public interface ArticleDataAccess {
    /**
     * @return all the articles from today
     */
    List<Article> getTodaysArticles();
}
