package org.ardias.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MainConfig extends Configuration {

    @Valid @NotNull
    private String usersSearchUrl;

    @Valid @NotNull
    private JerseyClientConfiguration jerseyClientConfiguration = new JerseyClientConfiguration();

    public void setUsersSearchUrl(final String usersSearchUrl) {
        this.usersSearchUrl = usersSearchUrl;
    }

    @JsonProperty("usersSearchUrl")
    public String getUsersSearchUrl() {
        return usersSearchUrl;
    }

    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

}


