package com.client;

import com.article.Article;

/**
 * A target for relevant articles
 */
public interface Channel {
    /**
     * Call this to send an article to its destination.
     * @param article the article to send
     */
    void accept(Article article);
}
