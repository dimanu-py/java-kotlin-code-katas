package org.dimanu.deployservice.domain;

import java.util.List;

public interface DeploymentRepository {

    void save(Deployment deployment);

    Deployment searchBy(String version);

    List<Deployment> searchAll();
}
