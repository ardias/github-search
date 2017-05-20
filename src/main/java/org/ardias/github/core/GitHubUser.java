package org.ardias.github.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubUser {

    private String login;

    @JsonCreator
    public GitHubUser(@JsonProperty("login") String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

}
