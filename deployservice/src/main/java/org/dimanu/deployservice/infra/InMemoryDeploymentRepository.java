package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.domain.Deployment;
import org.dimanu.deployservice.domain.DeploymentRepository;

import java.util.HashMap;

public class InMemoryDeploymentRepository implements DeploymentRepository {

        private final HashMap<String, Deployment> deployments = new HashMap<>();

        @Override
        public void save(Deployment deployment) {
                deployments.put(deployment.version(), deployment);
        }

        @Override
        public Deployment searchBy(String version) {
                return deployments.get(version);
        }
}
