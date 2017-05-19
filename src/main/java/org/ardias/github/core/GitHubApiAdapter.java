package org.ardias.github.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public class GitHubApiAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubApiAdapter.class);

    private String searchUrl;

    public GitHubApiAdapter(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public List<GitHubUser> searchTopUsersInLocation(String location, TopSearchParam topSearchParam) {
        //location:Barcelona+sort:repositories&type=Users&per_page=5
        String finalUrl = String.format("%s%s", this.searchUrl, topSearchParam.getVal());
        LOGGER.debug("Searching users using url: {}", finalUrl);

        Invocation invocation = ClientBuilder.newClient()
                .target(finalUrl)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .buildGet();
        GitHubUsersSearchResult result = invocation.invoke(GitHubUsersSearchResult.class);
        return Arrays.asList(result.getItems());
    }
}
