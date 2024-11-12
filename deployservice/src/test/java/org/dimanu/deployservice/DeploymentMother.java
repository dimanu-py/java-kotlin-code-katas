package org.dimanu.deployservice;

public class DeploymentMother {

    public static Deployment successful() {
        return new Deployment(
                DeploymentVersionMother.first(),
                DeploymentSuccessMother.successful()
        );
    }
}
