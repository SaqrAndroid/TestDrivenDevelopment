package com.sender;

import org.junit.Test;

import com.article.Article;
import com.article.Type;
import com.client.Channel;
import com.database.ArticleDataAccess;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ArticleDistributorTest {
    @Test
    public void sportGoesToSportPoliticsToOther() {
        Channel sport = mock(Channel.class);
        Channel entertainment = mock(Channel.class);
        Channel other = mock(Channel.class);
        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);

        // given this list of articles is returned from the database
        List<Article> list = asList(
                new Article("Sport is fun", Type.SPORT),
                new Article("Politics is sad", Type.POLITICS));

        when(dataAccess.getTodaysArticles()).thenReturn(list);

        // when we distribute
        distributor.distributeTodays();

        // then one goes to sport and one goes to other
        verify(sport).accept(any());
        verify(other).accept(any());
        verify(entertainment, never()).accept(any());

    }
}