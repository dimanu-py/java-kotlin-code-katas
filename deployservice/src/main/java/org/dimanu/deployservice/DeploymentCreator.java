package org.dimanu.deployservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeploymentCreator {

    private final DeploymentRepository deploymentRepository;

    @Autowired
    public DeploymentCreator(DeploymentRepository deploymentRepository) {
        this.deploymentRepository = deploymentRepository;
    }

    public void create(CreateDeploymentCommand command) {
        DeploymentVersion version = new DeploymentVersion(command.getVersion());
        DeploymentSuccess success = new DeploymentSuccess(command.getSuccess());
        Deployment deployment = new Deployment(version, success);

        deploymentRepository.save(deployment);
    }
}
