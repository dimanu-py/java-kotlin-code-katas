package org.dimanu.deployservice.domain;

import java.util.Objects;

public class DeploymentVersion {
    private final String version;

    public DeploymentVersion(String version) {
        if(version == null) {
            throw new IllegalArgumentException("Version cannot be null");
        }
        if (version.isEmpty()) {
            throw new IllegalArgumentException("Version cannot be empty");
        }
        this.version = version;
    }

    public String version() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeploymentVersion that = (DeploymentVersion) o;
        return Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }
}
