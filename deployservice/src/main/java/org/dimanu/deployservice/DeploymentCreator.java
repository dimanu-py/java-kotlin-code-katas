package org.dimanu.deployservice;

public class DeploymentCreator {

    private final DeploymentRepository deploymentRepository;

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
