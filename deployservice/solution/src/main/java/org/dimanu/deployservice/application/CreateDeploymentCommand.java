package org.dimanu.deployservice.application;

import lombok.Data;

@Data
public class CreateDeploymentCommand {
    private final String version;
    private final Boolean success;
}
