package org.dimanu.deployservice.application;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeploymentResponse {
    private final String version;
    private final Boolean success;
    private final LocalDateTime timestamp;

    public DeploymentResponse(String version, Boolean success, LocalDateTime creationDate) {
        this.version = version;
        this.success = success;
        this.timestamp = creationDate;
    }
}
