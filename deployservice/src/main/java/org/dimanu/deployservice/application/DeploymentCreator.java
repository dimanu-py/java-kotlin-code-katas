package org.dimanu.deployservice.application;

import org.dimanu.deployservice.domain.Deployment;
import org.dimanu.deployservice.domain.DeploymentRepository;
import org.dimanu.deployservice.domain.DeploymentSuccess;
import org.dimanu.deployservice.domain.DeploymentVersion;
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
