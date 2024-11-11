package org.dimanu.deployservice;

import lombok.Data;

@Data
public class CreateDeploymentCommand {
    private final String version;
    private final Boolean success;
}
