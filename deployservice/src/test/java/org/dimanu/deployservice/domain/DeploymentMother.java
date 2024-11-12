package org.dimanu.deployservice.domain;

public class DeploymentMother {

    public static Deployment successful() {
        return new Deployment(
                DeploymentVersionMother.first(),
                DeploymentSuccessMother.successful(),
                DeploymentTimeCreationMother.any());
    }

    public static Deployment withVersion(String version) {
        return new Deployment(
                DeploymentVersionMother.create(version),
                DeploymentSuccessMother.successful(),
                DeploymentTimeCreationMother.any());
    }
}
