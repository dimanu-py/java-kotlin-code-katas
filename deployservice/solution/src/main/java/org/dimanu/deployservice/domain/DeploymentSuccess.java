package org.dimanu.deployservice.domain;

import java.util.Objects;

public class DeploymentSuccess {
    private final Boolean success;

    public DeploymentSuccess(Boolean success) {
        if (success == null) {
            throw new IllegalArgumentException("success cannot be null");
        }
        this.success = success;
    }

    public Boolean value() {
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeploymentSuccess that = (DeploymentSuccess) o;
        return Objects.equals(success, that.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }
}
