package org.dimanu.deployservice;

import org.springframework.http.ResponseEntity;

public class CreateDeploymentController {

    private final DeploymentCreator deploymentCreator;

    public CreateDeploymentController(DeploymentCreator deploymentCreator) {
        this.deploymentCreator = deploymentCreator;
    }

    public ResponseEntity<Void> createDeployment(CreateDeploymentCommand command) {
        deploymentCreator.create(command);

        return ResponseEntity.created(null).build();
    }
}
