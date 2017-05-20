package org.ardias.github;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.ardias.github.auth.SimpleBasicAuthenticator;
import org.ardias.github.auth.User;
import org.ardias.github.client.GitHubApiAdapter;
import org.ardias.github.core.GitHubSearchService;
import org.ardias.github.core.GitHubSearchServiceImpl;
import org.ardias.github.db.InMemoryUseRepository;
import org.ardias.github.health.GitHubHealthCheck;
import org.ardias.github.resources.GitHubSearchResource;

import javax.ws.rs.client.Client;

public class Main extends Application<MainConfig> {

    public static void main(final String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "github-search";
    }

    @Override
    public void initialize(final Bootstrap<MainConfig> bootstrap) {
    }

    @Override
    public void run(final MainConfig mainConfig, final Environment environment) throws Exception {

        //would be interesting to test the new Rx implementation..
        final Client jerseyClient = new JerseyClientBuilder(environment)
                .using(mainConfig.getJerseyClientConfiguration())
                .build(getName());
        final GitHubApiAdapter apiAdapter = new GitHubApiAdapter(jerseyClient, mainConfig.getUsersSearchUrl());
        final GitHubSearchService searchService = new GitHubSearchServiceImpl(apiAdapter);
        environment.jersey().register(new GitHubSearchResource(searchService));
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new SimpleBasicAuthenticator(new InMemoryUseRepository()))
                        .buildAuthFilter()));
        environment.healthChecks().register("gitHubStatus",
                new GitHubHealthCheck(jerseyClient, mainConfig.getGitHubHealthCheckUrl()));
    }

}
