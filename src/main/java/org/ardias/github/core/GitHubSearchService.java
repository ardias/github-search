package org.ardias.github.core;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public interface GitHubSearchService {

    GitHubSearchResult searchTopUsersByRepos(TopSearchParam topParam);
    GitHubSearchResult searchTopUserByReposInCity(String city, TopSearchParam topParam);
}
