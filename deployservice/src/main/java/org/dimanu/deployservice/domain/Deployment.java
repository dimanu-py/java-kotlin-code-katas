package org.dimanu.deployservice.domain;

import java.util.Objects;

public class Deployment {

    private final DeploymentVersion version;
    private final DeploymentSuccess success;

    public Deployment(DeploymentVersion version, DeploymentSuccess success) {
        this.version = version;
        this.success = success;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Deployment deployment = (Deployment) object;
        return version.equals(deployment.version) && success.equals(deployment.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, success);
    }

}
