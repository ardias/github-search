package org.ardias.github.core;

import org.ardias.github.client.GitHubApiAdapter;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public class GitHubSearchServiceImpl implements GitHubSearchService {

    private static final String CITY_DEFAULT = "Barcelona";
    private GitHubApiAdapter apiAdapter;

    public GitHubSearchServiceImpl(GitHubApiAdapter apiAdapter) {
        this.apiAdapter = apiAdapter;
    }

    @Override
    public GitHubSearchResult searchTopUsersByRepos(TopSearchParam topParam) {
        return searchTopUserByReposInCity(CITY_DEFAULT, topParam);
    }

    @Override
    public GitHubSearchResult searchTopUserByReposInCity(String city, TopSearchParam topParam) {
        GitHubSearchResult gitHubSearchResult = apiAdapter.searchTopUsersInLocation(city, topParam);
        return gitHubSearchResult;
    }
}
