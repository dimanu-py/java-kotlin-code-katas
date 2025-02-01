package org.dimanu.deployservice.domain;

import java.time.LocalDateTime;

public class DeploymentTimeCreation {
    private final LocalDateTime timestamp;

    public DeploymentTimeCreation(LocalDateTime timestamp) {
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.timestamp = timestamp;
    }

    public LocalDateTime value() {
        return timestamp;
    }
}
