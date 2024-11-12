package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.application.CreateDeploymentCommand;
import org.dimanu.deployservice.application.DeploymentCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deployments")
public class CreateDeploymentController {

    private final DeploymentCreator deploymentCreator;

    @Autowired
    public CreateDeploymentController(DeploymentCreator deploymentCreator) {
        this.deploymentCreator = deploymentCreator;
    }

    @PostMapping
    public ResponseEntity<Void> createDeployment(CreateDeploymentCommand command) {
        deploymentCreator.create(command);

        return ResponseEntity.created(null).build();
    }
}
