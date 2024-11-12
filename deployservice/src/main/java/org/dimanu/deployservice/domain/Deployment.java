package org.dimanu.deployservice.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Deployment {

    private final DeploymentVersion version;
    private final DeploymentSuccess success;
    private final DeploymentTimeCreation timestamp;

    public Deployment(DeploymentVersion version, DeploymentSuccess success, DeploymentTimeCreation timestamp) {
        this.version = version;
        this.success = success;
        this.timestamp = timestamp;
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

    public String version() {
        return version.value();
    }

    public Map<String, Object> value() {
        HashMap<String, Object> primitiveRepresentation = new HashMap<>();

        primitiveRepresentation.put("version", version.value());
        primitiveRepresentation.put("success", success.value());
        primitiveRepresentation.put("timestamp", timestamp.value());

        return primitiveRepresentation;
    }
}
