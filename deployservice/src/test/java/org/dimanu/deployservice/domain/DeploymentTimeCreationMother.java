package org.dimanu.deployservice.domain;

import java.time.LocalDateTime;

public class DeploymentTimeCreationMother {

    private static final LocalDateTime DATE = LocalDateTime.of(2021, 10, 1, 17, 30, 10);

    public static DeploymentTimeCreation any() {
        return new DeploymentTimeCreation(DATE);
    }

    public static LocalDateTime mockDate() {
        return DATE;
    }
}
