package org.ardias.github.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class HealthCheckResponse {


    private String status;

    @JsonCreator
    public HealthCheckResponse(@JsonProperty("status") String status) {
        this.status = status;
    }

    public GitHubStatus getStatus() {
        return GitHubStatus.valueOf(this.status.toUpperCase());
    }

    public enum GitHubStatus {
        GOOD,
        MINOR,
        RED
    }
}
