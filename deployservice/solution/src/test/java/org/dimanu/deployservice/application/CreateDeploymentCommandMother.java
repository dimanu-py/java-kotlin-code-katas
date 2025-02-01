package org.dimanu.deployservice.application;

public class CreateDeploymentCommandMother {

    private static final String ANY_VERSION = "1.0.0";
    private static final boolean SUCCESS = true;

    public static CreateDeploymentCommand successful() {
        return new CreateDeploymentCommand(
                ANY_VERSION,
                SUCCESS
        );
    }
}
