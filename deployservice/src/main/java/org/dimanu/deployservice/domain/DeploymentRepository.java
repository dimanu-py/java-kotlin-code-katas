package org.dimanu.deployservice.domain;

public interface DeploymentRepository {

    public void save(Deployment deployment);

    public Deployment searchBy(String version);
}
