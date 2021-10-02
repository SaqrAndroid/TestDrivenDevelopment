package com.sender;

import com.article.Article;
import com.client.EntertainmentChannel;
import com.client.OtherChannel;
import com.client.SportsChannel;
import com.database.ArticleDataAccess;

/**
 * Work through today's articles sending them out to the right places
 */
public class ArticleDistributor {
    private SportsChannel sport;
    private EntertainmentChannel entertainment;
    private OtherChannel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays() {
        for(Article article:dataAccess.getTodaysArticles()) {
            switch(article.getType()) {
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    other.accept(article);
                    break;
            }
        }
    }
}
