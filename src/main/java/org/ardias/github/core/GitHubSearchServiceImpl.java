package org.ardias.github.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public class GitHubSearchServiceImpl implements GitHubSearchService {

    private GitHubApiAdapter apiAdapter;

    public GitHubSearchServiceImpl(GitHubApiAdapter apiAdapter) {
        this.apiAdapter = apiAdapter;
    }

    @Override
    public List<GitHubUser> doSearch(TopSearchParam topParam) {
        return apiAdapter.searchTopUsersInLocation("Barcelona", topParam);
    }
}
