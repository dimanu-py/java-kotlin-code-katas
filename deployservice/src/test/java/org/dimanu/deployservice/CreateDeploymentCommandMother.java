package org.dimanu.deployservice;

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
