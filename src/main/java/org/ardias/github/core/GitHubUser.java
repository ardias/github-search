package org.ardias.github.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubUser {

    private String userName;

    GitHubUser(){}

    public GitHubUser(String userName) {
        this.userName = userName;
    }

    @JsonProperty("login")
    public String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }
}
