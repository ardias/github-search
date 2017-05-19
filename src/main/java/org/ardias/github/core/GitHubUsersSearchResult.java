package org.ardias.github.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubUsersSearchResult {

    private int totalCount;
    private GitHubUser[] items;

    @JsonProperty("total_count")
    public int getTotalCount() {
        return totalCount;
    }

    void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("items")
    public GitHubUser[] getItems() {
        return items;
    }

    void setItems(GitHubUser[] items) {
        this.items = Arrays.copyOf(items, items.length);
    }
}
