package org.dimanu.deployservice.application;

import org.dimanu.deployservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeploymentCreator {

    private final DeploymentRepository deploymentRepository;
    private final Clock clock;

    @Autowired
    public DeploymentCreator(DeploymentRepository deploymentRepository, Clock clock) {
        this.deploymentRepository = deploymentRepository;
        this.clock = clock;
    }

    public void create(CreateDeploymentCommand command) {
        DeploymentVersion version = new DeploymentVersion(command.getVersion());
        DeploymentSuccess success = new DeploymentSuccess(command.getSuccess());
        DeploymentTimeCreation time = new DeploymentTimeCreation(clock.now());

        Deployment deployment = new Deployment(version, success, time);

        deploymentRepository.save(deployment);
    }
}
