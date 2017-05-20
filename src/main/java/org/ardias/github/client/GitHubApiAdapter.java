package org.ardias.github.client;

import org.ardias.github.core.GitHubSearchResult;
import org.ardias.github.core.TopSearchParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public class GitHubApiAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubApiAdapter.class);

    private Client client;
    private String searchUrl;

    public GitHubApiAdapter(Client client, String searchUrl) {
        this.client = client;
        this.searchUrl = searchUrl;
    }

    /**
     *  Make a search request to GitHub for the top users based on a city
     * @param location the city where to look for users
     * @param topSearchParam the top N users (5,10,50)
     * @return list of user logins that match the search params
     */
    public GitHubSearchResult searchTopUsersInLocation(String location, TopSearchParam topSearchParam) {
        String searchUrl = makeSearchUrl(location, topSearchParam.getVal());
        LOGGER.debug("Searching users using url: {}", searchUrl);

        Invocation invocation = this.client
                .target(searchUrl)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .buildGet();
        GitHubSearchResult result = invocation.invoke(GitHubSearchResult.class);
        LOGGER.debug("Search request returned {} items", result.getItems().length);
        return result;
    }

    private String makeSearchUrl(String location, String resultsLimit) {
        return this.searchUrl
                .replace("$CITY", location)
                .replace("$LIMIT", resultsLimit);
    }
}
