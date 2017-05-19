package org.ardias.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.dropwizard.Configuration;

public class MainConfig extends Configuration {

    private String usersSearchUrl;

    public void setUsersSearchUrl(final String usersSearchUrl) {
        this.usersSearchUrl = usersSearchUrl;
    }

    @JsonProperty("usersSearchUrl")
    public String getUsersSearchUrl() {
        return usersSearchUrl;
    }

}


