package org.ardias.github.core;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
public interface GitHubSearchService {

    List<GitHubUser> doSearch(TopSearchParam topParam);
}
