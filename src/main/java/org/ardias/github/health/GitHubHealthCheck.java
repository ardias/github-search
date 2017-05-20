package org.ardias.github.health;

import com.codahale.metrics.health.HealthCheck;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
public class GitHubHealthCheck extends HealthCheck {

    private Client client;
    private String healthCheckUrl;

    public GitHubHealthCheck(Client client, String healthCheckUrl) {
        this.client = client;
        this.healthCheckUrl = healthCheckUrl;
    }

    @Override
    protected Result check() throws Exception {
        HealthCheckResponse healthCheckResponse = client.target(healthCheckUrl).request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(HealthCheckResponse.class);

        Result result;
        switch (healthCheckResponse.getStatus()) {
            default:
            case GOOD:
                result = Result.healthy();
                break;
            case MINOR:
                result = Result.healthy("There are some minor issues with the service");
                break;
            case RED:
                result = Result.unhealthy("Service is not functioning properly");
                break;
        }
        return result;
    }
}
