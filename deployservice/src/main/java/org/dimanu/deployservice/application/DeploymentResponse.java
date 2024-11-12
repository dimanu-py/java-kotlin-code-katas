package org.dimanu.deployservice.application;

import lombok.Data;

@Data
public class DeploymentResponse {
    private final String version;
    private final Boolean success;

    public DeploymentResponse(String version, Boolean success) {
        this.version = version;
        this.success = success;
    }
}
