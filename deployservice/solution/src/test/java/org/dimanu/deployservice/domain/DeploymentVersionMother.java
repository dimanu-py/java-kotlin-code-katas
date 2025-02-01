package org.dimanu.deployservice.domain;

public class DeploymentVersionMother {

    public static DeploymentVersion first() {
        return new DeploymentVersion("1.0.0");
    }

    public static DeploymentVersion create(String version) {
        return new DeploymentVersion(version);
    }
}
