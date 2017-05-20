package org.ardias.github.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.ardias.github.core.GitHubUser;

import java.util.Arrays;

/**
 * Container class for GitHub search results
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubSearchResult {

    private GitHubUser[] items;

    @JsonCreator
    GitHubSearchResult(@JsonProperty("items") GitHubUser[] items) {
        this.items = Arrays.copyOf(items, items.length);
    }

    /**
     * Returns a copy of the results array. This avoids changing the results but uses
     * more memory. In some scenarios may not be appropriate
     * @return the list of items
     */
    public GitHubUser[] getItems() {
        return Arrays.copyOf(this.items, this.items.length);
    }
}
