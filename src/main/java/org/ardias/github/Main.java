package org.ardias.github;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.ardias.github.core.GitHubApiAdapter;
import org.ardias.github.core.GitHubSearchService;
import org.ardias.github.core.GitHubSearchServiceImpl;
import org.ardias.github.resources.GitHubSearchResource;

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
        // TODO: application initialization
    }

    @Override
    public void run(final MainConfig mainConfig, final Environment environment) throws Exception {
        final GitHubApiAdapter apiAdapter = new GitHubApiAdapter(mainConfig.getUsersSearchUrl());
        final GitHubSearchService searchService = new GitHubSearchServiceImpl(apiAdapter);
        environment.jersey().register(new GitHubSearchResource(searchService));
    }

}
